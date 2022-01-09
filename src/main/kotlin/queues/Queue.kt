package queues

interface Queue<E> {
    val count: Int
    fun isEmpty(): Boolean = count == 0
    fun enqueue(element: E)
    fun dequeue(): E?
    fun first(): E?
}