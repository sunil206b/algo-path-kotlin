package algorithms.sorting

import kotlin.random.Random

fun quickSort(numbers: IntArray) {
  quickSort(numbers, 0, numbers.lastIndex)
}

private fun quickSort(numbers: IntArray, lowIndex: Int, highIndex: Int) {
  if (lowIndex >= highIndex) return

  val pivotIndex = Random.nextInt(highIndex - lowIndex) + lowIndex
  val pivot = numbers[pivotIndex]
  swap(numbers, pivotIndex, highIndex)

  val leftPointer = partition(numbers, lowIndex, highIndex, pivot)


  quickSort(numbers, lowIndex, leftPointer - 1)
  quickSort(numbers, leftPointer + 1, highIndex)
}

private fun partition(numbers: IntArray, lowIndex: Int, highIndex: Int, pivot: Int): Int {
  var leftPointer = lowIndex
  var rightPointer = highIndex

  while (leftPointer < rightPointer) {

    // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
    while (numbers[leftPointer] <= pivot && leftPointer < rightPointer) {
      leftPointer++
    }

    // Walk from the right until we find a number less than the pivot, or hit the left pointer.
    while (numbers[rightPointer] >= pivot && leftPointer < rightPointer) {
      rightPointer--
    }

    swap(numbers, leftPointer, rightPointer)
  }

  // Where the last value could potentially be out of order.
  if (numbers[leftPointer] > numbers[highIndex]) {
    swap(numbers, leftPointer, highIndex)
  } else {
    leftPointer = highIndex
  }
  return leftPointer
}

private fun swap(numbers: IntArray, leftIndex: Int, rightIndex: Int) {
  val temp = numbers[leftIndex]
  numbers[leftIndex] = numbers[rightIndex]
  numbers[rightIndex] = temp
}