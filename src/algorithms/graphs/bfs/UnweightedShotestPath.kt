package algorithms.graphs.bfs

import java.util.*

fun bfsUnweightedShortestPath(graph: Map<String, List<String>>, start: String, target: String): List<String> {
  if (start == target) return listOf(start) // If start == target, return the node itself

  val queue: Queue<String> = LinkedList()
  val parent = mutableMapOf<String, String?>() // To track the path
  val visited = mutableSetOf<String>()

  queue.add(start)
  visited.add(start)
  parent[start] = null // Root node has no parent

  while (queue.isNotEmpty()) {
    val current = queue.remove()

    for (neighbor in graph[current] ?: emptyList()) {
      if (neighbor !in visited) {
        queue.add(neighbor)
        visited.add(neighbor)
        parent[neighbor] = current // Store the parent of this node

        if (neighbor == target) {
          return reconstructPath(parent, target)
        }
      }
    }
  }

  return emptyList() // No path
}

fun reconstructPath(parent: MutableMap<String, String?>, target: String): List<String> {
  val path = mutableListOf<String>()
  var node: String? = target

  while (node != null) {
    path.add(node)
    node = parent[node]
  }

  return path.reversed() // Reverse to get correct order from start to target
}
