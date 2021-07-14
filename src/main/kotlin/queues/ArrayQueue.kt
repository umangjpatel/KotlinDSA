package queues

class ArrayQueue<T>: Queue<T> {

    /**
     * Data structure to store the elements in the queue
     */
    private val storage: ArrayList<T> = arrayListOf()

    /**
     * Get the total number of elements present in the queue.
     * Time complexity: O(1)
     */
    override val count: Int
        get() = storage.size

    /**
     * Inserts an element at the end in the queue.
     * Time complexity: O(1) {amortized}
     */
    override fun enqueue(element: T): Boolean {
        storage.add(element = element)
        return true
    }

    /**
     * Deletes and returns the element at the beginning of the queue
     * Time complexity: O(n)
     */
    override fun dequeue(): T? =
        storage.removeFirstOrNull()

    /**
     * Returns the element at the beginning of the queue.
     * This method doesn't remove that element.
     * Time complexity: O(1)
     */
    override fun peek(): T? =
        storage.firstOrNull()

    /**
     * Represents the queue in a string format.
     * Time complexity: O(n)
     */
    override fun toString(): String =
        if (isEmpty) "Empty queue"
        else storage.joinToString(" , ")
}