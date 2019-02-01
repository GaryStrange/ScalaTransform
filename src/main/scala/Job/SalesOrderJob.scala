package Job

import Compute.SessionConfig

object SalesOrderJob extends Job(SalesOrderStorage) {

  override def main(args: Array[String]): Unit = {
    super.main(args)
  }

  override val activities = new JobActivities
  override val sessionConfig = new SessionConfig(true, "","","")

}
