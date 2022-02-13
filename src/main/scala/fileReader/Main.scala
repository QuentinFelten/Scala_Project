import scala.util.{Try, Failure, Success}
import Query._
import fileReader.service.CSV

object Main {

  def main(args: Array[String]): Unit = {
    val airports = CSV.read("airports.csv", Airport.fromAirports_CSVline)
    val countries = CSV.read("countries.csv", Country.fromCountries_CSVline)
    val runways = CSV.read("runways.csv", Runway.fromRunways_CSVline)
    menu(countries.lines.toList, airports.lines.toList, runways.lines.toList)
  }

  def menu(countries: List[Country], airports: List[Airport], runways: List[Runway] ):Unit ={
    println("Please select an option:")
    println("(1) Query: look for airports & runways in a country.")
    println("(2) Reports: looks for specific things.")
    println("(3) Exit.")

    Try(scala.io.StdIn.readInt()) match{
      case Success(x) => x match {
        case 1 =>
          queryMenu(countries, airports, runways)
          menu(countries, airports, runways)
        
        case 2 =>
          reportsMenu(countries, airports, runways)
          menu(countries, airports, runways)

        case 3 => println("Exiting.")

        case _ => menu(countries, airports, runways)
      }

      case Failure(i) =>
        println("Your input " + i + " is incorrect.")
        menu(countries, airports, runways)
    }
  }

  def queryMenu(countries: List[Country], airports: List[Airport], runways: List[Runway] ): Unit ={
    println("Please type the country name or code that you wish to check.")
    
    Try(scala.io.StdIn.readLine()) match{
      case Success(x) => 
        println("These are the airports & runways you are looking for:")
        checkAirports(x, countries, airports, runways)
        println()
        menu(countries, airports, runways)

      case Failure(i) =>
        println("Your input " + i + " is incorrect.")
        queryMenu(countries, airports, runways)
    }
  }

  def reportsMenu(countries: List[Country], airports: List[Airport], runways: List[Runway] ): Unit ={
    println()
    println("This is the reports submenu.")
    println("Do you want to:")
    println("(1) Look for the 10 countries with highest & lowest number of airports (with count).")
    println("(2) Look the the types of runways in a country.")
    println("(3) Look for the top 10 most common runway latitudes.")

    Try(scala.io.StdIn.readInt()) match{
      case Success(x) => x match{
        case 1 => 
          topCountries()
          menu(countries, airports, runways)
        
        case 2 =>
          println("What country would you like to check ?")
          Try(scala.io.StdIn.readLine()) match{
            case Success(x) => 
              println("These are the types of runways present in the country:")
              runwayTypesCountry()
              println()
              menu(countries, airports, runways)

            case Failure(i) =>
              println("Your input " + i + " is incorrect.")
              reportsMenu(countries, airports, runways)
          }

        case 3 => 
          println("This is the top 10 of the most common runway latitudes:")
          runwayTypesCountry()
          println()
          menu(countries, airports, runways)
      }

      case Failure(i) =>
        println("Your input " + i + " is incorrect.")
        reportsMenu(countries, airports, runways)
    }
  }
}
