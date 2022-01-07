package queues

import linkedlists.DoublyLinkedList

class LinkedQueue<T> : Queue<T> {

    private val storage = DoublyLinkedList<T>()

    override val count: Int
        get() = storage.size

    override fun enqueue(element: T) {
        storage.append(value = element)
    }

    override fun dequeue(): T? = storage.pop()

    override fun first(): T? = storage.nodeAt(index = 0)?.value

    override fun toString(): String =
        if (isEmpty()) "Empty queue"
        else storage.toString().replace(" <->", ",")
}