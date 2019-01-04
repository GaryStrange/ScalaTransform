package TestEnvironment

import org.apache.spark.sql.SparkSession

class Session {
    val spark: SparkSession =
      SparkSession.builder
        .master("local")
        .appName("app")
        .config("spark.driver.memory", "2g")
        .config("spark.sql.session.timeZone", "UTC")
        .getOrCreate()
  }
