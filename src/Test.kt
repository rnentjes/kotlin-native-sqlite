import nl.astraeus.sqlite.ColumnType
import nl.astraeus.sqlite.SQLite

class Person(
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
    val sqlite = SQLite("data/data.sqlite")

    try {
        sqlite.transaction {
            execute("""
                DROP TABLE IF EXISTS Person;
                CREATE TABLE Person(name VARCHAR, age INT);
                INSERT INTO Person VALUES('Piet', 22);
                INSERT INTO Person VALUES('Klaas', 65);
            """.trimIndent())

            val objectSet = executeQuery(
              "SELECT * FROM Person",
              arrayOf(ColumnType.STRING, ColumnType.INTEGER)
            ) { data ->
                Person(data[0] as String, data[1] as Int)
            }

            while(objectSet.hasNext()) {
                val person = objectSet.next()

                println("Found ${person.name} - ${person.age}")
            }

            val resultSet = executeQuery("SELECT * FROM Person")

            while(resultSet.next()) {
                println("RS Found ${resultSet.getString(0)}, ${resultSet.getInt(1)}")
            }
        }
    } finally {
        sqlite.close()
    }

}
