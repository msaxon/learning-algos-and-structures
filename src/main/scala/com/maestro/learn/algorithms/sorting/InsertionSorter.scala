package com.maestro.learn.algorithms.sorting

object InsertionSorter {
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
