val scala3Version = "3.5.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "sbt-scoverage-macros",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit-scalacheck" % "0.7.29" % Test,
  )
