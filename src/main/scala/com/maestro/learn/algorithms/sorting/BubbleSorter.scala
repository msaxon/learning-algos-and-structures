package com.maestro.learn.algorithms.sorting

import scala.util.control.Breaks._

object BubbleSorter extends ISorter {
  override def sort(arr: Array[Int]): Array[Int] = {
    breakable {
      for(i <- 0 until arr.length - 1) {
        var swapped = false
        for(j <- 0 until arr.length - 1) {
          if(arr(j) > arr(j + 1)) {
            swap(arr, j, j+1)
            swapped = true
          }
        }
        if(!swapped) break
      }
    }

    arr
  }

  private def swap(arr: Array[Int], i: Int, j: Int):Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }
}
