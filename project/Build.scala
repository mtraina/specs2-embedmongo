import sbt._
import sbt.Keys._

object ProjectBuild extends Build {

  lazy val buildVersion =  "0.8.1"

  lazy val root = Project(id = "specs2-embedmongo", base = file("."), settings = Project.defaultSettings).settings(
    organization := "com.github.athieriot",
    description := "Specs2 helper to configure a EmbedMongo based instance",
    version := buildVersion,
    scalaVersion := "2.11.7",
    crossScalaVersions := Seq("2.10.4", "2.11.7"),

    resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/",
    resolvers += "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
    resolvers += "Novus Snapshots" at "http://repo.novus.com/snapshots/",
    resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
    resolvers += "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases/",

    libraryDependencies <++= scalaVersion(sv => Seq(
      "de.svenkubiak" % "embedded-mongodb" % "4.2.9",
      "org.specs2" %% "specs2-core" % "3.8.2" % "provided",
      "org.reactivemongo" %% "reactivemongo" % "0.11.12" % "provided",
      "junit" % "junit" % "4.12" % "test"
      )),

    parallelExecution in Test := false,

    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    pomExtra := (
      <url>http://github.com/athieriot/specs2-embedmongo</url>
      <licenses>
        <license>
          <name>Apache 2.0</name>
          <url>http://www.opensource.org/licenses/Apache-2.0</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:athieriot/specs2-embedmongo.git</url>
        <connection>scm:git:git@github.com:athieriot/specs2-embedmongo.git</connection>
      </scm>
      <developers>
        <developer>
          <id>athieriot</id>
          <name>Aurélien Thieriot</name>
          <url>http://athieriot.github.com/resume</url>
        </developer>
      </developers>
    ),
    publishTo := Some("cody" at "http://cody:8082/nexus/content/repositories/releases"),
    credentials += Credentials(Path.userHome / ".sbt" / "sonatype.credentials")
  )
}
