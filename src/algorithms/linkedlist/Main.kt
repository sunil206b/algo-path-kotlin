package algorithms.linkedlist

fun main() {
  val head1 = createLinkedListWithCycle(listOf(3, 2, 0, -4), 1) // Cycle exists
  println("Test 1: ${hasCycle(head1)}")

  val head2 = createLinkedListWithCycle(listOf(1, 2), 0) // Cycle exists
  println("Test 2: ${hasCycle(head2)}")

  val head3 = createLinkedListWithCycle(listOf(1), -1) // No cycle
  println("Test 3: ${hasCycle(head3)}")

  println("Cycle starts at: ${findCycleNode(head1)?.`val`}")
  println("Cycle starts at: ${findCycleNode(head2)?.`val`}")
  println("Cycle starts at: ${findCycleNode(head3)?.`val` ?: "No Cycle"}")

  println("=============================Remove Duplicates=====================================")
  val duplicateHead1 = createDuplicateLinkedList(listOf(1, 1, 2))
  println("Original List:")
  printNodes(duplicateHead1)
  println("After Removing Duplicates:")
  printNodes(removeDuplicates(duplicateHead1))

  val duplicateHead2 = createDuplicateLinkedList(listOf(1, 2, 3, 3, 4, 4, 5))
  println("Original List:")
  printNodes(duplicateHead2)
  println("After Removing Duplicates:")
  printNodes(deleteDuplicates(duplicateHead2))
}