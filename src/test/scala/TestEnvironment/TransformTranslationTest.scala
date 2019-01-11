package TestEnvironment

import org.specs2.mutable.Specification
import TestSession._
import SQLTransform.TransformTranslation

class TransformTranslationTest extends Specification{
  "TransformTranslation test" should {
    "return true" in {
      for (field <- landedData.schema.fields)
        println(field.toString() + " translates to " + TransformTranslation.GetDataTypeTransform(field.dataType))
      true must_=== true
    }
  }
}
