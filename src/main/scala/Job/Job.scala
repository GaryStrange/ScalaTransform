package Job

import Data.TStorage
import org.apache.spark.sql.SparkSession

abstract class Job(dataStore: TStorage) {
  def main(args: Array[String]): Unit

  val isLocalJob = false
  val session: SparkSession
}
