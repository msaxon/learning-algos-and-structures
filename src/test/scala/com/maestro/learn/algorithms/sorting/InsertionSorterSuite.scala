package com.maestro.learn.algorithms.sorting

import com.maestro.testUtils.SortingTestBase

class InsertionSorterSuite extends SortingTestBase {
  override def sorter: ISorter = InsertionSorter
  override def sorterName: String = "Insertion Sort"
}
