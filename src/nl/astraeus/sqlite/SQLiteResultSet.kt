package nl.astraeus.sqlite

import kotlinx.cinterop.CPointerVar
import kotlinx.cinterop.toKString
import kotlinx.cinterop.value
import sqlite3.*
import cnames.structs.sqlite3_stmt
import kotlinx.cinterop.nativeHeap

/**
 * User: rnentjes
 * Date: 25-10-17
 * Time: 11:42
 */

class SQLiteResultSet(
  val stmt: CPointerVar<sqlite3_stmt>
): nl.astraeus.kdbc.ResultSet {

    var done = false

    override fun next(): Boolean {
        if (done) {
            return false
        }

        val rc = sqlite3_step(stmt.value)

        if (rc == SQLITE_DONE) {
            done = true

            sqlite3_finalize(stmt.value)
            nativeHeap.free(stmt.rawPtr)
        }

        return rc == SQLITE_ROW
    }

    override fun getString(index: Int): String {
        return sqlite3_column_text(stmt.value, index)?.toKString() ?: throw SQLiteException("", -1)
    }

    override fun getInt(index: Int): Int {
        return sqlite3_column_int(stmt.value, index)
    }

    override fun getLong(index: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBoolean(index: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
