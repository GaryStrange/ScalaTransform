package SQLTransform

import org.apache.spark.sql._

object TheJob {
  def main(args: Array[String]): Unit = {
    implicit val spark: SparkSession = SparkSession.builder.getOrCreate()
  }

  def transform() : Boolean = {

    return false
  }
}
