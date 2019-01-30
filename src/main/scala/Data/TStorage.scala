package Data

import org.apache.spark.sql._
import org.apache.spark.sql.functions.{col, date_format}
import org.apache.spark.sql.types.StructType

trait TStorage {

  val READING_OPTION_MULTILINE = "multiLine"

  private def partitionColumn(columnName: String) = col(columnName)

  def readData(session: SparkSession, schema: StructType) = {
    session
      .read
      .option(READING_OPTION_MULTILINE, value = true)
      .schema(schema)
      .json(storagePaths.landingPath)
  }

  private def withPartitionColumns(data:DataFrame, partitionColumn: Column)= {
    data
      .withColumn("yy", date_format(partitionColumn, "yyyy"))
      .withColumn("mm", date_format(partitionColumn, "MM"))
      .withColumn("dd", date_format(partitionColumn, "dd"))
      .withColumn("hh", date_format(partitionColumn, "HH"))
  }

  def writeData(data: DataFrame, config: WriteConfig) = {
    withPartitionColumns(data, partitionColumn(config.dateTimeColumnForPartitioning))
      .repartition(numPartitions = config.numPartitions)
      .write
      .mode(config.saveMode)
      .partitionBy("yy", "mm", "dd", "hh")
      .format(config.format)
      .save(storagePaths.stagingPath)
  }

  val storagePaths : StoragePaths
}
