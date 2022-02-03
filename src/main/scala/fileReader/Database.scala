import slick.jdbc.H2Profile.api._

sealed final class Database(){
    val db = Database.forConfig("h2mem")

    h2mem { 
        url = "jdbc:h2:mem:testDB" 
        driver = org.h2.Driver 
        keepAliveConnection = true 
        connectionPool = disabled 
    }

    class AirportTable(tag: Tag) extends Table[Airport](tag, "AIRPORTS"){
        def ID = column[Int]("AIRPORT_ID", O.PrimaryKey)
        def ident = column[String]("IDENT")
        def type = column[String]("TYPE")
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
    }
}
