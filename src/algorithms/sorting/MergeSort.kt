package algorithms.sorting

fun mergeSort(numbers: IntArray) {
  val inputSize = numbers.size

  // If there is only one element return
  if (inputSize < 2) {
    return
  }

  val midIndex = inputSize / 2
  val leftHalf = numbers.copyOfRange(0, midIndex)
  val rightHalf = numbers.copyOfRange(midIndex, inputSize)

  mergeSort(leftHalf)
  mergeSort(rightHalf)

  merge(numbers, leftHalf, rightHalf)
}

private fun merge(numbers: IntArray, leftHalf: IntArray, rightHalf: IntArray) {
  val lefSize = leftHalf.size
  val rightSize = rightHalf.size

  // To iterate over left half
  var l = 0
  // To iterate over right half
  var r = 0
  // To iterate over main array
  var i = 0

  while (l < lefSize && r < rightSize) {
    if (leftHalf[l] <= rightHalf[r]) {
      numbers[i] = leftHalf[l]
      l++
    } else {
      numbers[i] = rightHalf[r]
      r++
    }
    i++
  }

  while (l < lefSize) {
    numbers[i] = leftHalf[l]
    l++
    i++
  }

  while (r < rightSize) {
    numbers[i] = rightHalf[r]
    r++
    i++
  }
}