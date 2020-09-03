package com.maestro.learn.algorithms.sorting

import com.maestro.testUtils.SortingTestBase

class RadixSorterSuite extends SortingTestBase {
  override def sorter: ISorter = RadixSorter
  override def sorterName: String = "Radix Sorter"
}
