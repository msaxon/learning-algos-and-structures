package com.maestro

package object CustomAsserts {
  def assertInOrder(arr:Array[Int]): Boolean = {
    for(i <- 0 until arr.length - 1) {
      if(arr(i) > arr(i + 1)) {
        return false
      }
    }
    return true
  }
}
