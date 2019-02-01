package Job

import Data.{StoragePaths, TStorage}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType

object SalesOrderStorage extends TStorage{

  val schema : StructType = new StructType()

  override val storagePaths = new StoragePaths("cmc") {

  }
}
