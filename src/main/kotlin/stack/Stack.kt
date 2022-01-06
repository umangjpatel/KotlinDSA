package stack

private interface StackInterface<E> {
    val count: Int
    fun isEmpty(): Boolean = count == 0
    fun push(element: E)
    fun pop(): E?
    fun peek(): E?
}

class Stack<T> : StackInterface<T> {

    private val storage = mutableListOf<T>()

    override val count: Int
        get() = storage.size

    override fun push(element: T) {
        storage.add(element = element)
    }

    override fun pop(): T? = storage.removeLastOrNull()

    override fun peek(): T? = storage.lastOrNull()

}