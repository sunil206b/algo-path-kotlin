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

fun bfsUnweightedShortestDistance(graph: Map<String, List<String>>, start: String, target: String): Int {
  if (start == target) return 0 // If start == target, distance is 0

  val queue: Queue<Pair<String, Int>> = LinkedList()
  val visited = mutableSetOf<String>()
  queue.add(Pair(start, 0)) // Start node with distance 0
  visited.add(start)

  while (queue.isNotEmpty()) {
    val (current, distance) = queue.remove()

    for (neighbor in graph[current] ?: emptyList()) {
      if (neighbor == target) return distance + 1 // Found the shortest path

      if (neighbor !in visited) {
        queue.add(Pair(neighbor, distance + 1))
        visited.add(neighbor) // Mark visited when enqueuing
      }
    }
  }

  return -1
}