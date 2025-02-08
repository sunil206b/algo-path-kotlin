package algorithms.graphs.dfs

import java.util.*

fun findPathRecursive(graph: Map<String, List<String>>, start: String, target: String): Boolean {
  val visited = mutableMapOf<String, Boolean>()

  fun dfs(node: String): Boolean {
    if (node == target) return true

    if (visited[node] != true) {
      visited[node] = true

      graph[node]?.forEach { neighbor ->
        if (dfs(neighbor)) return true
      }
    }
    return false
  }

  return dfs(start)
}

fun findPathIteratively(graph: Map<String, List<String>>, start: String, target: String): Boolean {
  val visited = mutableMapOf<String, Boolean>()
  val stack = ArrayDeque<String>()

  stack.push(start)

  while (stack.isNotEmpty()) {
    val current = stack.pop()
    if (current == target) return true
    if (visited[current] == true) continue

    visited[current] = true

    graph[current]?.forEach { neighbor ->
      stack.push(neighbor)
    }
  }

  return false
}