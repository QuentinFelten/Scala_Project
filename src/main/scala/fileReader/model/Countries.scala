import CustomTypes._

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