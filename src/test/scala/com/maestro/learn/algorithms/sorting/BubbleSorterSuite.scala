package com.maestro.learn.algorithms.sorting

import com.maestro.testUtils.SortingTestBase

class BubbleSorterSuite extends SortingTestBase {
  override def sorter: ISorter = BubbleSorter
  override def sorterName: String = "Bubble Sort"
}
