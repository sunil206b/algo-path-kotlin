package algorithms.graphs.dfs

fun numberOfIslands(grid: Array<CharArray>): Int {
  if (grid.isEmpty()) return 0

  val rows = grid.size
  val cols = grid[0].size
  var count = 0

  fun dfs(row: Int, col: Int) {
    // Boundary check and water check
    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') return

    // Mark current land as visited (turn '1' to '0')
    grid[row][col] = '0'

    // Visit all 4 directions
    dfs(row + 1, col)
    dfs(row - 1, col)
    dfs(row, col + 1)
    dfs(row, col - 1)
  }

  for (row in 0 until rows) {
    for (col in 0 until cols) {
      if (grid[row][col] == '1') { // Found an unvisited island
        count++
        dfs(row, col) // Mark all connected land
      }
    }
  }

  return count
}