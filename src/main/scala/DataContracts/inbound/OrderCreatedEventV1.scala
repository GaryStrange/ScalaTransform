package DataContracts.inbound

case class OrderCreatedEventV1(
  entityType: String,
  OrderReference: String
)
