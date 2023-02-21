package pe.carlosesp.demo

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import pe.carlosesp.demo.seller.BeerSeller


class BeerSellerSpec extends AnyFlatSpec with Matchers {

  "BeerSeller" should "sell beer for an adult" in {
    BeerSeller.getBeer(20) shouldBe "Beer for you"
  }

  it should "not sell beer for a kid" in {
    BeerSeller.getBeer(10) shouldBe "No beer"
  }
}
