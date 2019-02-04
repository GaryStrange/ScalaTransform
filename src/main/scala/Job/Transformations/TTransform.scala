package Job.Transformations

import org.apache.spark.sql.DataFrame

trait TTransform {
  def execute(sourceData: DataFrame): DataFrame
  val name: String
  val dateTimeColumnForPartitioning: String
}
