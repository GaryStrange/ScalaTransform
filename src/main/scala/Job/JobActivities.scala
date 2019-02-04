package Job

import Data.WriteConfig
import DataContracts.inbound.EncodedContract
import Job.Transformations.TTransform
import Logging.{Logger, PrintLnLogger}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{DataFrame, Dataset}

//class OrderCreatedActivities extends TJobActivities {
//  override val logger: Logger = PrintLnLogger
//  def sourceData( reader: (StructType, String) => DataFrame ): DataFrame = null
//  def transformations: List[TTransform] = null
//  override val writeConfig: WriteConfig = null
//}



trait TJobActivities {
  val writeConfig: WriteConfig
  val sourceSchema: StructType
  val sourceDataSubPath: String

  def transformations: List[TTransform]

  def Process(sourceData:DataFrame, persist: ( DataFrame, String, WriteConfig) => Unit, logger:Logger): Unit ={
    logger.log("Activity Started.")

    transformations.foreach {
      case (transform: TTransform) => {
        val message = s"Executing ${transform.name}"

        persist(logger.timeAndLog(message) {
          transform.execute(sourceData)
        }
          , transform.dateTimeColumnForPartitioning
          , writeConfig)

      }
    }
  }

}



