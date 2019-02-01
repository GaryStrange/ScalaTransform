package DataContracts.inbound

import org.apache.spark.sql.Encoder

trait EncodedContract[T] {
  val encoder: Encoder[T]
}
