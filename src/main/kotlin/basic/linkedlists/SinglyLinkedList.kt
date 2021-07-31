package basic.linkedlists

import basic.linkedlists.SinglyNode as Node

class SinglyLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    fun isEmpty(): Boolean = size == 0

    override fun toString(): String =
        if (isEmpty()) "Empty list"
        else head.toString()

    fun push(value: T): SinglyLinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null)
            tail = head
        size++
        return this
    }

    fun append(value: T): SinglyLinkedList<T> {
        if (isEmpty()) return push(value = value)
        tail?.next = Node(value = value)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        if (index < 0) return null
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insertAfter(index: Int, value: T): SinglyLinkedList<T> {
        val afterNode = nodeAt(index = index)
        if (tail == afterNode)
            return append(value = value)
        afterNode?.next = Node(value = value, next = afterNode?.next)
        size++
        return this
    }

    fun pop(): T? {
        if (!isEmpty())
            size--
        val result = head?.value
        head = head?.next
        if (isEmpty())
            tail = null
        return result
    }

    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null) return pop()
        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(index: Int): T? {
        val afterNode = nodeAt(index = index)
        val result = afterNode?.next?.value
        if (afterNode?.next == tail)
            tail = afterNode
        if (afterNode?.next != null)
            size--
        afterNode?.next = afterNode?.next?.next
        return result
    }




}