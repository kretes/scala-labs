package org.scalalabs.basic.lab01

import java.lang.{ IllegalArgumentException => IAE }
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
@RunWith(classOf[JUnitRunner])
class CurrencyExerciseTest extends Specification {

  "Creating an Euro" should {
    "be initialized correctly" in {
      val e = new Euro(1, 5)
      e.euro ==== 1
      e.cents ==== 5
    }
    "have correct default value for cents" in {
      val e = new Euro(2)
      e.euro ==== 2
      e.cents ==== 0
    }
    "convert amount correctly to cents" in {
      val e = new Euro(2, 45)
      e.inCents ==== 245
    }
    "be created by cents" in {
      val e = Euro.fromCents(245)
      e.euro ==== 2
      e.cents ==== 45
    }
  }
  "Calculating with Euros" should {
    "add another euro correctly" in {
      val res = new Euro(1, 50) + new Euro(2, 70)
      res.euro ==== 4
      res.cents ==== 20
    }
    "multiply correctly by a factor" in {
      val res = new Euro(1, 50) * 3
      res.euro ==== 4
      res.cents ==== 50
    }
  }
  "toString of Euro" should {
    "have correct representation" in {
      val e = new Euro(2, 5)
      e.toString ==== "EUR: 2,05"
      val e2 = new Euro(2)
      e2.toString ==== "EUR: 2,--"
    }
  }
}
