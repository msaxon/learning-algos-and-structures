package com.maestro.learn.algorithms.sorting

import com.maestro.testUtils.SortingTestBase

class MergeSorterSuite extends SortingTestBase {
  override def sorter: ISorter = MergeSorter
  override def sorterName: String = "Merge Sort"
}
