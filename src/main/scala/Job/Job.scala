package Job

import Data.TStorage

abstract class Job(dataStore: TStorage) {
  val dataStorage: TStorage
}
