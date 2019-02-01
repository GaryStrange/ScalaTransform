package Job

import Job.JobActivities.TActivity
import Logging.{Logger, PrintLnLogger}
import org.apache.spark.sql.{DataFrame, Dataset}

class JobActivities extends TJobActivities {
  override val logger: Logger = PrintLnLogger
  def sourceData[T]: Dataset[T] = null
  override val activities: List[TActivity] = null
}


trait TJobActivities {
  val logger: Logger

  def sourceData[T]: Dataset[T]
  val activities: List[TActivity]

  def Start(): Unit ={
    logger.log("Activity Started.")

    activities.foreach(
      _.execute(sourceData)
    )
  }
}

trait TActivity {
  def execute[T](sourceData: Dataset[T]): DataFrame

}

