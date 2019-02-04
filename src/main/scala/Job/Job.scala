package Job

import Compute.{SessionBuilder, SessionConfig}
import Data.{TStorage, WriteConfig}
import Logging.Logger
import org.apache.spark.sql.SparkSession

abstract class Job(dataStore: TStorage) {
  def main(args: Array[String]): Unit = {
    implicit val spark: SparkSession =
      SessionBuilder.getSessionFrom(sessionConfig)

    val sourceData = dataStore.readData(spark, activities.sourceSchema, activities.sourceDataSubPath)

    activities.Process(sourceData, dataStore.writeData("parquet"), logger)
  }
  val logger:Logger

  val activities: TJobActivities

  val sessionConfig: SessionConfig
}
