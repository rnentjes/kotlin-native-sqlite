package nl.astraeus.sqlite

class SQLiteException(
  message: String,
  val code: Int
): Exception(message) {
    override fun toString(): String {
        return "SQLiteException(message=$message, code=$code)"
    }
}
