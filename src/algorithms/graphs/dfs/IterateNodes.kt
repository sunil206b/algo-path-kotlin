package algorithms.graphs.dfs

import java.util.*

fun dfsRecursive(graph: Map<String, List<String>>) {
  val visited = mutableMapOf<String, Boolean>()

  fun dfs(node: String) {
    if (visited[node] == true) return

    print("$node ")
    visited[node] = true

    graph[node]?.forEach { neighbor ->
      dfs(neighbor)
    }
  }

  graph.keys.forEach { node ->
    dfs(node)
  }
}

fun dfsIterative(graph: Map<String, List<String>>) {
  val visited = mutableMapOf<String, Boolean>()
  val stack = ArrayDeque<String>()

  for (node in graph.keys) {
    stack.push(node)

    while (stack.isNotEmpty()) {
      val current = stack.pop()
      if (visited[current] == true) continue

      print("$current ")
      visited[current] = true
      graph[current]?.forEach { neighbor ->
        stack.push(neighbor)
      }
    }
  }
}