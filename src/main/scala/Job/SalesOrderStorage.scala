package Job

import Data.{StoragePaths, TStorage}
import org.apache.spark.sql.SparkSession

object SalesOrderStorage extends TStorage{

  override def writeData: Unit = {}

  override val storagePaths = new StoragePaths("cmc") {

  }
}
