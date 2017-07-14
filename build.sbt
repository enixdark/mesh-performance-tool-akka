name := "sp"

version := "1.0"

scalaVersion := "2.12.2"

//libraryDependencies ++= Seq(
//  "org.typelevel" %% "cats" % "0.9.0",
//  "com.typesafe.akka" % "akka-actor_2.12" % "2.5.3",
//  "com.typesafe.akka" % "akka-http_2.12" % "10.0.9",
//  "com.typesafe.akka" % "akka-testkit_2.5.3" % "2.5.3" % "test",
//  "com.typesafe.akka" % "akka-stream_2.5.3" % "2.5.3",
//  "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % "1.1.1"
//)

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats" % "0.9.0",
  "com.typesafe.akka" % "akka-actor_2.12" % "2.5.3",
  "com.typesafe.akka" % "akka-http_2.12" % "10.0.9",
  "com.typesafe.akka" % "akka-stream_2.12" % "2.5.3",
  "com.typesafe.akka" % "akka-testkit_2.12" % "2.5.3" % "test",
  "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % "1.1.1",
  "com.github.scopt" % "scopt_2.12" % "3.6.0",
  "com.github.tototoshi" %% "scala-csv" % "1.3.4",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.8.9",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.9"

)