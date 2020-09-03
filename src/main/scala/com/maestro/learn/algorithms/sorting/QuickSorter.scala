package com.maestro.learn.algorithms.sorting

import com.maestro.learn.RandomUtils

/**
  * Time Complexity
  *   Best Case: O(n log(n))
  *   Average Case: O(n log(n))
  *   Worst Case: O(n^2)
  *
  * Space Complexity
  *   Worst Case: O(1)
  *
  * In space sort, super fast, but a bad random start could cause stack overflow?
  */
object QuickSorter extends ISorter {

  override def sort(arr: Array[Int]): Array[Int] = {
    quickSort(arr, 0, arr.length-1)
    arr
  }

  private def quickSort(arr: Array[Int], low: Int, high: Int): Unit = {
    if(low < high) {
      val pivotIndex = partitionR(arr, low, high)
      quickSort(arr, low, pivotIndex - 1)
      quickSort(arr, pivotIndex + 1, high)
    }
  }

  private def partitionR(arr: Array[Int], low: Int, high: Int): Int = {
    val randomPivot = RandomUtils.nextInt(low, high)

    //swap
    val tempR = arr(randomPivot)
    arr(randomPivot) = arr(high)
    arr(high) = tempR
    partition(arr, low, high)
  }

  private def partition(arr: Array[Int], low: Int, high: Int): Int = {
    val pivot = arr(high)
    var i = low - 1

    for(j <- low until high) {
      if(arr(j) < pivot) {
        i += 1

        //swap
        val tempI = arr(i)
        arr(i) = arr(j)
        arr(j) = tempI
      }
    }

    //swap
    val tempIPlusOne = arr(i+1)
    arr(i+1) = arr(high)
    arr(high) = tempIPlusOne
    i + 1
  }
}
