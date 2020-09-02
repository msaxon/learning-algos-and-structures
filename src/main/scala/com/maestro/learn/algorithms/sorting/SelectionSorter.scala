package com.maestro.learn.algorithms.sorting

object SelectionSorter {
  def sort(arr: Array[Int]):Array[Int] = {
    for(i <- 0 until arr.length) {
      var min = arr(i)
      var minIndex = i
      for(j <- i until arr.length) {
        if(arr(j) < min) {
          min = arr(j)
          minIndex = j
        }
      }

      arr(minIndex) = arr(i)
      arr(i) = min
    }

    arr
  }
}
