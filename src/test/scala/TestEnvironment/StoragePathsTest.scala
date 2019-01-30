package TestEnvironment

import Data.StoragePaths
import org.specs2.mutable.Specification

class StoragePathsTest extends Specification {
  "StoragePathsTest" should {
    "return true" in {
      def storagePaths = new StoragePaths("cmc") {

      }
      println(storagePaths.landingPath)
      storagePaths.landingPath must_=== "/unrestricted/staging/cmc/pqtsnappy/snapshot/"
    }
  }
}
