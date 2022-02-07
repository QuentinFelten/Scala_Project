name := "fileReader"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies ++= List(
    "org.scalatest" %% "scalatest" % "3.2.3" % "test",
    "com.typesafe.slick" %% "slick" % "3.3.2",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "com.h2database" % "h2" % "1.4.200"
)
