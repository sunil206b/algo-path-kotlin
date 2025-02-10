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

fun deleteDuplicates(head: ListNode?): ListNode? {
  val dummy = ListNode(0) // Dummy node before head
  dummy.next = head

  var current = head
  var prev = dummy // Pointer to track unique values
  while (current != null) {
    var hasDuplicates = false

    // Skip all duplicate values
    while (current?.next != null && current.`val` == current.next?.`val`) {
      current = current.next
      hasDuplicates = true
    }

    if (hasDuplicates) {
      prev.next = current?.next // Remove all duplicates
    } else {
      prev = prev.next!! // Move prev forward if no duplicates
    }
    current = current?.next // Move to next node
  }

  return dummy.next // New head of unique values
}