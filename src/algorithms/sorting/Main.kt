package algorithms.sorting

import kotlin.random.Random

fun main() {
  val numbers = IntArray(10) { Random.nextInt(1, 100) }
  println("Before QuickSort: ${numbers.joinToString()}")
  quickSort(numbers)
  println("After QuickSort: ${numbers.joinToString()}")

  val numbers1 = IntArray(10) { Random.nextInt(1, 100) }
  println("Before MergeSort: ${numbers1.joinToString()}")
  mergeSort(numbers1)
  println("After MergeSort: ${numbers1.joinToString()}")

  val arr = IntArray(10) { Random.nextInt(1, 100) }
  println("Before HeapSort: ${arr.joinToString()}")
  heapSort(arr)
  println("After HeapSort: ${arr.joinToString()}")
}