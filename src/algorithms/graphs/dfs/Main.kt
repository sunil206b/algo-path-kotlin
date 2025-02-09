package algorithms.graphs.dfs

fun main() {
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

  dfsRecursive(graph)
  println()
  dfsIterative(graph)
  println()

  println("Path exists from 'A' to 'I' recursive: ${findPathRecursive(graph, "A", "I")}")
  println("Path exists from 'A' to 'K' recursive: ${findPathRecursive(graph, "A", "K")}")
  println("Path exists from 'A' to 'I' iterative: ${findPathIteratively(graph, "A", "I")}")
  println("Path exists from 'A' to 'K' iterative: ${findPathIteratively(graph, "A", "K")}")

  println("================================================================")
  val dagWithCycle = mapOf(
    1 to listOf(2),
    2 to listOf(3),
    3 to listOf(4),
    4 to listOf(2) // Cycle: 2 → 3 → 4 → 2
  )

  val dagGraph = mapOf(
    1 to listOf(2, 3),
    2 to listOf(4),
    3 to listOf(4),
    4 to listOf()
  )
  println("Does DAG has cycle recursive: ${hasCycleRecursive(dagWithCycle)}")
  println("Does DAG has cycle recursive: ${hasCycleRecursive(dagGraph)}")

  // Example graph with a cycle: 0 - 1 - 2 - 0
  val undirectedGraphWithCycle = mapOf<Int, List<Int>>(
    0 to listOf(1, 2),
    1 to listOf(0, 2),
    2 to listOf(0, 1),
  )

  // Example graph with a cycle: 0 - 1 - 2 - 0
  val undirectedGraphWithoutCycle = mapOf<Int, List<Int>>(
    0 to listOf(1),
    1 to listOf(0, 2),
    2 to listOf(1),
  )
  println("Does undirected graph has cycle recursive: ${hasCycleInUnDirected(undirectedGraphWithCycle)}")
  println("Does undirected graph has cycle recursive: ${hasCycleInUnDirected(undirectedGraphWithoutCycle)}")

  println("================================================================")
  val prerequisites1 = arrayOf(
    intArrayOf(1, 0),
    intArrayOf(2, 1),
    intArrayOf(3, 2),
    intArrayOf(4, 2),
    intArrayOf(5, 4),
    intArrayOf(6, 4),
    intArrayOf(7, 5),
    intArrayOf(8, 6),
    intArrayOf(9, 7),
    intArrayOf(10, 8)
  )
  val prerequisites2 = arrayOf(
    intArrayOf(1, 0),
    intArrayOf(2, 1),
    intArrayOf(3, 2),
    intArrayOf(4, 3),
    intArrayOf(5, 4),
    intArrayOf(6, 5),
    intArrayOf(7, 6),
    intArrayOf(8, 7),
    intArrayOf(9, 8),
    intArrayOf(10, 9),
    intArrayOf(3, 10) // Cycle: 3 → 4 → 5 → ... → 10 → 3
  )
  println("Can finish courses: ${canFinish(prerequisites1, 11)}")
  println("Can finish courses: ${canFinish(prerequisites2, 11)}")

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
  println("Number of Islands: ${numberOfIslands(grid1)}")
  println("Number of Islands: ${numberOfIslands(grid2)}")
}