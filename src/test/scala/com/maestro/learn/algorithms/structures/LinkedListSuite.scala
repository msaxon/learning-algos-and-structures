package com.maestro.learn.algorithms.structures

import com.maestro.CustomAsserts
import com.maestro.testUtils.StructuresTestBase

class LinkedListSuite extends StructuresTestBase {
  val list:LinkedList = new LinkedList()
  override def structure: ICollection = list
  override def structureName: String = "Linked List"

  s"$structureName" when {
    "reversing the list" should {
      "it works" in {
        for(i <- 0 until collectionSize) {
          structure.add(i)
        }

        timer.startTime("Reverse")
        structure.asInstanceOf[LinkedList].reverse
        timer.stopTime("Reverse")

        CustomAsserts.assertInOrder(structure.asInstanceOf[LinkedList])
      }
    }
  }
}
