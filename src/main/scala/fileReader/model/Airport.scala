import CustomTypes._

final case class Airport(id: Int, 
                         ident: String, 
                         building_type: String, 
                         name: String, 
                         latitude_deg: Float, 
                         longitude_deg: Float, 
                         elevation_ft: Int, 
                         continent: String, 
                         iso_country: String, 
                         iso_region: String, 
                         municipality: String, 
                         scheduled_service: String, 
                         gps_code: Option[String], 
                         iata_code: String, 
                         local_code: Option[String], 
                         home_link: Option[String], 
                         wikipedia_link: Option[String] ) extends Airport


object Airport {
  def fromAirports_CSVline(line: Array[String]): Option[Country] = {
        parseOneAirport(line)
    }

  def parseOneAirport(line: Array[String]): Option[Country] = {
    Try(Some(Airport(line(0).toInt,
                     line(1),
                     line(2),
                     line(3),
                     line(4).toFloat,
                     line(5).toFloat,
                     line(6).toInt,
                     line(7),
                     line(8),
                     line(9),
                     line(10),
                     line(11),
                     Try(Some(line(12))) getOrElse None,
                     line(13),
                     Try(Some(line(14))) getOrElse None,
                     Try(Some(line(15))) getOrElse None,
                     Try(Some(line(16))) getOrElse None,
    ))) getOrElse None
  }
}