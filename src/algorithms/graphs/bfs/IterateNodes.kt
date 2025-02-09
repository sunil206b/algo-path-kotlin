package algorithms.graphs.bfs

import java.util.*

fun iterateNodes(graph: Map<String, List<String>>) {
  val visited = mutableSetOf<String>()
  val queue: Queue<String> = LinkedList()

  for (node in graph.keys) {
    if (node in visited) continue
    queue.add(node)
    visited.add(node)

    while (queue.isNotEmpty()) {
      val current = queue.remove()
      print("$current ")

      for (neighbor in graph[current] ?: emptyList()) {
        if (neighbor !in visited) {
          queue.add(neighbor)
          visited.add(neighbor)
        }
      }
    }
  }
}