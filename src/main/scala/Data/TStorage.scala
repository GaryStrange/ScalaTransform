package Data

import org.apache.spark.sql._
import org.apache.spark.sql.functions.{col, date_format}
import org.apache.spark.sql.types.StructType

trait TStorage {

  val READING_OPTION_MULTILINE = "multiLine"

  private def partitionColumn(columnName: String) = col(columnName)

  def readData(session: SparkSession, schema: StructType, subPath: String) = {
    session
      .read
      .option(READING_OPTION_MULTILINE, value = true)
      .schema(schema)
      .json(storagePaths.landingPath + subPath)
  }


  private def withPartitionColumns(data: DataFrame, partitionColumn: Column) = {
    data
      .withColumn("yy", date_format(partitionColumn, "yyyy"))
      .withColumn("mm", date_format(partitionColumn, "MM"))
      .withColumn("dd", date_format(partitionColumn, "dd"))
      .withColumn("hh", date_format(partitionColumn, "HH"))
  }

  def writeData(format: String)(data: DataFrame, dateTimeColumnForPartitioning: String, config: WriteConfig) = {
    withPartitionColumns(data, partitionColumn(dateTimeColumnForPartitioning))
      .repartition(numPartitions = config.numPartitions)
      .write
      .mode(config.saveMode)
      .partitionBy("yy", "mm", "dd", "hh")
      .format(format)
      .save(storagePaths.stagingPath)
  }

  val storagePaths: StoragePaths
}
