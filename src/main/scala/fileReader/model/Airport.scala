package fileReader.model

import scala.util.Try

sealed final case class Airport(id: Int, ident: String, type: String, name: String, latitude_deg: Float, longitude_deg: Float, elevation_ft: Int, continent: String, iso_country: String, iso_region: String, municipality: String, scheduled_service: String, gps_code: Option[String], iata_code: String, local_code: Option[String], home_link: Option[String], wikipedia_link: Option[String] ) extends Airport


object Airport {
  def fromCsvLine(line: Array[string]): Option[Airport] = {
    parseAirport(line)
  }


  //pattern matching is forbose so you can implement detailed error msg if you feel like it
  def parseAirport(line: Array[String]) = {
    (Try(line(1).toInt).toOption, Try(line(7).toInt).toOption, Try(line(5).toFloat).toOption, Try(line(6).toFloat).toOption) match {
      case (Some(x), Some(y), Some(z), Some(a)) => Some(Airport(x, line(2) , line(3), line(4), z, a, y, line(8), line(9), line(10), line(11), line(12), line(13), line(14), line(15), line(16), line(17))
      case (None, Some(_), Some(_), Some(_)) | (Some(_), None, Some(_), Some(_)) | (Some(_), Some(_), None, Some(_)) | (Some(_), Some(_), Some(_), None) => None // 1 error
      case (None, None, Some(_), Some(_)) | (None, Some(_), None, Some(_)) | (None, Some(_), Some(_), None)| (Some(_), None, Some(_), None) | (Some(_), None, None, Some(_)) | (Some(_), Some(_), None, None) => None // 2 errors
      case (Some(_), None, None, None) | (None, Some(_), None, None) | (None, None, Some(_), None) | (None, None, None, Some(_)) => None // 3 error
      case (None, None, None, None) => None // 4 errors
    }
  }
}