package basic.queues

interface Queue<T> {
    val size: Int
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    fun peek(): T?
    fun isEmpty(): Boolean = size == 0
}