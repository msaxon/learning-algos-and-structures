package com.maestro.learn.algorithms.sorting

import com.maestro.testUtils.SortingTestBase

class QuickSorterSuite extends SortingTestBase {
  override def sorter: ISorter = QuickSorter
  override def sorterName: String = "Quick Sort"
}
