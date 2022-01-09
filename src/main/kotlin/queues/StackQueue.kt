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
        // 1, 2, 3, 4
        // enqueue all in right
        // first then move elements from right to left
        // left will look like : 4 -> 3 -> 2 -> 1 (bottom to top order)
        // right will be empty
        // consider more enqueue ops
        // left :4 -> 3 -> 2 -> 1 and right : 5 -> 6
        // correct order should be : 1, 2, 3, 4, 5, 6
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