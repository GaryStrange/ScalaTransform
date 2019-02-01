package TestEnvironment

import DataContracts.inbound.OrderCreatedEventV1
import org.specs2.mutable.Specification

class EncoderTest extends Specification {
  "OrderCreatedEventV1 EncoderTest" should {
    "return true" in {
      val event: OrderCreatedEventV1 = OrderCreatedEventV1("hello", "world")

      println(event.encoder.schema)
      true must_=== true
    }
  }
}