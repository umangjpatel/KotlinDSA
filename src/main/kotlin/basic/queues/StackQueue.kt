package basic.queues

import basic.stack.StackImpl

class StackQueue<T>: Queue<T> {

    private val leftStack = StackImpl<T>()
    private val rightStack = StackImpl<T>()

    override val size: Int
        get() = leftStack.size + rightStack.size

    override fun isEmpty(): Boolean = leftStack.isEmpty() && rightStack.isEmpty()

    override fun enqueue(element: T): Boolean {
        rightStack.push(value = element)
        return true
    }

    private fun transferElements() {
        var nextItem = rightStack.pop()
        while (nextItem != null) {
            leftStack.push(value = nextItem)
            nextItem = rightStack.pop()
        }
    }

    override fun dequeue(): T? {
        if (!rightStack.isEmpty()) transferElements()
        return leftStack.pop()
    }

    override fun peek(): T? {
        if (!rightStack.isEmpty()) transferElements()
        return leftStack.peek()
    }

    override fun toString(): String {
        if (leftStack.isEmpty() && rightStack.isEmpty()) return "Empty queue"
        val left = if (leftStack.isEmpty()) "" else leftStack.toString()
            .replace("----top----", "")
            .replace("-----------", "")
            .trim()
            .split("\n")
            .joinToString(separator = " , ")
        val right = if (rightStack.isEmpty()) "" else rightStack.toString()
            .replace("----top----", "")
            .replace("-----------", "")
            .trim()
            .split("\n")
            .asReversed()
            .joinToString(separator = " , ")
        return left + right
    }

}