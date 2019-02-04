package Job

import Compute.SessionConfig
import Logging.{Logger, PrintLnLogger}

object SalesOrderJob extends Job(SalesOrderStorage) {

  override def main(args: Array[String]): Unit = {
    super.main(args)
  }

  override val logger: Logger = PrintLnLogger
  override val activities = OrderCreatedActivities
  override val sessionConfig = new SessionConfig(true, "","","")

}
