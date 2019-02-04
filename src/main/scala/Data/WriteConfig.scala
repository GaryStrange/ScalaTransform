package Data

import org.apache.spark.sql.SaveMode

case class WriteConfig(
                       numPartitions: Int,
                       saveMode: SaveMode)
