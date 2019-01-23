package SQLTransform

import DataContracts.inbound.OrderCreatedEventV1
import org.apache.spark.sql._
import org.apache.spark.sql.functions.{col, explode}
import org.apache.spark.sql.types.{LongType, StructField}

object TheJob {
  def main(args: Array[String]): Unit = {
    implicit val spark: SparkSession = SparkSession.builder.getOrCreate()
  }

  def showDataType(data:DataFrame) : String = {
    val dt = StructField("productID", LongType, nullable = true)
    val dft = data.schema.fields(1)
    return dft.dataType.typeName
  }


  def transformUsingSQLAPI(data:DataFrame) : DataFrame = {

    return data
      .withColumn("exploded", explode(col("Products")))
      .select("OrderReference", "exploded")
  }

  def transformUsingSQL(data:DataFrame) : DataFrame = {
    data.createOrReplaceTempView("Orders")

    return data.sparkSession.sql(
      "SELECT OrderReference, exploded, Promotions[0].DiscountCode, Promotions[1].NDD FROM Orders " +
        "         LATERAL VIEW explode(Products) as exploded"
    )
  }

  def transformUsingDataSet(data:Dataset[OrderCreatedEventV1]) : DataFrame = {
    return data.toDF()
  }
}
