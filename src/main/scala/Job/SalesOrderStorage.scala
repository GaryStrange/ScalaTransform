package Job

import Data.{StoragePaths, TStorage}

object SalesOrderStorage extends TStorage{



  override val storagePaths = new StoragePaths("cmc") {

  }
}
