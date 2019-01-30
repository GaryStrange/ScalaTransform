package Job

import Data.TStorage

class SalesOrderJob(dataStore: TStorage) extends Job(dataStore) {
  val dataStorage: TStorage = SalesOrderStorage
}
