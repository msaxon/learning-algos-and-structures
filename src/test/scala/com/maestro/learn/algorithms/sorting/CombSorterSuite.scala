package com.maestro.learn.algorithms.sorting

import com.maestro.testUtils.SortingTestBase

class CombSorterSuite extends SortingTestBase {
  override def sorter: ISorter = CombSorter
  override def sorterName: String = "Comb Sorter"
}
