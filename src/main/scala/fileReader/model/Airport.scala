import scala.util.Try 

case class Airport (id: Int, 
                    ident: String, 
                    building_type: String, 
                    name: String, 
                    latitude_deg: Option[Float], 
                    longitude_deg: Option[Float], 
                    elevation_ft: Option[Int], 
                    continent: Option[String], 
                    iso_country: String, 
                    iso_region: Option[String], 
                    municipality: Option[String], 
                    scheduled_service: Option[String], 
                    gps_code: Option[String], 
                    iata_code: Option[String], 
                    local_code: Option[String], 
                    home_link: Option[String], 
                    wikipedia_link: Option[String] ) 


object Airport {
  def fromAirports_CSVline(line: Array[String]): Option[Airport] = {
        Try(Some(Airport(line(0).toInt,
                     line(1),
                     line(2),
                     line(3),
                     Try(Some(line(4).toFloat)) getOrElse None,
                     Try(Some(line(5).toFloat)) getOrElse None,
                     Try(Some(line(6).toInt)) getOrElse None,
                     Try(Some(line(8))) getOrElse None,
                     line(8),
                     Try(Some(line(9))) getOrElse None,
                     Try(Some(line(10))) getOrElse None,
                     Try(Some(line(11))) getOrElse None,
                     Try(Some(line(12))) getOrElse None,
                     Try(Some(line(13))) getOrElse None,
                     Try(Some(line(14))) getOrElse None,
                     Try(Some(line(15))) getOrElse None,
                     Try(Some(line(16))) getOrElse None
          ))) getOrElse None
  }

}