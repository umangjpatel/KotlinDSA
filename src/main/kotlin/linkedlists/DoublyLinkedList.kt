@file:Suppress("DuplicatedCode")

package linkedlists

import linkedlists.DoublyNode as Node

class DoublyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    var size: Int = 0

    fun isEmpty(): Boolean = size == 0

    override fun toString(): String =
        if (isEmpty()) "Empty list"
        else head.toString()

    fun push(value: T): DoublyLinkedList<T> {
        head = Node(value = value, next = head)
        head?.next?.prev = head
        if (isEmpty())
            tail = head
        size++
        return this
    }

    fun append(value: T): DoublyLinkedList<T> {
        if (isEmpty())
            return push(value = value)
        tail?.next = Node(value = value, prev = tail)
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

    fun insertAfter(index: Int, value: T): DoublyLinkedList<T> {
        val afterNode = nodeAt(index = index) ?: return this
        val node = Node(value = value, prev = afterNode, next = afterNode.next)
        if (tail == afterNode)
            tail = node
        afterNode.next?.prev = node
        afterNode.next = node
        size++
        return this
    }
}