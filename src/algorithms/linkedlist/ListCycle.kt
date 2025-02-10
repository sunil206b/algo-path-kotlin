package algorithms.linkedlist

class ListNode(val `var`: Int) {
  var next: ListNode? = null
}

fun hasCycle(head: ListNode?): Boolean {
  var slow = head
  var fast = head

  while (fast?.next != null) {
    slow = slow?.next // Move slow one step
    fast = fast.next?.next // Move fast two steps

    if (slow == fast) return true // Cycle detected
  }

  return false // No cycle
}

fun createLinkedListWithCycle(values: List<Int>, cycleIndex: Int): ListNode? {
  if (values.isEmpty()) return null

  val nodes = values.map { ListNode(it) }

  for (i in 0 until nodes.lastIndex) {
    nodes[i].next = nodes[i + 1]
  }

  if (cycleIndex != -1) {
    nodes.last().next = nodes[cycleIndex] // Create cycle
  }

  return nodes.first()
}