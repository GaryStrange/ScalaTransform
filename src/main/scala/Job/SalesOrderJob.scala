package Job

import Compute.{SessionBuilder, SessionConfig}
import Data.TStorage
import org.apache.spark.sql.SparkSession

object SalesOrderJob extends Job(SalesOrderStorage) {

  override def main(args: Array[String]): Unit = {
    //sessionConfig = new SessionConfig(false, "","","")


  }

  override val sessionConfig = new SessionConfig(false, "","","")

}
