package com.maestro.testUtils

import com.maestro.learn.algorithms.structures.ICollection
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.util.Random

abstract class StructuresTestBase extends AnyWordSpec with Matchers {
  def structure: ICollection
  def structureName: String
  def collectionSize: Int = 10000

  val timer = new UnitTestTimer(structureName, collectionSize)

  s"$structureName" when {
    println("------------------------")
    "adding ten elements" should {
      "add them all correctly" in {
        //add
        for(i <- 0 to 10) {
          structure.add(i)
        }
        assert(structure.size == 11)

        //access
        for(i <- 0 to 10) {
          assert(structure.get(i).get == i)
        }

        //find
        for(i <- 0 to 10) {
          assert(structure.find(i))
        }

        //remove
        for(i <- structure.size-1 to 0 by -1) {
          structure.remove(i)
        }
        assert(structure.size == 0)
      }
    }
    "timing a lot of element adds" should {
      "work" in {
        timer.startTime("Add")
        for(i <- 0 until collectionSize) {
          structure.add(i)
        }
        assert(structure.size == collectionSize)
        timer.stopTime("Add")
      }
    }
    "timing a lot of element removes" should {
      "work" in {
        timer.startTime("Remove")
        for(i <- 0 until structure.size) {
          structure.remove(Random.nextInt(structure.size))
        }
        assert(structure.size == 0)
        timer.stopTime("Remove")
      }
    }
    "timing a lot of element search" should {
      "work" in {
        for(i <- 0 until collectionSize) {
          structure.add(i)
        }

        timer.startTime("Search")
        for(i <- 0 until collectionSize) {
          structure.find(i)
        }
        timer.stopTime("Search")
      }
    }
    "timing a lot of element access" should {
      "work" in {
        for(i <- 0 until collectionSize) {
          structure.add(i)
        }

        timer.startTime("Access")
        for(i <- 0 until collectionSize) {
          structure.get(i)
        }
        timer.stopTime("Access")
      }
    }
  }
}
