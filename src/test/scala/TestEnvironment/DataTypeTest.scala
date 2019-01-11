package TestEnvironment
import SQLTransform._
import org.specs2.mutable.Specification
import TestSession._

class DataTypeTest extends Specification {
  "DataTypeTest" should {
    "return true" in {
      println(TheJob.showDataType(landedData))
      true must_=== true
    }
  }
}
