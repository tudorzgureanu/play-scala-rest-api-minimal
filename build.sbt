import Dependencies._
import ProjectPlugin._

lazy val root =
  (project in file("."))
    .enablePlay
    .settings(
      name := "PlayScalaRestApiSampleMinimal",
      version := "0.1",
      scalaVersion := "2.13.1")
    .settings(
      libraryDependencies ++= Seq(
        ws,
        playScalaTest % "test",
        scalaTest % "test"
      )
    )