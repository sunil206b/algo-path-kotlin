package algorithms.linkedlist

fun main() {
  val head1 = createLinkedListWithCycle(listOf(3, 2, 0, -4), 1) // Cycle exists
  println("Test 1: ${hasCycle(head1)}")

  val head2 = createLinkedListWithCycle(listOf(1, 2), 0) // Cycle exists
  println("Test 2: ${hasCycle(head2)}")

  val head3 = createLinkedListWithCycle(listOf(1), -1) // No cycle
  println("Test 3: ${hasCycle(head3)}")
}