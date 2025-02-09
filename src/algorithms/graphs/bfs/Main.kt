package algorithms.graphs.bfs

fun main() {
//    A
//   / \
//   B   G
//  /|\    \
// C D E    H
//    |  \   / \
//    H   F  I   D
//
//  (K is an isolated node)
  val graph = mapOf(
    "A" to listOf("B", "G"),
    "B" to listOf("C", "D", "E"),
    "C" to listOf<String>(),
    "D" to listOf("H"),
    "E" to listOf("F"),
    "F" to listOf<String>(),
    "G" to listOf("H"),
    "H" to listOf("I", "D"),
    "I" to listOf<String>(),
    "K" to listOf<String>(),
  )
  iterateNodes(graph)
  println()

  println("Path exists from 'A' to 'I': ${hasPath(graph, "A", "I")}")
  println("Path exists from 'A' to 'K': ${hasPath(graph, "A", "K")}")

  println("================================================================")
  val grid1: Array<CharArray> = arrayOf(
    charArrayOf('1', '1', '1', '1', '0'),
    charArrayOf('1', '1', '0', '1', '0'),
    charArrayOf('1', '1', '0', '0', '0'),
    charArrayOf('0', '0', '0', '0', '0'),
  )

  val grid2: Array<CharArray> = arrayOf(
    charArrayOf('1', '1', '0', '0', '0'),
    charArrayOf('1', '1', '0', '0', '0'),
    charArrayOf('0', '0', '1', '0', '0'),
    charArrayOf('0', '0', '0', '1', '1'),
  )
  println("Number of Islands: ${algorithms.graphs.dfs.numberOfIslands(grid1)}")
  println("Number of Islands: ${algorithms.graphs.dfs.numberOfIslands(grid2)}")

  println("================================================================")
  val unweightedGraph = mapOf(
    "A" to listOf("B", "C"),
    "B" to listOf("A", "D", "E"),
    "C" to listOf("A", "F"),
    "D" to listOf("B"),
    "E" to listOf("B", "F"),
    "F" to listOf("C", "E")
  )

  println(bfsUnweightedShortestPath(unweightedGraph, "A", "F")) // Output: [A, C, F]
  println(bfsUnweightedShortestPath(unweightedGraph, "A", "D")) // Output: [A, B, D]
  println(bfsUnweightedShortestPath(unweightedGraph, "B", "F")) // Output: [B, E, F]
  println(bfsUnweightedShortestPath(unweightedGraph, "A", "G")) // Output: [] (No path found)
}