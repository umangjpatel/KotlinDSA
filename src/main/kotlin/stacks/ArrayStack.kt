package stacks

class ArrayStack<T>: Stack<T> {

    private val storage = mutableListOf<T>()

    override val size: Int
        get() = storage.size

    override fun push(value: T) {
        storage.add(element = value)
    }

    override fun pop(): T? =
        storage.removeLastOrNull()

    override fun peek(): T? =
        storage.lastOrNull()

    override fun toString(): String =
        if (isEmpty) "Empty stack"
        else buildString {
            appendLine("----top----")
            storage.asReversed().forEach { item -> appendLine("$item") }
            appendLine("-----------")
        }

    companion object {
        fun <T> create(elements: Iterable<T>): Stack<T> {
            val stack = ArrayStack<T>()
            elements.forEach { item -> stack.push(value = item) }
            return stack
        }
    }
}

fun <T> stackOf(vararg elements: T): Stack<T> = ArrayStack.create(elements.asList())