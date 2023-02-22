ThisBuild / name := "seller-app"

ThisBuild / version := "1.0.0"

ThisBuild / scalaVersion := "2.12.8"

import sbtsonar.SonarPlugin.autoImport.sonarProperties

sonarProperties ++= Map(
  "sonar.projectKey" -> "pe.carlosesp.demo:seller-app"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
