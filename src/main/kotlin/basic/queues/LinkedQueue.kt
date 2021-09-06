package basic.queues

import basic.linkedlists.DoublyLinkedList

class LinkedQueue<T>: Queue<T> {

    private val storage = DoublyLinkedList<T>()

    override val size: Int
        get() = storage.size

    override fun enqueue(element: T): Boolean {
        storage.append(value = element)
        return true
    }

    override fun dequeue(): T? = storage.pop()

    override fun peek(): T? = storage.nodeAt(index = 0)?.value

    override fun toString(): String =
        if (isEmpty()) "Empty queue"
        else storage.joinToString(separator = " , ")

}