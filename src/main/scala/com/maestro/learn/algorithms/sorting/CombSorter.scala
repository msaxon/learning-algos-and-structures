package com.maestro.learn.algorithms.sorting

object CombSorter extends ISorter {
  override def sort(arr: Array[Int]): Array[Int] = {
    var gap:Double = arr.length
    val shrink:Double = 1.3
    var sorted:Boolean = false

    while(!sorted) {
      gap = Math.floor(gap / shrink)
      if(gap <= 1) {
        gap = 1
        sorted = true
      }

      var i = 0
      while(i + gap < arr.length) {
        if(arr(i) > arr((i + gap).toInt)) {
          swap(arr, i, (i + gap).toInt)
          sorted = false
        }

        i += 1
      }
    }
    arr
  }
}
