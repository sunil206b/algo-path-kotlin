package algorithms.graphs.dfs

import java.util.*

fun findPathRecursive(graph: Map<String, List<String>>, start: String, target: String): Boolean {
  val visited = mutableSetOf<String>()

  fun dfs(node: String): Boolean {
    if (node == target) return true

    if (node !in visited) {
      visited.add(node)

      graph[node]?.forEach { neighbor ->
        if (dfs(neighbor)) return true
      }
    }
    return false
  }

  return dfs(start)
}

fun findPathIteratively(graph: Map<String, List<String>>, start: String, target: String): Boolean {
  val visited = mutableSetOf<String>()
  val stack = ArrayDeque<String>()

  stack.push(start)

  while (stack.isNotEmpty()) {
    val current = stack.pop()
    if (current == target) return true
    if (current in visited) continue

    visited.add(current)

    graph[current]?.forEach { neighbor ->
      stack.push(neighbor)
    }
  }

  return false
}