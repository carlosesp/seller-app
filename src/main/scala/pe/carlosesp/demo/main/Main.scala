package pe.carlosesp.demo.main

import pe.carlosesp.demo.seller.BeerSeller

object Main {
  def main(args: Array[String]): Unit = {
    println(BeerSeller.getBeer(20))
  }
}