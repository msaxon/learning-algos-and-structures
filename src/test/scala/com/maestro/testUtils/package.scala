package com.maestro

import com.maestro.learn.algorithms.structures.LinkedList

package object CustomAsserts {
  def assertInOrder(arr:Array[Int]): Boolean = {
    for(i <- 0 until arr.length - 1) {
      if(arr(i) > arr(i + 1)) {
        return false
      }
    }
    true
  }

  def assertInOrder(li: LinkedList): Boolean = {
    for(i <- 0 until li.size - 1) {
      if(li.get(i).get > li.get(i + 1).get) {
        return false
      }
    }
    true
  }
}
