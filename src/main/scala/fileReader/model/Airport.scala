package fileReader.model

import scala.util.Try

final case class Airport(id: Int, 
                         ident: NonEmptyString, 
                         building_type: NonEmptyString, 
                         name: NonEmptyString, 
                         latitude_deg: Float, 
                         longitude_deg: Float, 
                         elevation_ft: Int, 
                         continent: Code, 
                         iso_country: Code, 
                         iso_region: NonEmptyString, 
                         municipality: NonEmptyString, 
                         scheduled_service: NonEmptyString, 
                         gps_code: Option[String], 
                         iata_code: NonEmptyString, 
                         local_code: Option[String], 
                         home_link: Option[String], 
                         wikipedia_link: Option[String] ) extends Airport


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

class NonEmptyString (val underlying: String) extends AnyVal

object NonEmptyString {
  def foo: NonEmptyString = new NonEmptyString(checkEmpty(underlying))

  def checkEmpty(arg: String){
    arg match {
      case None    => None
      case Some(s) => s.trim.isEmpty
    }
  }
  
}

class Code (val underlying: String) extends AnyVal

object Code {
  def foo: Code = new Code(checkCode(underlying))

  def checkCode(arg: String){
    val pattern = new Regex("[A-Z][A-Z]")
    arg match{
      case pattern => arg
      case _       => None
    }
  }
}