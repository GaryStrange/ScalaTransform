package Job

import Compute.{SessionBuilder, SessionConfig}
import Data.TStorage
import org.apache.spark.sql.SparkSession

abstract class Job(dataStore: TStorage) {
  def main(args: Array[String]): Unit = {
    implicit val spark: SparkSession =
      SessionBuilder.getSessionFrom(sessionConfig)
  }


  val sessionConfig: SessionConfig
}
