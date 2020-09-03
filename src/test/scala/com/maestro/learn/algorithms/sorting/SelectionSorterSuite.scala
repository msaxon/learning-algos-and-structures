package com.maestro.learn.algorithms.sorting

import com.maestro.testUtils.SortingTestBase

class SelectionSorterSuite extends SortingTestBase {
  override def sorter: ISorter = SelectionSorter
  override def sorterName: String = "Selection Sort"
}
