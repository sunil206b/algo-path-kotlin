package algorithms.graphs.bfs

import java.util.*

fun numberOfIslands(grid: Array<CharArray>): Int {
  if (grid.isEmpty()) return 0

  val directions = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

  val rows = grid.size
  val cols = grid[0].size
  var count = 0

  for (r in 0 until rows) {
    for (c in 0 until cols) {
      if (grid[r][c] == '1') {
        count++
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(r, c))
        grid[r][c] = '0'

        while (queue.isNotEmpty()) {
          val (row, col) = queue.remove()

          for ((dr, dc) in directions) {
            val newRow = row + dr
            val newCol = col + dc

            if (newRow in 0 until rows && newCol in 0 until cols && grid[newRow][newCol] == '1') {
              queue.add(Pair(newRow, newCol))
              grid[newRow][newCol] = '0'
            }
          }
        }
      }
    }
  }

  return count
}