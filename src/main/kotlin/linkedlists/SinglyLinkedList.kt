package linkedlists

import linkedlists.SinglyNode as Node

class SinglyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    var size: Int = 0

    fun isEmpty(): Boolean = size == 0

    override fun toString(): String =
        if (isEmpty()) "Empty list" else head.toString()
}