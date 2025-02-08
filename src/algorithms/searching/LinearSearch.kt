package algorithms.searching

fun linerSearch(nums: List<Int>, target: Int): Int {
  val sortedNums = nums.sorted()

  sortedNums.forEachIndexed { index, num ->
    if (num == target) {
      return index
    }
  }
  return -1
}