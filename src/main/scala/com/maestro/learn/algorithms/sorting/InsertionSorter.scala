package com.maestro.learn.algorithms.sorting

/**
  * Time Complexity
  *   Best Case: O(n)
  *   Average Case: O(n^2)
  *   Worst Case: O(n^2)
  *
  * Space Complexity
  *   Worst Case: O(1)
  *
  * Good if the array is partially ordered already, otherwise slow
  */
object InsertionSorter extends ISorter {
  def sort(arr: Array[Int]): Array[Int] = {
    for(i <- 1 until arr.length) {
      val key = arr(i)
      for(j <- i to 0 by -1) {
        if(arr(j) > key) {
          arr(j+1) = arr(j)
          arr(j) = key
        }
      }
    }
    arr
  }
}
