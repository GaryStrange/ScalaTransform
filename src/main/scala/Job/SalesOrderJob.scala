package Job

import Data.TStorage
import org.apache.spark.sql.SparkSession

object SalesOrderJob extends Job(SalesOrderStorage) {
  override def main(args: Array[String]): Unit = {

  }

  override val session = if (isLocalJob) SparkSession.builder.master("local").getOrCreate()
  else SparkSession.builder.getOrCreate()
}
