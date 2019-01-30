package Data

import org.apache.spark.sql.SaveMode

case class WriteConfig(format: String,
                       dateTimeColumnForPartitioning: String,
                       numPartitions: Int,
                       saveMode: SaveMode)
