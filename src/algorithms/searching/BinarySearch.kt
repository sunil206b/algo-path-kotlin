package algorithms.searching

fun binarySearch(nums: List<Int>, target: Int): Int {
  val sortedNums = nums.sorted()
  var low = 0
  var high = nums.size - 1

  while (low <= high) {
    val mid = low + (high - low) / 2
    println(mid)

    val current = sortedNums.get(mid)
    when {
      current == target -> return mid
      current < target -> low++
      else -> low--
    }
  }

  return -1
}