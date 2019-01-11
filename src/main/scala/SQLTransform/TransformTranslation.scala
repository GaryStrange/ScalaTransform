package SQLTransform

import org.apache.spark.sql.types.{DataType}

object TransformTranslation {
  val dataTypeToTransform = Map(
    "array" -> explodeTranslation,
    "string" -> noActionTranslation,
    "int" -> noActionTranslation )

  def explodeTranslation = "explode"

  def noActionTranslation = "no action"

  def GetDataTypeTransform( dataType: DataType ) = {
    dataTypeToTransform.get(dataType.typeName)
  }
}
