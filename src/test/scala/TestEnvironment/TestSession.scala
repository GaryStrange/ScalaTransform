package TestEnvironment

import org.apache.spark.sql._

object TestSession extends Session {
  val landedData: DataFrame = readDataFrame(EnvironmentPaths.testFilePath("OrderCreatedEvent.json"))

  def readDataFrame( landingPath: String): DataFrame =
    spark.read
      .option("multiLine", value = true)
      .json(landingPath)
}
