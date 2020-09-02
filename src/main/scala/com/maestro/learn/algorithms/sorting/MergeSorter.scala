package com.maestro.learn.algorithms.sorting

/**
  * Time Complexity
  *   Best Case: O(n log(n))
  *   Average Case: O(n log(n))
  *   Worst Case: O(n log(n))
  *
  * Space Complexity
  *   Worst Case: O(n)
  *
  * Fast and consistent, but takes more space
  */
object MergeSorter extends ISorter {
  def sort(arr: Array[Int]): Array[Int] = {
    if(arr.length == 1) {
      return arr
    }

    val splitArray: (Array[Int], Array[Int]) = arr.splitAt(arr.length / 2)
    val left = sort(splitArray._1)
    val right = sort(splitArray._2)

    merge(left, right)
  }

  private def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
    val combinedArray = new Array[Int](left.length + right.length)
    var leftIndexCounter = 0
    var rightIndexCounter = 0
    var combinedIndexCounter = 0

    while(combinedIndexCounter < combinedArray.length) {
      if(leftIndexCounter == left.length) {
        combinedArray(combinedIndexCounter) = right(rightIndexCounter)
        rightIndexCounter += 1
        combinedIndexCounter += 1
      } else if(rightIndexCounter == right.length) {
        combinedArray(combinedIndexCounter) = left(leftIndexCounter)
        leftIndexCounter += 1
        combinedIndexCounter += 1
      } else if(left(leftIndexCounter) <= right(rightIndexCounter)) {
        combinedArray(combinedIndexCounter) = left(leftIndexCounter)
        leftIndexCounter += 1
        combinedIndexCounter += 1
      } else {
        combinedArray(combinedIndexCounter) = right(rightIndexCounter)
        rightIndexCounter += 1
        combinedIndexCounter += 1
      }
    }

    combinedArray
  }
}
