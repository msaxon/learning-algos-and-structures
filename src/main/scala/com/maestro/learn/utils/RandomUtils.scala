package com.maestro.learn

import scala.util.Random

object RandomUtils {
  def nextInt(min: Int, max: Int): Int = min + Random.nextInt(max - min)
}
