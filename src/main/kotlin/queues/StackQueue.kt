package queues

import stacks.ArrayStack
import stacks.Stack

class StackQueue<T>: Queue<T> {

    // Left stack to keep track of dequeued elements
    private val leftStack: Stack<T> = ArrayStack()

    // Right stack to keep track of enqueue elements
    private val rightStack: Stack<T> = ArrayStack()

    /**
     * Gets the number of elements in the queue.
     * Time complexity: O(1)
     */
    override val count: Int
        get() = rightStack.size

    /**
     * Checks if the queue is empty or not.
     * Time complexity: O(1)
     */
    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty

    /**
     * Pushes an element in the right stack of the queue.
     * Time complexity: O(1)
     */
    override fun enqueue(element: T): Boolean {
        rightStack.push(value = element)
        return true
    }

    /**
     * Pops an element from the left stack of the queue.
     * Time complexity: O(1)
     */
    override fun dequeue(): T? {
        if (leftStack.isEmpty)
            transferElements()
        return leftStack.pop()
    }

    /**
     * Gets the element on the top of the left stack of the queue.
     * Doesn't dequeue it from the queue.
     * Time complexity: O(1)
     */
    override fun peek(): T? {
        if (leftStack.isEmpty)
            transferElements()
        return leftStack.peek()
    }

    /**
     * Transfers the elements from the right stack to the left stack of the queue.
     * This method is called when dequeue() or peek() method called.
     */
    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(value = nextElement)
            nextElement = rightStack.pop()
        }
    }

    /**
     * Represents the queue in a string format
     */
    override fun toString(): String {
        if (isEmpty) return "Empty queue"
        val filter = setOf("----top----", "-----------", "\n", "", "Empty stack")
        val leftResult = leftStack.toString()
            .split("\n")
            .filter { word -> word !in filter }
            .joinToString(" , ")
        val rightResult = rightStack.toString()
            .split("\n")
            .filter { word -> word !in filter }
            .reversed()
            .joinToString(" , ")
        val spacing = if (leftResult.isEmpty() || rightResult.isEmpty()) "" else " , "
        return "$leftResult$spacing$rightResult"
    }
}