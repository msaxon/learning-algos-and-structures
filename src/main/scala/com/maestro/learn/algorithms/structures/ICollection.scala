package com.maestro.learn.algorithms.structures

trait ICollection {
  def get(i: Int): Option[Int]
  def find(v: Int): Boolean
  def add(v: Int): Boolean
  def remove(i: Int): Unit
  def isEmpty: Boolean
  def size: Int
  def print: Unit
}
