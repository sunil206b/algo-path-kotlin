package algorithms.graphs.dfs

fun canFinish(prerequisites: Array<IntArray>, numberOfCourses: Int): Boolean {
  val graph = mutableMapOf<Int, MutableList<Int>>()
  for ((course, prerequisite) in prerequisites) {
    graph.computeIfAbsent(prerequisite) { mutableListOf() }.add(course)
  }

  val visited = mutableMapOf<Int, Int>()

  fun dfs(course: Int): Boolean {
    if (visited[course] == 1) return true
    if (visited[course] == 2) return false

    visited[course] = 1

    for (neighbor in graph[course] ?: emptyList()) {
      if (dfs(neighbor)) return true
    }

    visited[course] = 2
    return false
  }

  for (course in 0 until numberOfCourses) {
    if ((visited[course] ?: 0) == 0 && dfs(course)) return false
  }
  return true
}