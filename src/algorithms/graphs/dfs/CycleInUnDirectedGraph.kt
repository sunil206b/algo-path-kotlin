package algorithms.graphs.dfs

fun hasCycleInUnDirected(graph: Map<Int, List<Int>>): Boolean {
  val visited = mutableSetOf<Int>()

  fun dfs(node: Int, parent: Int): Boolean {
    visited.add(node)

    for (neighbor in graph[node] ?: emptyList()) {
      if (neighbor == parent) continue

      if (neighbor in visited || dfs(neighbor, node)) return true
    }

    return false
  }

  for (node in graph.keys) {
    if (node !in visited) {
      if (dfs(node, -1)) return true
    }
  }
  
  return false
}