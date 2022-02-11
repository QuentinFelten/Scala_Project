import scala.slick.driver.MySQLDriver.simple._
import scala.slick.jdbc.meta._

sealed class Database(){

    val db = Database.forURL(
        "jdbc:mysql://127.0.0.1:3306/DB", 
        driver="com.mysql.jdbc.Driver"
    )

    def createAirportsTable:Unit = {
        db withSession {
        implicit session =>
            if(! MTable.getTables("airports").list.isEmpty) {
            Tables.airports.ddl.drop
            }
            Tables.airports.ddl.create
        }
    }

    def createCountriesTable:Unit = {
        db withSession {
        implicit session =>
            if(! MTable.getTables("countries").list.isEmpty) {
            Tables.countries.ddl.drop
            }
            Tables.countries.ddl.create
        }
    }

    def createRunwaysTable:Unit = {
        db withSession {
        implicit session =>
            if(! MTable.getTables("runways").list.isEmpty) {
            Tables.runways.ddl.drop
            }
            Tables.runways.ddl.create
        }
    }

    val setup = DBIO.seq(
        (airports.schema ++ countries.schema ++ runways.schema).create
    )

    val insertInAirportTable = DBIO.seq(
        airports += (
            
        )
    )

    val query = for{
        (a,c) <- 
    }

    // we execute the setup Action asynchronously with db.run
    val setupFuture = db.run(setup)

    
}
