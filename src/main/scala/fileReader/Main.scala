import scala.util.{Failure, Success}
import scala.util.Try

object Main {

  def main(args: Array[String]): Unit = {
    val airports = CSV.read("airports.csv", Airport.fromAirports_CSVline)
    val countries = CSV.read("countries.csv", Country.fromCountries_CSVline)
    val runways = CSV.read("runways.csv", Runway.fromRunways_CSVline)
    menu()
  }

  def menu():Unit ={
    println("Please select an option:")
    println("(1) Query: look for airports & runways in a country.")
    println("(2) Reports: looks for specific things.")
    println("(3) Exit.")

    Try(scala.io.Stdin.readInt()) match{
      case Success(x) => x match {
        case 1 =>
          queryMenu()
          menu()
        
        case 2 =>
          reportsMenu()
          menu()

        case 3 => println("Exiting.")

        case _ => menu()
      }

      case Failure(i) =>
        println("Your input " + i + " is incorrect.")
        menu()
    }
  }

  def queryMenu(): Unit ={
    println("Please type the country name or code that you wish to check.")
    
    Try(scala.io.Stdin.readLine()) match{
      case Success(x) => x match{
        println("These are the airports & runways you are looking for:")
        checkAirports(x)
        println()
        menu()

      case Failure(i) =>
        println("Your input " + i + " is incorrect.")
        queryMenu()
    }
  }

  def reportsMenu(): Unit ={
    println()
    println("This is the reports submenu.")
    println("Do you want to:")
    println("(1) Look for the 10 countries with highest & lowest number of airports (with count).")
    println("(2) Look the the types of runways in a country.")
    println("(3) Look for the top 10 most common runway latitudes.")

    Try(scala.io.Stdin.readInt()) match{
      case Success(x) => x match{
        case 1 => 
          topCountries()
          menu()
        
        case 2 =>
          println("What country would you like to check ?")
          Try(scala.io.Stdin.readLine()) match{
            case Success(x) => 
              println("These are the types of runways present in the country:")
              runwayTypesCountry(x)
              println()
              menu()

            case Failure(i) =>
              println("Your input " + i + " is incorrect.")
              reportsMenu()
          }

        case 3 => 
          println("This is the top 10 of the most common runway latitudes:")
          topRunwayLatitudes()
          println()
          menu()
      }

      case Failure(i) =>
        println("Your input " + i + " is incorrect.")
        reportsMenu()
    }
  }
}
