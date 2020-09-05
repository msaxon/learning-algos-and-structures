package com.maestro.learn.algorithms.structures

import com.maestro.testUtils.StructuresTestBase

class DoubleLinkedListSuite extends StructuresTestBase {
  private val list: DoubleLinkedList = new DoubleLinkedList();
  override def structure: ICollection = list
  override def structureName: String = "Double Linked List"
}
