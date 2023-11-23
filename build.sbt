import sbt.url

scalaVersion := "2.13.6"

// Java project settings
crossPaths := false
autoScalaLibrary := false

// Project organization settings
organization := "ir.huri"
organizationName := "Marzghi"
organizationHomepage := Some(url("https://github.com/razeghi71/"))

// Project metadata
description := "JalaliCalendar is a Persian Calendar for java inspired from Roozh project. It has a better API and it's more developer friendly"
homepage := Some(url("https://github.com/razeghi71/JalaliCalendar"))
licenses := List("MIT License" -> url("https://opensource.org/licenses/MIT"))

// Developer information
developers := List(
  Developer(
    id    = "razeghi71",
    name  = "Mohammad Razeghi",
    email = "razeghi71@gmail.com",
    url   = url("https://github.com/razeghi71/")
  )
)

// Source Control Management (SCM) information
scmInfo := Some(
  ScmInfo(
    url("https://github.com/razeghi71/JalaliCalendar"),
    "scm:git@github.com:razeghi71/JalaliCalendar.git"
  )
)

// Library dependencies
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.13.2" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)

// Publishing settings
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

// POM configuration
pomIncludeRepository := { _ => false }
enablePlugins(GitVersioning)