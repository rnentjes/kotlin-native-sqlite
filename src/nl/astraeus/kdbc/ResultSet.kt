package nl.astraeus.kdbc

/**
 * User: rnentjes
 * Date: 25-10-17
 * Time: 11:42
 */

interface ResultSet {

    fun next(): Boolean

    fun getString(index: Int): String
    fun getInt(index: Int): Int
    fun getLong(index: Int): Long
    fun getBoolean(index: Int): Boolean
    //fun getDate(index: Int): Timestamp

}