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
  def fromAirports_CSVline(line: Array[String]): Option[Country] = {
        parseOneAirport(line)
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