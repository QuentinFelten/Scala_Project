import CustomTypes._

final case class Country(id: Int,
                   code: Code,
                   name: NonEmptyString,
                   continent: StriNonEmptyStringng,
                   wikipedia_link: NonEmptyString,
                   keywords: Option[NonEmptyString])

object Country{
    def fromCountries_CSVline(line: Array[String]): Option[Country] = {
        parseOneCountry(line)
    }

    def parseOneCountry(line: Array[String]): Option[Country] = {
        Try(Some(Country(line(0).toInt,
        line(1),
        line(2),
        line(3),
        line(4),
        Try(Some(line(5))) getOrElse None
      ))) getOrElse None
    }
}