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
        def id = column[Int]("AIRPORT_ID", O.PrimaryKey, O.AutoInc)
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
        def * = (id, ident, building_type, name, latitude_deg, longitude_deg, elevation_ft, continent, iso_country, iso_region, municipality, 
                 scheduled_service, gps_code, iata_code, local_code, home_link, wikipedia_link, keywords)
    }
    val airports = TableQuery[AirportTable]

    class CountriesTable(tag: Tag) extends Table[Countries](tag, "COUNTRIES"){
        def id = column[Int]("COUNTRY_ID", O.PrimaryKey, O.AutoInc)
        def code = column[String]("CODE")
        def name = column[String]("NAME")
        def continent = column[String]("CONTINENT")
        def wikipedia_link = column[String]("WIKIPEDIA_LINK")
        def keywords = column[Option[String]]("KEYWORDS")
        def * = (id, code, name, continent, wikipedia_link, keywords)
    }
    val countries = TableQuery[CountriesTable]

    class RunwaysTable(tag: Tag) extends Table[Runways](tag, "RUNWAYS"){
        def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
        def airport_ref = column[Int]("AIRPORT_REF")
        def airport_ident = column[String]("AIRPORT_IDENT")
        def length_ft = column[Int]("LENGTH_FT")
        def width_ft = column[Int]("WIDTH_FT")
        def surface = column[String]("SURFACE")
        def lighted = column[String]("LIGHTED")
        def closed = column[String]("CLOSED")
        def le_ident = column[String]("LE_IDENT")
        def le_latitude_deg = column[Float]("LE_LATITUDE_DEG")
        def le_longitude_deg = column[Float]("LE_LONGITUDE_DEG")
        def le_elevation_ft = column[Int]("LE_ELEVATION_FT")
        def le_heading_degT = column[Float]("LE_HEADING_DEGT")
        def le_displaced_threshold_ft = column[Int]("LE_DISPLACED_THRESHOLD_FT")
        def he_ident = column[String]("HE_IDENT")
        def he_latitude_deg = column[Float]("HE_LATITUDE_DEG")
        def he_longitude_deg = column[Float]("HE_LONGITUDE_DEG")
        def he_elevation_ft = column[Int]("HE_ELEVATION_FT")
        def he_heading_degT = column[Float]("HE_HEADING_DEGT")
        def he_displaced_threshold_ft = column[Int]("HE_DISPLACED_THRESHOLD_FT")
        def * = (id, airport_ref, airport_ident, length_ft, width_ft, surface, lighted, closed, le_ident, le_latitude_deg, le_longitude_deg,
                 le_elevation_ft, le_heading_degT, le_displaced_threshold_ft, he_ident, he_latitude_deg, he_longitude_deg, he_elevation_ft, 
                 he_heading_degT, he_displaced_threshold_ft)
    }
}
