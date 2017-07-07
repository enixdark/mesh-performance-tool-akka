name := "sp"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats" % "0.9.0",
  "com.typesafe.akka" % "akka-actor" % "2.5.3",
  "com.typesafe.akka" % "akka-http" % "10.0.9",
  "com.typesafe.akka" % "akka-testkit" % "2.5.3" % "test",
  "com.typesafe.akka" % "akka-stream" % "2.5.3"
)
    
