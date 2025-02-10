package algorithms.sorting

fun heapSort(arr: IntArray) {
  val inputSize = arr.size

  // Step 1: Build max heap
  for (i in inputSize / 2 - 1 downTo 0) {
    heapify(arr, inputSize, i)
  }

  // Step 2: Extract elements one by one from the heap
  for (i in inputSize - 1 downTo 1) {
    arr[0] = arr[i].also { arr[i] = arr[0] } // Swap max element to end
    heapify(arr, i, 0) // Re-heapify the reduced heap
  }
}

// Function to heapify a subtree rooted at index 'i'
private fun heapify(arr: IntArray, inputSize: Int, i: Int) {
  var largest = i
  val left = 2 * i + 1
  val right = 2 * i + 2

  // Check if left child exists and is greater than root
  if (left < inputSize && arr[left] > arr[largest]) {
    largest = left
  }

  // Check if right child exists and is greater than largest so far
  if (right < inputSize && arr[right] > arr[largest]) {
    largest = right
  }

  // If largest is not root, swap and continue heapifying
  if (largest != i) {
    arr[i] = arr[largest].also { arr[largest] = arr[i] }
    heapify(arr, inputSize, largest) // Recursively heapify the affected subtree
  }
}