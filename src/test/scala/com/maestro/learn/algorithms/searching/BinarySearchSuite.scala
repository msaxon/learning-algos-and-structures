package com.maestro.learn.algorithms.searching

import com.maestro.testUtils.SearchingTestBase

class BinarySearchSuite extends SearchingTestBase {
  override def searcher: ISearcher = BinarySearcher
  override def searcherName: String = "Binary Search"
}
