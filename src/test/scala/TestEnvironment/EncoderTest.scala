package TestEnvironment

import DataContracts.inbound.OrderCreatedEventV1
import org.specs2.mutable.Specification

class EncoderTest extends Specification {
  "OrderCreatedEventV1 EncoderTest" should {
    "return true" in {

      println(OrderCreatedEventV1.encoder.schema)
      true must_=== true
    }
  }
}