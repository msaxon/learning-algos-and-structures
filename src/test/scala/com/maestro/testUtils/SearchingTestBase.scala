package com.maestro.testUtils

import com.maestro.learn.algorithms.searching.ISearcher
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

abstract class SearchingTestBase extends AnyWordSpec with Matchers {
  def searcher: ISearcher
  def searcherName: String
  def collectionSize: Int = 10000

  private val timer = new UnitTestTimer(searcherName, collectionSize)

  s"$searcherName" when {
    println("------------------------")
    "called with an Array[Int]" should {
      "it should do basic things" in {
        val sortedArr = Array(0,1,2,3,4,5,6,7,8,9)
        assert(searcher.search(sortedArr, 5) == 5)
      }
    }
    "search for a bunch of things" should {
      "find them all quickly" in {
        val sortedArr = (0 to collectionSize).toArray
        timer.startTime("Random Searches")
        for(i <- 0 until collectionSize) {
          val value = scala.util.Random.nextInt(collectionSize - 1)
          assert(searcher.search(sortedArr, value) == value)
        }
        timer.stopTime("Random Searches")
      }
    }
  }
}
