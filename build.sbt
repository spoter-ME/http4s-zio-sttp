name := "http4s-zio-sttp"
version := "0.1"
scalaVersion := "2.12.11"

val Http4sVersion = "0.21.4"
val CirceVersion = "0.13.0"
val sttpVersion = "2.0.7"
val wiremockVersion = "2.21.0"
val DoobieVersion = "0.9.0"
val ZIOVersion = "1.0.0-RC18-2"
val PureConfigVersion = "0.11.0"
val H2Version = "1.4.199"
val FlywayVersion = "6.0.0-beta2"

libraryDependencies ++= Seq(
  // ZIO
  "dev.zio" %% "zio" % ZIOVersion,
  "dev.zio" %% "zio-interop-cats" % "2.0.0.0-RC12",
  "dev.zio" %% "zio-test" % ZIOVersion % "test",
  "dev.zio" %% "zio-test-sbt" % ZIOVersion % "test",
  // Http4s
  "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s" %% "http4s-circe" % Http4sVersion,
  "org.http4s" %% "http4s-dsl" % Http4sVersion,
  // Circe
  "io.circe" %% "circe-generic" % CirceVersion,
  "io.circe" %% "circe-generic-extras" % CirceVersion,
  // STTP
  "com.softwaremill.sttp.client" %% "async-http-client-backend-zio" % sttpVersion,
  "com.softwaremill.sttp.client" %% "circe" % sttpVersion,
  // Doobie
  "org.tpolecat" %% "doobie-core" % DoobieVersion,
  "org.tpolecat" %% "doobie-h2" % DoobieVersion,
  //pure config
  "com.github.pureconfig" %% "pureconfig" % PureConfigVersion,
  //h2
  "com.h2database" % "h2" % H2Version,
  // log4j
  "org.slf4j" % "slf4j-log4j12" % "1.7.30",
  //WireMock
  "com.github.tomakehurst" % "wiremock" % wiremockVersion % "test"
)

// for zio snapshot versions
//resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
//testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
