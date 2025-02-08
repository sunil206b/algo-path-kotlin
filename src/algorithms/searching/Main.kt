package main

import algorithms.searching.binarySearch
import algorithms.searching.linerSearch

fun main() {
  val nums = listOf(10, 5, 3, 7, 2, 15, 13, 20, 12, 6)

  val index = binarySearch(nums, 15)
  println("Binary search: $index")

  val i = linerSearch(nums, 15)
  println("Linear search: $i")
}