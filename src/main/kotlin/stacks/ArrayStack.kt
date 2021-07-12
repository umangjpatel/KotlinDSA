package stacks

class ArrayStack<T>: Stack<T> {

    private val storage = mutableListOf<T>()

    /**
     * Gets the size of the stack
     */
    override val size: Int
        get() = storage.size

    /**
     * Inserts an element at the top of the stack
     */
    override fun push(value: T) {
        storage.add(element = value)
    }

    /**
     * Removes an element from the top of the stack.
     * Also returns the top element of the stack if any.
     */
    override fun pop(): T? =
        storage.removeLastOrNull()

    /**
     * Returns the element from the top of the stack if any.
     * Does not remove from the top of the stack.
     */
    override fun peek(): T? =
        storage.lastOrNull()

    /**
     * String representation of the stack
     */
    override fun toString(): String =
        if (isEmpty) "Empty stack"
        else buildString {
            appendLine("----top----")
            storage.asReversed().forEach { item -> appendLine("$item") }
            appendLine("-----------")
        }

    companion object {
        /**
         * Creates a stack from the list of elements
         */
        fun <T> create(elements: Iterable<T>): Stack<T> {
            val stack = ArrayStack<T>()
            elements.forEach { item -> stack.push(value = item) }
            return stack
        }
    }
}

/**
 * Helper function to directly create a stack with the elements as its arguments.
 */
fun <T> stackOf(vararg elements: T): Stack<T> = ArrayStack.create(elements.asList())