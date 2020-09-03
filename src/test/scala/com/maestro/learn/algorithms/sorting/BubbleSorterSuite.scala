package com.maestro.learn.algorithms.sorting

import com.maestro.testUtils.SortingTestBase

/**
  * Time Complexity
  *   Best Case: O(n)
  *   Average Case: O(n^2)
  *   Worst Case: O(n^2)
  *
  * Space Complexity
  *   Worst Case: O(1)
  *
  * In space sort, nice if the arr is already sorted ;) but otherwise useless
  */
class BubbleSorterSuite extends SortingTestBase {
  override def sorter: ISorter = BubbleSorter
  override def sorterName: String = "Bubble Sort"
}
