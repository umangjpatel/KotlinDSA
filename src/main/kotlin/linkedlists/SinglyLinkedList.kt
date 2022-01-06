package linkedlists

import linkedlists.SinglyNode as Node

class SinglyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    var size: Int = 0

    fun isEmpty(): Boolean = size == 0

    override fun toString(): String =
        if (isEmpty()) "Empty list" else head.toString()

    fun push(value: T): SinglyLinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null)
            tail = head
        size++
        return this
    }

    fun append(value: T): SinglyLinkedList<T> {
        if (isEmpty())
            return push(value = value)
        tail?.next = Node(value = value, next = null)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        if (index < 0 || index >= this.size)
            return null
        var current = head
        var currentIndex = 0
        while (current != null && currentIndex < index) {
            current = current.next
            currentIndex++
        }
        return current
    }

    fun insertAfter(index: Int, value: T): SinglyLinkedList<T> {
        val afterNode = nodeAt(index = index) ?: return this
        afterNode.next = Node(value = value, next = afterNode.next)
        if (afterNode == tail)
            tail = afterNode.next
        size++
        return this
    }
}