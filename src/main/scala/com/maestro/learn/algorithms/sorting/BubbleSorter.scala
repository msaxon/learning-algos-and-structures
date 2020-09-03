package com.maestro.learn.algorithms.sorting

import scala.util.control.Breaks._

/**
  * Time Complexity
  *   Best Case: O(n log(n))
  *   Average Case: O(n^2 / 2^p) ??? from wikipedia
  *   Worst Case: O(n^2)
  *
  * Space Complexity
  *   Worst Case: O(1)
  *
  * In space sort, surprisingly fast??
  */
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
}
