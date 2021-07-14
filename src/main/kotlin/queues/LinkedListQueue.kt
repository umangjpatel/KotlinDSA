package queues

import linked_lists.DoublyLinkedList

class LinkedListQueue<T>: Queue<T> {

    /**
     * Data structure to store the elements in the queue
     */
    private val storage = DoublyLinkedList<T>()

    /**
     * Returns the number of elements in the queue.
     * Time complexity: O(1)
     */
    override val count: Int
        get() = storage.size

    /**
     * Inserts an element at the end of the queue.
     * Time complexity: O(1)
     */
    override fun enqueue(element: T): Boolean =
        storage.add(element = element)

    /**
     * Removes an element from the beginning of the queue.
     * Also returns that value.
     * Time complexity: O(1)
     */
    override fun dequeue(): T? =
        storage.pop()

    /**
     * Gets the element at the beginning of the queue.
     * This method doesn't dequeue it.
     * Time complexity: O(1)
     */
    override fun peek(): T? =
        storage.nodeAt(index = 0)?.value

    /**
     * Represents the queue in a string format.
     * Time complexity: O(n)
     */
    override fun toString(): String =
        if (isEmpty) "Empty queue"
        else storage.toString().replace("<->", ",")
}