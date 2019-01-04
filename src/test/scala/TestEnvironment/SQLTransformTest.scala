package TestEnvironment
import SQLTransform._
import org.specs2.mutable.Specification
import TestSession._

class SQLTransformTest extends Specification  {
  "transformUsingSQLAPI" should {
    "return true" in {
      val ld = landedData
      println(ld.printSchema())

      val td = TheJob.transformUsingSQLAPI(landedData)
      println(td.show)
      true must_=== true
    }
  }

  "transformUsingSQL" should {
    "return true" in {
      val ld = landedData
      println(ld.printSchema())

      val td = TheJob.transformUsingSQL(landedData)
      println(td.show)
      true must_=== true
    }
  }
}
