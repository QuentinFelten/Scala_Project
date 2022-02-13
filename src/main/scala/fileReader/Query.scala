//package Query
import scala.util.Try

object Query {

    def checkAirports(name: String, countries: List[Country], mondialAirports: List[Airport], mondialRunways: List[Runway] ): Unit = {
        // fonction qui récupère un nom de pays, et qui va afficher ce pays, ainsi que ses aéroports et leurs pistes

        val ourCountry: Option[Country] = Try(countries.find(target => target.name.toUpperCase() == "\""+name.toUpperCase()+"\"" || target.code == "\""+name.toUpperCase()+"\"")) getOrElse None
        // inputCountry va contenir le pays demandé par l'utilisateur
        printCountry (ourCountry)

        val codeCountry: String = Try (ourCountry.get.code) getOrElse ""
        // Si on n'a pas trouvé le bon country, on n'aura donc un code vide, et aucun airport ne correspondra

        val nationalAirports: List[Airport] = mondialAirports.filter(target => target.iso_country == codeCountry)
        // nationalAirports sera la liste de tous les aeroports liés au pays. 
        // si on n'a pas de pays, la liste devrait être vide

        nationalAirports.foreach {curr => printAirport (curr, mondialRunways) }
        // Call printairport pour chaque aéroport repéré
        // Si la liste est vide, printairport ne sera jamais appelé

    }

    def topCountries(countries: List[Country], mondialAirports: List[Airport]): Unit = {
        
        val map = countries.map(target => target.name -> mondialAirports.filter(airportTarget => airportTarget.iso_country == target.code) )
                    .toMap
                    .view
                    .mapValues(_.size)
                    .toMap
                    .toSeq


        println ("\nTop:")
        map.sortWith((a,b) => a._2 > b._2)
            .take(10)
            .foreach (println)


        println ("\nFlop:")
        map.sortWith((a,b) => a._2 < b._2)
            .take(10)
            .foreach (println)
        println ()
    }

    def topRunwayLatitudes (mondialRunways: List[Runway]): Unit = {
        println ("\nTop latitudes:")
        mondialRunways.groupBy(_.le_ident)
            .view
            .mapValues(_.length)
            .toMap
            .toSeq
            .sortWith((a,b) => a._2 > b._2)
            .take(10)
            .foreach (println)

        println ()
    }

    def printCountry (dis: Option[Country]): Unit = {
        val tmp : String = Try ("country : " + dis.get.name) getOrElse "There is no country with this name"
        println(tmp)
    }

    def printAirport (dis: Airport, mondialRunways: List[Runway]): Unit = {
        println("| airport : " + dis.name)

        val localRunway: List[Runway] = mondialRunways.filter(target => target.airport_ref == dis.id)
        localRunway.foreach {printRunway }
    }
    
    def printRunway (dis: Runway): Unit = {
        println("|| runway id:" + dis.id)
    }



    def runwayTypesCountry(): Unit = {
        ???
    }

    



}