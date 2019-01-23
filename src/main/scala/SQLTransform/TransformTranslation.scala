package SQLTransform

import org.apache.spark.sql.types.{DataType,ArrayType,StructType,StructField}
import scala.collection.mutable.ListBuffer

object TransformTranslation {
  val dataTypeToTransform: Map[String, (ListBuffer[String], DataType) => ListBuffer[String]] = Map(
    "array" -> explodeTranslation,
    "string" -> projectColumn,
    "int" -> projectColumn,
    "struct" -> structTranslation,
    "long" -> projectColumn
  )

  def structTranslation( list: ListBuffer[String], dataType: DataType) = {
    list += "struct"
    val subType : StructType = dataType.asInstanceOf[StructType]
    for (field <- subType.fields)
      {
        ListFieldTransforms(list, field)
      }
    list
  }

  def explodeTranslation( list: ListBuffer[String], dataType: DataType) = {
    list += s"explode(${dataType.typeName})"
    val subType : ArrayType = dataType.asInstanceOf[ArrayType]
    ListDataTypeTransforms(list, subType.elementType)
  }

  def projectColumn( list: ListBuffer[String], dataType: DataType) = {
    list += s"project(${dataType.typeName}"
    list
  }

  def GetDataTypeTransform( dataType: DataType ) = {
    dataTypeToTransform.get(dataType.typeName)
  }

  def ListDataTypeTransforms( list: ListBuffer[String], dataType: DataType) = {
    dataTypeToTransform(dataType.typeName)(list, dataType)
  }

  def ListFieldTransforms( list: ListBuffer[String], field: StructField)  =
  {
    list += s"Transform(${field.name})"
    dataTypeToTransform(field.dataType.typeName)(list, field.dataType)
  }
}
// alt+enter top tip
// convert to list in- list out functions.