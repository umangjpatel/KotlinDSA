package queues

class ArrayQueue<T>: Queue<T> {

    private val storage = mutableListOf<T>()

    override val count: Int
        get() = storage.size

    override fun enqueue(element: T) {
        storage.add(element = element)
    }

    override fun dequeue(): T? = storage.removeFirstOrNull()

    override fun first(): T? = storage.firstOrNull()

    override fun toString(): String =
        if (isEmpty()) "Empty queue"
        else storage.joinToString(separator = ", ")
}