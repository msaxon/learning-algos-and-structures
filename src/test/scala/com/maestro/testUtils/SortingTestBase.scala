package com.maestro.testUtils

import com.maestro.CustomAsserts
import com.maestro.learn.algorithms.sorting.ISorter
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

abstract class SortingTestBase extends AnyWordSpec with Matchers {
  def sorter: ISorter
  def sorterName: String
  def collectionSize: Int = 100000
  def timeSetup: Boolean = false

  private val timer = new UnitTestTimer(sorterName, collectionSize)

  s"$sorterName" when {
    "called with an Array[Int]" should {
      "return a sorted Int array" in {
        println("------------------------")
        val unSortedArr = Array(1,6,4,8,10,3,7,9,2,5)
        assert(CustomAsserts.assertInOrder(sorter.sort(unSortedArr)))
      }
    }
    "called with a large sorted Array[Int]" should {
      "return a sorted Array[Int]" in {
        if(timeSetup) timer.startTime("Sorted Array Setup")
        val preSortedInts = (0 to collectionSize).toArray
        if(timeSetup) timer.stopTime("Sorted Array Setup")

        timer.startTime("Sorted Array Run")
        assert(CustomAsserts.assertInOrder(sorter.sort(preSortedInts)))
        timer.stopTime("Sorted Array Run")
      }
    }
    "called with a large reversed sorted Array[Int]" should {
      "return a sorted Array[Int]" in {
        if(timeSetup) timer.startTime("Reversed Array Setup")
        val preSortedReversedInts = (collectionSize to 0 by -1).toArray
        if(timeSetup) timer.stopTime("Reversed Array Setup")

        timer.startTime("Reversed Array Run")
        assert(CustomAsserts.assertInOrder(sorter.sort(preSortedReversedInts)))
        timer.stopTime("Reversed Array Run")
      }
    }
    "called with a fully random Array[Int]" should {
      "return a sorted Array[Int]" in {
        if(timeSetup) timer.startTime("Random Array Setup")
        val randomInts = Array.fill(collectionSize){scala.util.Random.nextInt(collectionSize)}
        if(timeSetup) timer.stopTime("Random Array Setup")

        timer.startTime("Random Array Run")
        assert(CustomAsserts.assertInOrder(sorter.sort(randomInts)))
        timer.stopTime("Random Array Run")
      }
    }
  }
}
