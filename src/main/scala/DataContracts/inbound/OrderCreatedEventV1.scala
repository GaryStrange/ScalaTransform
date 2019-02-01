package DataContracts.inbound

import org.apache.spark.sql.{Encoder, Encoders}

case class OrderCreatedEventV1(
  entityType: String,
  OrderReference: String
) extends EncodedContract[OrderCreatedEventV1]
{
  val encoder: Encoder[OrderCreatedEventV1] = Encoders.product[OrderCreatedEventV1]
}




