import slick.driver.H2Driver.api._
import scala.concurrent.ExecutionContext.Implicits.global

sealed final class Database(){
    val db = Database.forConfig("h2mem")

    h2mem { 
        url = "jdbc:h2:mem:DB" 
        driver = org.h2.Driver 
        keepAliveConnection = true 
        connectionPool = disabled 
    }

    class AirportTable(tag: Tag) extends Table[Airport](tag, "AIRPORTS"){
        def id = column[Int]("AIRPORT_ID", O.PrimaryKey)
        def ident = column[String]("IDENT")
        def building_type = column[String]("TYPE")
        def name = column[String]("NAME")
        def latitude_deg = column[Float]("LATITUDE_DEG")
        def longitude_deg = column[Float]("LONGITUDE_DEG")
        def elevation_ft = column[Int]("ELEVATION_FT")
        def continent = column[String]("CONTINENT")
        def iso_country = column[String]("ISO_COUNTRY")
        def iso_region = column[String]("ISO_REGION")
        def municipality = column[String]("municipality")
        def scheduled_service = column[String]("SCHEDULED_SERVICE")
        def gps_code = column[String]("GPS_CODE")
        def iata_code = column[Option[String]]("IATA_CODE")
        def local_code = column[String]("LOCAL_CODE")
        def home_link = column[Option[String]]("HOME_LINK")
        def wikipedia_link = column[Option[String]]("WIKIPEDIA_LINK")
        def keywords = column[Option[String]]("KEYWORDS")
        def * = (id, ident, building_type, name, latitude_deg, longitude_deg, elevation_ft, continent, iso_country, iso_region, municipality, scheduled_service, gps_code, iata_code, local_code, home_link, wikipedia_link, keywords)
    }

    class CountriesTable(tag: Tag) extends Table[Countries](tag, "COUNTRIES"){
        def id = column[Int]("COUNTRY_ID", O.PrimaryKey)
        def code = column[String]("CODE")
        def name = column[String]("NAME")
        def continent = column[String]("CONTINENT")
        def wikipedia_link = column[String]("WIKIPEDIA_LINK")
        def keywords = column[Option[String]]("KEYWORDS")
    }
}
