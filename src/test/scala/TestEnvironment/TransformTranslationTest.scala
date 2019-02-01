package TestEnvironment

import org.specs2.mutable.Specification
import TestSession._
import SQLTransform.{TransformTranslation, TransformationStep}

import scala.collection.mutable.ListBuffer

class TransformTranslationTest extends Specification{
  "TransformTranslation listing test" should {
    "return true" in {

      for (field <- landedData.schema.fields) {
        val myTransformations : ListBuffer[TransformationStep] = new ListBuffer[TransformationStep]
        println(field.toString() + " translates to ")
        println("    " + TransformTranslation.ListFieldTransforms(myTransformations,field))
        //println(myTransformations)
      }
      true must_=== true
    }
  }
  //"TransformTranslation test" should {
  //  "return true" in {
  //    for (field <- landedData.schema.fields)
  //      println(field.toString() + " translates to " + TransformTranslation.GetDataTypeTransform(field.dataType))
  //    true must_=== true
  //  }
  //}
}
