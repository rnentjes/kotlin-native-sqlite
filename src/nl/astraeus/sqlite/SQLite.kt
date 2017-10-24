package nl.astraeus.sqlite

import kotlinx.cinterop.*
import sqlite3.*

class ResultSet<T>(
  val stmt: CPointerVar<sqlite3_stmt>,
  val types: Array<ColumnType>,
  val objectMapper: (data: Array<Any>) -> T
) {
    var done = false
    var next: T? = null

    fun hasNext(): Boolean {
        if (done) {
            return false
        }

        val rc = sqlite3_step(stmt.value)

        if (rc == SQLITE_DONE) {
            done = true
            next = null

            sqlite3_finalize(stmt.value)
        } else if (rc == SQLITE_ROW) {
            val row = Array<Any>(types.size, { "" })

            for (index in 0 until types.size) {
                when (types[index]) {
                    ColumnType.STRING -> {
                        row[index] = sqlite3_column_text(stmt.value, index)?.toKString() ?: SQLiteException("", -1)
                    }
                    ColumnType.INTEGER -> {
                        row[index] = sqlite3_column_int(stmt.value, index)
                    }
                    else -> {
                        row[index] = "Not implemented"
                    }

                }
            }

            next = objectMapper(row)
        }

        return rc == SQLITE_ROW
    }

    fun next(): T {
        val result = next
        if (done || result == null) {
            throw SQLiteException("ResultSet empty!", -1)
        } else {
            return result
        }
    }
}

enum class ColumnType {
    STRING,
    INTEGER,
    LONG,
    BOOLEAN,
    DATE
}

class Transaction(
  val sqlite: SQLite
) {

    fun execute(sql: String) {
        memScoped {
            val stmt: CPointerVar<sqlite3_stmt> = alloc<CPointerVar<sqlite3_stmt>>()
            val errorMsg: CPointerVar<ByteVar> = alloc()

            val rc = sqlite3_exec(sqlite.db.value, sql, null, null, errorMsg.ptr)

            sqlite.checkResultCode(rc)

            sqlite3_finalize(stmt.value)
        }
    }

    fun executeUpdate(sql: String): Int {
        return 0
    }

/*    fun executeQuery(
      sql: String,
      types: Array<ColumnType>,
      resultMapper: (data: Array<Any>) -> Unit
    ) {
        memScoped {
            val stmt: CPointerVar<sqlite3_stmt> = alloc<CPointerVar<sqlite3_stmt>>()
            var rc = sqlite3_prepare_v2(sqlite.db.value, sql, -1, stmt.ptr, null)

            sqlite.checkResultCode(rc)

            var done = false

            while (!done) {
                rc = sqlite3_step(stmt.value)

                if (rc == SQLITE_ROW) {
                    val row = Array<Any>(types.size, { "" })

                    for (index in 0 until types.size) {
                        when (types[index]) {
                            ColumnType.STRING -> {
                                row[index] = sqlite3_column_text(stmt.value, index)?.toKString() ?: SQLiteException("", -1)
                            }
                            ColumnType.INTEGER -> {
                                row[index] = sqlite3_column_int(stmt.value, index)
                            }
                            else -> {
                                row[index] = "Not implemented"
                            }

                        }
                    }

                    resultMapper(row)
                } else if (rc == SQLITE_DONE) {
                    done = true
                } else {
                    sqlite.checkResultCode(rc)
                }
            }

            sqlite3_finalize(stmt.value)
        }
    }*/

    fun <T> executeQuery(
      sql: String,
      types: Array<ColumnType>,
      objectMapper: (data: Array<Any>) -> T
    ): ResultSet<T> {
        memScoped {
            val stmt: CPointerVar<sqlite3_stmt> = alloc<CPointerVar<sqlite3_stmt>>()
            val rc = sqlite3_prepare_v2(sqlite.db.value, sql, -1, stmt.ptr, null)

            sqlite.checkResultCode(rc)

            return ResultSet(stmt, types, objectMapper)
        }
    }
}

class SQLite(
  val filename: String
) {
    var db: CPointerVar<sqlite3> = nativeHeap.alloc<CPointerVar<sqlite3>>()

    init {
        val rc = sqlite3_open("data/data.sqlite", db.ptr)

        checkResultCode(rc)
    }

    fun checkResultCode(rc: Int) {
        if (rc != SQLITE_OK) {
            throw SQLiteException(getError(), rc)
        }
    }

    fun getError() = sqlite3_errmsg(db.value)?.toKString() ?: "No error found"

    fun close() {
        sqlite3_close(db.value)

        nativeHeap.free(db)

    }

    fun transaction(block: Transaction.() -> Unit) {
        val transaction = Transaction(this)

        block(transaction)
    }
}

fun test() {
    val sql = SQLite(":memory:")

    sql.transaction {
        execute("UPDATE bla SET foo = 'bar' WHERE id = 12")
    }

    sql.close()
}
