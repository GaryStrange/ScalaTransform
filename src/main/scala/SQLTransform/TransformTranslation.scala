package SQLTransform

import org.apache.spark.sql.types.{ArrayType, DataType, StructField, StructType}

import scala.collection.mutable.ListBuffer

object TransformTranslation {
  val dataTypeToTransform: Map[String, (ListBuffer[TransformationStep], DataType) => ListBuffer[TransformationStep]] = Map(
    "array" -> explodeTranslation,
    "string" -> projectColumn,
    "int" -> projectColumn,
    "struct" -> structTranslation,
    "long" -> projectColumn
  )

  def structTranslation( list: ListBuffer[TransformationStep], dataType: DataType) = {
    val item = new TransformationStep(TransformLabel.Branch, "struct")
    list += item


    val subType : StructType = dataType.asInstanceOf[StructType]
    for (field <- subType.fields)
      {
        ListFieldTransforms(list, field)
      }
    list
  }

  def explodeTranslation( list: ListBuffer[TransformationStep], dataType: DataType) = {
    val item = new TransformationStep(TransformLabel.Explode, s"explode(${dataType.typeName})")
    list += item
    val subType : ArrayType = dataType.asInstanceOf[ArrayType]
    ListDataTypeTransforms(list, subType.elementType)
  }

  def projectColumn( list: ListBuffer[TransformationStep], dataType: DataType) = {
    val item = new TransformationStep(TransformLabel.Project, s"project(${dataType.typeName}")
    list += item
    list
  }

  def GetDataTypeTransform( dataType: DataType ) = {
    dataTypeToTransform.get(dataType.typeName)
  }

  def ListDataTypeTransforms( list: ListBuffer[TransformationStep], dataType: DataType) = {
    dataTypeToTransform(dataType.typeName)(list, dataType)
  }

  def ListFieldTransforms( list: ListBuffer[TransformationStep], field: StructField)  =
  {
    val item = new TransformationStep(TransformLabel.Transform, s"Transform(${field.name})")
    list += item
    dataTypeToTransform(field.dataType.typeName)(list, field.dataType)
  }
}
// alt+enter top tip
// convert to list in- list out functions.