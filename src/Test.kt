import nl.astraeus.sqlite.ColumnType
import nl.astraeus.sqlite.SQLite

class Test(
  val name: String,
  val age: Int
)

fun main(args: Array<String>) {
/*
    val db: CPointerVar<sqlite3> = nativeHeap.alloc<CPointerVar<sqlite3>>()
    val res = nativeHeap.alloc<CPointerVar<sqlite3_stmt>>()
    var rc: Int

    println("SQLite ${sqlite3_libversion()?.toKString()}")

    rc = sqlite3_open("data/data.sqlite", db.ptr)

    println("rc: ${rc} == ${SQLITE_OK} - ${db}")

    rc = sqlite3_prepare_v2(db.value, "SELECT SQLITE_VERSION()", -1, res.ptr, null)

    println("rc: ${rc} == ${SQLITE_OK} - ${res}")

    rc = sqlite3_step(res.value)

    if (rc == SQLITE_ROW) {
        val version = sqlite3_column_text(res.value, 0)?.toKString()
        println("VERSION: $version")
    }

    sqlite3_finalize(res.value)
    sqlite3_close(db.value)
*/
    val sqlite = SQLite(":memory:")

    try {
        sqlite.transaction {
            execute("""
            DROP TABLE IF EXISTS Person;
            CREATE TABLE Person(name VARCHAR, age INT);
            INSERT INTO Person VALUES('Piet', 22);
            INSERT INTO Person VALUES('Klaas', 65);
        """.trimIndent())

            executeQuery(
              "SELECT * FROM Person",
              arrayOf(ColumnType.STRING, ColumnType.INTEGER),
              { data ->
                  println("Found ${data[0]} - ${data[1]}")
              })
        }
    } finally {
        sqlite.close()
    }

}
