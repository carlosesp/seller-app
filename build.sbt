ThisBuild / name := "seller-app"

ThisBuild / version := "1.0.0"

ThisBuild / scalaVersion := "2.12.8"

lazy val excludes = jacocoExcludes in Test := Seq(
  "pe.carlosesp.demo.main.Main*"
)

lazy val jacoco = jacocoReportSettings in Test := JacocoReportSettings(
  "Project Seller App",
  None,
  JacocoThresholds(branch = 100),
  Seq(JacocoReportFormats.ScalaHTML, JacocoReportFormats.XML),
  "utf-8"
)

val jacocoSettings = Seq(jacoco, excludes)

//lazy val root = (project in file(".")).settings(jacocoSettings: _*)
lazy val jse = (project in file(".")).settings(jacocoSettings: _*)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"