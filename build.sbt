ThisBuild / name := "seller-app"

ThisBuild / version := "1.0.0"

ThisBuild / scalaVersion := "2.12.8"

import sbtsonar.SonarPlugin.autoImport.sonarProperties

sonarProperties ++= Map(
  "sonar.junit.reportPaths" -> "target/test-reports",
  "sonar.projectKey" -> "pe.carlosesp.demo:seller-app",
  "sonar.scoverage.reportPath" -> "target/scala-2.12/scoverage-report/scoverage.xml"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
