package Job

import Data.WriteConfig
import DataContracts.inbound.{OrderCreatedEventV1}
import Job.Transformations.{OrderCreatedTransform, TTransform}
import org.apache.spark.sql.{SaveMode}
import org.apache.spark.sql.types.StructType

object OrderCreatedActivities extends TJobActivities {
  def transformations: List[TTransform] = List(OrderCreatedTransform)

  override val sourceSchema: StructType = OrderCreatedEventV1.encoder.schema
  override val sourceDataSubPath: String = "/OrderCreatedEventV1"

  override val writeConfig: WriteConfig = WriteConfig(
    numPartitions = 1,
    saveMode = SaveMode.Append
  )
}
