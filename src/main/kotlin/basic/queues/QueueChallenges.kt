package basic.queues

import basic.stack.StackImpl

fun <T> Queue<T>.nextPlayer(): T? {
    val person = this.dequeue() ?: return null
    this.enqueue(person)
    return person
}

fun <T> Queue<T>.reverse(): Queue<T> {
    val stack = StackImpl<T>()
    var nextItem = this.dequeue()
    while (nextItem != null) {
        stack.push(value = nextItem)
        nextItem = this.dequeue()
    }
    nextItem = stack.pop()
    while (nextItem != null) {
        this.enqueue(nextItem)
        nextItem = stack.pop()
    }
    return this
}