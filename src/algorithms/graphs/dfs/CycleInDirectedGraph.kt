package algorithms.graphs.dfs

fun hasCycleRecursive(graph: Map<Int, List<Int>>): Boolean {
  val visited = mutableMapOf<Int, Int>()

  fun dfs(node: Int): Boolean {
    if (visited[node] == 1) return true
    if (visited[node] == 2) return false

    visited[node] = 1

    for (neighbor in graph[node] ?: emptyList()) {
      if (dfs(neighbor)) return true
    }

    visited[node] = 2
    return false
  }

  for (node in graph.keys) {
    if ((visited[node] ?: 0) == 0) {
      if (dfs(node)) return true
    }
  }

  return false
}
