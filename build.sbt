name := "spark-indexedrdd"
organization := "cenx"

publishTo := {
  val nexus = "http://nexus.cenx.localnet:8081/nexus/content/repositories/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "snapshots")
  else
    Some("releases"  at nexus + "releases")
}

scalaVersion := "2.11.8"
crossScalaVersions := Seq("2.10.6", "2.11.6")

spName := "amplab/spark-indexedrdd"
sparkVersion := "2.1.0"
sparkComponents += "core"

resolvers += "Repo at github.com/ankurdave/maven-repo" at "https://raw.githubusercontent.com/ankurdave/maven-repo/master"

libraryDependencies ++= Seq(
  "com.ankurdave" % "part_2.10" % "0.1",  // artifact is not published for 2.11, but it only contains Java code anyway
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.2" % "test"
)

//publishMavenStyle := true

licenses += "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")

pomExtra :=
  <url>https://github.com/amplab/spark-indexedrdd</url>
  <scm>
    <url>git@github.com:amplab/spark-indexedrdd.git</url>
    <connection>scm:git:git@github.com:amplab/spark-indexedrdd.git</connection>
  </scm>
  <developers>
    <developer>
      <id>ankurdave</id>
      <name>Ankur Dave</name>
      <url>https://github.com/ankurdave</url>
    </developer>
  </developers>


// Run tests with more memory
javaOptions in test += "-Xmx2G"

fork in test := true

credentials += Credentials(Path.userHome / ".sbt" / "credentials")
