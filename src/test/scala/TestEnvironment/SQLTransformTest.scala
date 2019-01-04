package TestEnvironment
import SQLTransform._
import org.specs2.mutable.Specification
import TestSession._

class SQLTransformTest extends Specification  {
  "TransformTest" should {
    "return true" in {
      val ld = landedData
      TheJob.transform must_=== true
    }
  }
}
