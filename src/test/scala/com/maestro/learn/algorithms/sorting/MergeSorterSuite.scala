package com.maestro.learn.algorithms.sorting

import com.maestro.CustomAsserts
import com.maestro.testUtils.UnitTestTimer
import org.scalatest.wordspec.AnyWordSpec

class MergeSorterSuite extends AnyWordSpec {
  private val COLLECTION_SIZE = 10000000
  private val timer = new UnitTestTimer("MergeSorter")

  "MergeSort" when {
    "called with an Array[Int]" should {
      "return a sorted Int array" in {
        val unSortedArr = Array(1,6,4,8,10,3,7,5,2,9)
        assert(CustomAsserts.assertInOrder(MergeSorter.sort(unSortedArr)))
      }
    }
    "called with a large sorted Array[Int]" should {
      "return a sorted Array[Int]" in {
        timer.startTime("Sorted Array Setup")
        val preSortedInts = (0 to COLLECTION_SIZE).toArray
        timer.stopTime("Sorted Array Setup")

        timer.startTime("Sorted Array Run")
        assert(CustomAsserts.assertInOrder(MergeSorter.sort(preSortedInts)))
        timer.stopTime("Sorted Array Run")
      }
    }
    "called with a large reversed sorted Array[Int]" should {
      "return a sorted Array[Int]" in {
        timer.startTime("Reversed Array Setup")
        val preSortedReversedInts = (COLLECTION_SIZE to 0 by -1).toArray
        timer.stopTime("Reversed Array Setup")

        timer.startTime("Reversed Array Run")
        assert(CustomAsserts.assertInOrder(MergeSorter.sort(preSortedReversedInts)))
        timer.stopTime("Reversed Array Run")
      }
    }
    "called with a fully random Array[Int]" should {
      "return a sorted Array[Int]" in {
        timer.startTime("Random Array Setup")
        val randomInts = Array.fill(COLLECTION_SIZE){scala.util.Random.nextInt(COLLECTION_SIZE)}
        timer.stopTime("Random Array Setup")

        timer.startTime("Random Array Run")
        assert(CustomAsserts.assertInOrder(MergeSorter.sort(randomInts)))
        timer.stopTime("Random Array Run")
      }
    }
  }
}
