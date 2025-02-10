package algorithms.linkedlist

fun removeDuplicates(head: ListNode?): ListNode? {
  var current = head

  while (current?.next != null) {
    if (current.`val` == current.next?.`val`) {
      current.next = current.next?.next // Skip duplicate node
    } else {
      current = current.next // Move to next unique node
    }
  }

  return head
}

fun createDuplicateLinkedList(values: List<Int>): ListNode? {
  if (values.isEmpty()) return null

  val head = ListNode(values[0])
  var current = head

  for (i in 1 until values.size) {
    current.next = ListNode(values[i])
    current = current.next!!
  }

  return head
}

fun printNodes(head: ListNode?) {
  var current = head

  while (current != null) {
    print("${current.`val`} -> ")
    current = current.next
  }
  println("null")
}