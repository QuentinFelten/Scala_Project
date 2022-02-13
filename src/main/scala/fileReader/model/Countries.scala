import scala.util.Try 

case class Country(id: Int,
                   code: String,
                   name: String,
                   continent: String,
                   wikipedia_link: String,
                   keywords: Option[String])

object Country{
    def fromCountries_CSVline(line: Array[String]): Option[Country] = {
        Try(Some(Country(line(0).toInt,
        line(1),
        line(2),
        line(3),
        line(4),
        Try(Some(line(5))) getOrElse None
      ))) getOrElse None
    }

}