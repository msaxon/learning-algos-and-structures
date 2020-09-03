package com.maestro.learn.algorithms.sorting

/**
  * Time Complexity
  *   Best Case: O(n + k)
  *   Average Case: O(n + k)
  *   Worst Case: O(n + k)
  *
  * Space Complexity
  *   Worst Case: O(n + k)
  *
  * I conceptually understand what the code does, but not how it does it. V fast though
  */
object RadixSorter extends ISorter {

  private def countingSort(array: Array[Int], d: Int): Unit = {
    val output = new Array[Int](array.length)
    val count: Array[Int] = Array.fill[Int](10)(0)

    //store count of occurrences in count
    for(i <- 0 until array.length) {
      count(array(i)/d % 10) += 1
    }

    //change count[i[ so that count[i] now contains actual position of this digit in output
    for(i <- 1 until 10) {
      count(i) += count(i - 1)
    }

    //build the output array
    for(i <- array.length - 1 to 0 by -1) {
      output(count((array(i)/d)%10) - 1) = array(i)
      count((array(i)/d)%10) -= 1
    }

    //copy output array to array so that arr now contains sorted numbers
    for(i <- 0 until array.length) {
      array(i) = output(i)
    }

  }

  override def sort(arr: Array[Int]): Array[Int] = {
    val max = getMaxElement(arr)
    var i = 1
    while(max / i > 0) {
      countingSort(arr, i)
      i *= 10
    }

    arr
  }

  private def getMaxElement(arr:Array[Int]): Int = {
    var max = arr(0)
    for(i <- 0 until arr.length) {
      if(arr(i) > max) max = arr(i)
    }
    max
  }
}
