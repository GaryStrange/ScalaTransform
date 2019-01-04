name := "ScalaTransform"

version := "0.1"

scalaVersion := "2.11.8"
val sparkSqlV = "2.3.1"
val dbutilsV = "0.0.3"
val specs2V = "4.3.4"
val scallopV = "3.1.5"
val appInsightsV = "2.1.2"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % sparkSqlV % Provided withSources() withJavadoc()//,
  ,"com.databricks" % "dbutils-api_2.11" % dbutilsV % Provided withSources() withJavadoc(),
  ,"org.rogach" %% "scallop" % scallopV withSources() withJavadoc(),
  ,"org.specs2" %% "specs2-core" % specs2V % Test withSources() withJavadoc()
)
