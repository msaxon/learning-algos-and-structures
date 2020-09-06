package com.maestro.learn.algorithms.searching

object BinarySearcher extends ISearcher {
  override def search(array: Array[Int], value: Int): Int = {
    binarySearch(array, value, 0, array.size - 1)
  }

  private def binarySearch(arr: Array[Int], value: Int, low: Int, high: Int): Int = {
    val index = (high + low) / 2
    if(arr(index) == value) {
      index
    } else if (low >= high) {
      -1
    } else if(arr(index) > value) {
      binarySearch(arr, value, low, index - 1)
    } else {
      binarySearch(arr, value, index + 1, high)
    }
  }
}
