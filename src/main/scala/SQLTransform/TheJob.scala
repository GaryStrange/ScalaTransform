package SQLTransform

import org.apache.spark.sql._
import org.apache.spark.sql.functions.{explode,col}
import org.apache.spark.sql.Column

object TheJob {
  def main(args: Array[String]): Unit = {
    implicit val spark: SparkSession = SparkSession.builder.getOrCreate()
  }

  def transformUsingSQLAPI(data:DataFrame) : DataFrame = {

    return data
      .withColumn("exploded", explode(col("Products")))
      .select("OrderReference", "exploded")

  }

  def transformUsingSQL(data:DataFrame) : DataFrame = {
    data.createOrReplaceTempView("Orders")

    return data.sparkSession.sql(
      "SELECT OrderReference, exploded FROM Orders LATERAL VIEW explode(Products) as exploded"
    )
  }
}
