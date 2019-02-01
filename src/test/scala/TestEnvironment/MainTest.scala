package TestEnvironment

import Job.SalesOrderJob
import org.specs2.mutable.Specification

class MainTest extends Specification {
  "Main" should {
    "return true" in {
      SalesOrderJob.main(null)
      true must_=== true
    }
  }
}
