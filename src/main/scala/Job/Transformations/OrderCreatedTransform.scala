package Job.Transformations

import org.apache.spark.sql.DataFrame

object OrderCreatedTransform extends TTransform {
  def execute(sourceData: DataFrame): DataFrame = {
    sourceData.select("OrderReference")
  }
  override val name: String = "OrderCreated Event Transformation"
  override val dateTimeColumnForPartitioning: String = "orderCreated"
}
