package queues

import stack.Stack

class StackQueue<T> : Queue<T> {

    private val leftStack = Stack<T>()
    private val rightStack = Stack<T>()

    override val count: Int
        get() = leftStack.count + rightStack.count

    override fun isEmpty(): Boolean {
        return leftStack.isEmpty() && rightStack.isEmpty()
    }

    override fun enqueue(element: T) {
        rightStack.push(element = element)
    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty())
            transferElements()
        return leftStack.pop()
    }

    override fun first(): T? {
        if (leftStack.isEmpty())
            transferElements()
        return leftStack.peek()
    }

    private fun transferElements() {
        var element = rightStack.pop()
        while (element != null) {
            leftStack.push(element = element)
            element = rightStack.pop()
        }
    }

    override fun toString(): String {
        if (isEmpty()) return "Empty queue"
        val leftStackString =
            if (leftStack.isEmpty()) ""
            else leftStack.toString()
                .replace("----top----\n", "")
                .replace("-----------\n", "")
                .replace("\n", ",")
        val rightStackString =
            if (rightStack.isEmpty()) {
                leftStackString.dropLast(1)
                ""
            } else rightStack.toString()
                .replace("----top----\n", "")
                .replace("-----------\n", "")
                .replace("\n", ",")
                .dropLast(1)
                .reversed()
        val finalString = leftStackString + rightStackString
        return if (finalString.last() == ',')
            finalString.dropLast(1)
        else
            finalString
    }
}