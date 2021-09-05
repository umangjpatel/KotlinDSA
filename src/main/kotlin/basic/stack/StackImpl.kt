package basic.stack

import basic.linkedlists.SinglyLinkedList

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

    companion object {
        fun <T> create(items: Iterable<T>): StackImpl<T> =
            StackImpl<T>().apply { items.forEach { this.push(value = it) } }

        fun <T> stackOf(vararg items: T): StackImpl<T> =
            create(items.asList())

    }

    object Challenges {
        fun <T> printInReverse(list: SinglyLinkedList<T>): String {
            val stack = StackImpl<T>()
            list.forEach { stack.push(value = it) }
            var result = ""
            while (!stack.isEmpty()) {
                result += "${stack.pop()}"
                result += if (!stack.isEmpty()) " -> " else ""
            }
            return result
        }

        fun validateParentheses(input: String): Boolean {
            var result = false
            val stack = StackImpl<Char>()
            for (c in input)
                if (c == ')' && stack.isEmpty())
                    return false
                else if (c == ')' && stack.peek() == '(') {
                    stack.pop()
                    result = true
                } else if (c == '(') {
                    stack.push(value = c)
                    result = false
                }
            return result
        }
    }



}