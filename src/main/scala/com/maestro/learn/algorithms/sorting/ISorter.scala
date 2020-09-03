package com.maestro.learn.algorithms.sorting

trait ISorter {
  def sort(arr: Array[Int]): Array[Int]

  def swap(arr: Array[Int], i: Int, j: Int):Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }
}
