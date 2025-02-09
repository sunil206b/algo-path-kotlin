package algorithms.graphs.bfs

import java.util.*

fun hasPath(graph: Map<String, List<String>>, src: String, target: String): Boolean {
  val visited = mutableSetOf<String>()
  val queue: Queue<String> = LinkedList()
  queue.add(src)
  visited.add(src)

  while (queue.isNotEmpty()) {
    val current = queue.remove()

    if (current == target) return true

    for (neighbor in graph[current] ?: emptyList()) {
      if (neighbor !in visited) {
        queue.add(neighbor)
        visited.add(neighbor)
      }
    }
  }

  return false
}