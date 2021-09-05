package basic.queues

class ArrayQueue<T> : Queue<T> {

    private val storage = arrayListOf<T>()

    override val size: Int
        get() = storage.size

    override fun enqueue(element: T): Boolean {
        storage.add(element = element)
        return true
    }

    override fun dequeue(): T? = storage.removeFirstOrNull()

    override fun peek(): T? = storage.firstOrNull()

    override fun toString(): String =
        if (isEmpty()) "Empty queue"
        else storage.joinToString(separator = " , ")
}