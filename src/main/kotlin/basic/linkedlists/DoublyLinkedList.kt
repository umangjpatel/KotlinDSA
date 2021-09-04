package basic.linkedlists

import basic.linkedlists.DoublyNode as Node

class DoublyLinkedList<T> : MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override var size: Int = 0
        private set

    override fun isEmpty(): Boolean = size == 0

    override fun toString(): String =
        if (isEmpty()) "Empty list"
        else head.toString()

    fun push(value: T): DoublyLinkedList<T> {
        val newNode = Node(value = value, next = head)
        head?.prev = newNode
        head = newNode
        if (tail == null)
            tail = head
        size++
        return this
    }

    fun append(value: T): DoublyLinkedList<T> {
        if (isEmpty()) return push(value = value)
        tail?.next = Node(value = value, prev = tail)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        if (index < 0 || index >= size) return null
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insertAfter(index: Int, value: T): DoublyLinkedList<T> {
        val keyNode = nodeAt(index = index) ?: return this
        if (keyNode == tail) return append(value = value)
        val newNode = Node(value = value, prev = keyNode, next = keyNode.next)
        keyNode.next?.prev = newNode
        keyNode.next = newNode
        size++
        return this
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        head?.prev = null
        if (isEmpty()) tail = null
        return result
    }

    fun removeLast(): T? {
        val result = tail?.value
        tail = tail?.prev
        tail?.next = null
        size--
        return result
    }

    fun removeAt(index: Int): T? {
        if (index == 0) return pop()
        val keyNode = nodeAt(index = index) ?: return null
        val (prevNode, nextNode) = keyNode.prev to keyNode.next
        if (tail == keyNode) tail = prevNode
        prevNode?.next = nextNode
        nextNode?.prev = prevNode
        size--
        return keyNode.value
    }

    override fun iterator(): MutableIterator<T> = LinkedListIterator(this)

    class LinkedListIterator<T>(private val list: DoublyLinkedList<T>) : MutableIterator<T> {

        private var lastNode: Node<T>? = null
        private var index: Int = 0

        override fun hasNext(): Boolean = index < list.size

        override fun next(): T {
            if (index >= list.size) throw ArrayIndexOutOfBoundsException()
            lastNode = if (index == 0) list.nodeAt(index = 0) else lastNode?.next
            index++
            return lastNode!!.value
        }

        override fun remove() {
            if (index == 1) list.pop()
            else {
                val keyNode = list.nodeAt(index = index - 1)
                list.removeAt(index = index - 1)
                lastNode = keyNode?.prev
            }
            index--
        }
    }

    override fun contains(element: T): Boolean = this.any { it == element }

    override fun containsAll(elements: Collection<T>): Boolean = elements.all { this.contains(it) }

    override fun add(element: T): Boolean {
        append(value = element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean = elements.all { add(element = it) }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext())
            if (iterator.next() == element) {
                iterator.remove()
                return true
            }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements)
            result = remove(item) || result
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }


}