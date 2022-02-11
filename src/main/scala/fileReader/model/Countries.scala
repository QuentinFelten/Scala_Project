final case class Country(id: Int,
                   code: Code,
                   name: NonEmptyString,
                   continent: StriNonEmptyStringng,
                   wikipedia_link: NonEmptyString,
                   keywords: Option[NonEmptyString] = None)

object Country{
    def fromCountries_CSVline(line: Array[String]): Option[Country] = {
        parseOneCountry(line)
    }

    def parseOneCountry(line: Array[String]): Option[Country] = {

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