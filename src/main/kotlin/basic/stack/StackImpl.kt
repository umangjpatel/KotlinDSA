package basic.stack

class StackImpl<T>: Stack<T> {

    private val storage = mutableListOf<T>()

    override val size: Int
        get() = storage.size

    override fun push(value: T) {
        storage.add(element = value)
    }

    override fun pop(): T? = storage.removeLastOrNull()

    override fun peek(): T? = storage.lastOrNull()

    override fun toString(): String =
        if (isEmpty()) "Empty stack"
        else buildString {
            appendLine("----top----")
            storage.asReversed().forEach { appendLine(it) }
            appendLine("-----------")
        }

}