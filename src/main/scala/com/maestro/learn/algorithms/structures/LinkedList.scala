package com.maestro.learn.algorithms.structures

class LinkedList extends ICollection {
  class Node(var value: Int) {
    var next: Node = _

    def getValue:Int = value
    def setValue(v: Int): Unit = value = v

    def getNext: Node = rootNode
    def setNext(n: Node): Unit = next = n
  }

  var rootNode: Node = _
  var numberOfNodes = 0

  override def get(i: Int): Option[Int] = {
    if(i < size) {
      var currNode = rootNode
      for(j <- 0 until i) {
        currNode = currNode.next
      }
      Option.apply(currNode.getValue)
    } else Option.empty
  }

  override def find(v: Int): Boolean = {
    var currNode = rootNode
    while(currNode != null && currNode.getValue != v) currNode = currNode.next
    currNode != null
  }

  override def add(v: Int): Boolean = {
    if(rootNode == null) {
      rootNode = new Node(v)
    } else {
      val newNode = new Node(v)
      newNode.setNext(rootNode)
      rootNode = newNode
    }
    numberOfNodes += 1
    true
  }

  override def remove(i: Int): Unit = {
    var currNode: Node = rootNode
    var prevNode: Node = null
    for(j <- 0 until i) {
      prevNode = currNode
      currNode = currNode.next
    }

    if(currNode != null && prevNode != null) {
      prevNode.setNext(currNode.next)
    }

    numberOfNodes -= 1
  }

  override def isEmpty: Boolean = rootNode == null

  override def size: Int = numberOfNodes

  override def print: Unit = {
    var currNode = rootNode
    while(currNode != null) {
      System.out.print(s"${currNode.getValue}, ")
      currNode = currNode.next
    }
    System.out.println(": !")
  }

  /******* Other Linked List Things *******/

  def reverse: Unit = {
    var prev:Node = null
    var curr:Node = rootNode
    var next:Node = null
    for(i <- 0 until numberOfNodes) {
      next = curr.next
      curr.next = prev
      prev = curr
      curr = next
    }
    rootNode = curr
  }

  def getNthFromEnd(i:Int): Option[Int] = {
    val index = size - i
    get(index)
  }
}
