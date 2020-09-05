package com.maestro.learn.algorithms.structures

class DoubleLinkedList extends ICollection {

  class Node(value: Int) {
    var prev: Node = _
    var next: Node = _

    def getValue = value

    override def toString: String = s"${getValue}"
  }

  private var root: Node = _
  private var numberOfNodes: Int = 0

  override def get(i: Int): Option[Int] = {
    if(i > numberOfNodes - 1) {

      //index is out of bounds
      Option.empty
    } else if(i > numberOfNodes / 2) {

      //index is in second half of list, go backwards
      var curr: Node = root
      for(i <- 0 until numberOfNodes - i) {
        curr = curr.prev
      }
      Option.apply(curr.getValue)
    } else {

      //index is in first half of list, go forwards
      var curr: Node = root
      for(i <- 0 until i) {
        curr = curr.next
      }
      Option.apply(curr.getValue)
    }
  }

  override def find(v: Int): Boolean = {
    var currNode = root
    while(currNode != root && currNode.getValue != v) currNode = currNode.next
    currNode != null
  }

  override def add(v: Int): Boolean = {
    if(root == null) {
      root = new Node(v)
    } else if(root.prev == null) {
      val newNode = new Node(v)
      root.next = newNode
      root.prev = newNode
      newNode.next = root
      newNode.prev = root
    } else {
      val endNode = root.prev
      val newNode = new Node(v)
      root.prev = newNode
      newNode.next = root
      endNode.next = newNode
      newNode.prev = endNode
    }

    numberOfNodes += 1
    true
  }

  override def remove(i: Int): Unit = {
    if(i < numberOfNodes) {
      var curr = root
      if(i > numberOfNodes / 2) {
        for(i <- 0 until numberOfNodes - i) {
          curr = curr.prev
        }
      } else {
        for(i <- 0 until i) {
          curr = curr.next
        }
      }

      curr.prev.next = curr.next
      curr.next.prev = curr.prev
      curr = null
      numberOfNodes -= 1
    }
  }

  override def isEmpty: Boolean = numberOfNodes == 0

  override def size: Int = numberOfNodes

  override def print: Unit = {
    var currNode = root
    while(currNode != null) {
      System.out.print(s"${currNode.getValue}, ")
      currNode = currNode.next
    }
    System.out.println(": !")
  }
}
