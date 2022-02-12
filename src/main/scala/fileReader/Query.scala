def checkAirports(name: String, countries: List[Country], airports: List[Airport], runways: List[Runway] ): Unit = {
// fonction qui récupère un nom de pays, et qui va afficher ce pays, ainsi que ses aéroports et leurs pistes

val inputCountry: Option[Country] = Try(countries.find(target => target.name == "\""+name+"\"" || target.code == "\""+name+"\"")) getOrElse None
// inputCountry va contenir le pays demandé par l'utilisateur

val nationalAirports: List[Airport] = airports.filter(target => target.iso_country == inputCountry.get.code)
// nationalAirports sera la liste de tous les aeroports liés au pays. 


// faire un foreach sur nationalAirports
}

def printCountry (dis: Country): Unit = {
    ???
}

def printAirport (dis: Airport): Unit = {
    ???
}

def printRunway (dis: Runway): Unit = {
    ???
}