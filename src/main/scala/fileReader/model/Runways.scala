final case class Runway(id: Int,
                        airport_ref: Int,
                        airport_ident: NonEmptyString,
                        length_ft: Int,
                        width_ft: Int,
                        surface: NonEmptyString,
                        lighted: Int,
                        closed: Int,
                        le_ident: NonEmptyString,
                        le_latitude_deg: Option[Float],
                        le_longitude_deg: Option[Float],
                        le_elevation_ft: Option[Int],
                        le_heading_degT: Option[Float],
                        le_displaced_threshold_ft: Option[Int],
                        he_ident: Option[NonEmptyString],
                        he_latitude_deg: Option[Float],
                        he_longitude_deg: Option[Float],
                        he_elevation_ft: Option[Int],
                        he_heading_degT: Option[Float],
                        he_displaced_threshold_ft: Option[Int])

object Runway{
    def fromRunways_CSVline(line: Array[String]): Option[Runway] = {
        parseOneCountry(line)
    }

    def parseOneRunway(line: Array[String]): Option[Runway] = {

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