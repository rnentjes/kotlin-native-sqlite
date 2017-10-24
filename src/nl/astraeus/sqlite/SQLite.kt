package nl.astraeus.sqlite

import kotlinx.cinterop.*
import sqlite3.*

class ResultSet {

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

    fun executeQuery(
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
    }

    fun executeQuery(sql: String): ResultSet {
        memScoped {
            val stmt: CPointerVar<sqlite3_stmt> = alloc<CPointerVar<sqlite3_stmt>>()
            var rc = sqlite3_prepare_v2(sqlite.db.value, sql, -1, stmt.ptr, null)

            sqlite.checkResultCode(rc)

            rc = sqlite3_step(stmt.value)

            sqlite.checkResultCode(rc)

            if (rc == SQLITE_ROW) {
                val version = sqlite3_column_text(stmt.value, 0)?.toKString()
                println("VERSION: $version")
            }

            sqlite3_finalize(stmt.value)

            return ResultSet()
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
