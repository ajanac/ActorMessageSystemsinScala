# README #



### What is this repository for? ###

* Quick summary :
   It is a functional reactive concurrent distributed programming using Actor message systems and to understand git object model. One actor  gets java projects from git. Other actor takes two versions of a project , find the dependencies between them using Understrand API. Dependency graph is used to find the patches. Based on the patches project gives recommendation to the programmmer , which modeules need to be retested.

![sequence.png](https://bitbucket.org/repo/6E4bnE/images/2463077179-sequence.png)

* Techonologies Used:
Scala with Akka
Understand API
Github API
### How do I run? ###

* Summary:
By running SpikeAkkaHttpClient .scala
* Dependendies:

  "org.scalatest"   %% "scalatest"    % "3.0.0"   % "test",
  "com.typesafe.akka" %% "akka-actor" % "2.4.11",
  "com.typesafe.akka" %% "akka-stream" % "2.4.11",
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.11",
  "com.typesafe.akka" %% "akka-http-testkit" % "2.4.11",
  "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.11",
  "com.typesafe.akka" % "akka-http-core_2.11" % "2.4.11",
  "com.typesafe.akka" % "akka-http-xml-experimental_2.11" % "2.4.11",
  "org.json4s" % "json4s-jackson_2.11" % "3.4.2"




### Contribution guidelines ###

* Code review: Wrote code in Scala with Akka
  
* Other guidelines
Project cloning time depends on the size of the project in the repositories.

### Who do I talk to? ###

* Repo owner or admin
Aiswarya Vijayan and Ajana Sathian