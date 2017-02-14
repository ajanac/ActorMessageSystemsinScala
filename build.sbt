name := "cs474hw3"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  val akkaV       = "2.4.11"
  val scalaTestV  = "3.0.0"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV,
    "org.scalatest"     %% "scalatest" % scalaTestV % "test",
   "com.typesafe.akka" % "akka-http-core_2.11" % akkaV,
    "com.typesafe.akka" % "akka-http-xml-experimental_2.11" % akkaV,
   // "org.json4s" %% "json4s-jackson" % "3.2.11"
      // https://mvnrepository.com/artifact/org.json4s/json4s-jackson_2.11
      "org.json4s" % "json4s-jackson_2.11" % "3.4.2"


 //   "com.typesafe.play" %% "play-json_2.11" % akkaV


    //"com.typesafe.akka" %% "akka-http-experimental" % "2.4.11",
      //"org.scalatest"   %% "scalatest"    % "3.0.0"   % "test"
  )
}
    