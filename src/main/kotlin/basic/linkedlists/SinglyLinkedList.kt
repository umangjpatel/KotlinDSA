package basic.linkedlists

import basic.linkedlists.SinglyNode as Node

class SinglyLinkedList<T> : MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size: Int = 0
        private set

    override fun isEmpty(): Boolean = size == 0

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
        if (index < 0 || index >= size) return null
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insertAfter(index: Int, value: T): SinglyLinkedList<T> {
        val afterNode = nodeAt(index = index) ?: return this
        afterNode.next = Node(value = value, next = afterNode.next)
        if (afterNode == tail) tail = afterNode.next
        size++
        return this
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()) tail = null
        return result
    }

    fun removeLast(): T? {
        val head = head ?: return null
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
        size--
        return current.value
    }

    fun removeAt(index: Int): T? {
        if (index == 0) return pop()
        val keyNode = nodeAt(index = index - 1) ?: return null
        val result = keyNode.next?.value
        if (tail == keyNode.next) tail = keyNode
        keyNode.next = keyNode.next?.next
        size--
        return result
    }

    override fun add(element: T): Boolean {
        this.append(value = element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean = elements.all { this.add(element = it) }

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

    override fun contains(element: T): Boolean = this.any { it == element }

    override fun containsAll(elements: Collection<T>): Boolean = elements.all { this.contains(it) }

    override fun iterator(): MutableIterator<T> = LinkedListIterator(this)

    class LinkedListIterator<T>(private val list: SinglyLinkedList<T>) : MutableIterator<T> {

        private var index: Int = 0
        private var lastNode: Node<T>? = null

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
                val prevNode = list.nodeAt(index = index - 2)
                list.removeAt(index = index - 1)
                lastNode = prevNode
            }
            index--
        }
    }

    fun printReverse(): String =
        if (isEmpty()) "Empty list"
        else printReverse(head)

    private fun printReverse(node: Node<T>?): String =
        if (node?.next == null) "${node?.value}"
        else "${printReverse(node.next)} -> ${node.value}"

    fun getMiddleNode(): Node<T>? {
        var (slow, fast) = head to head
        while (fast != null) {
            fast = fast.next
            if (fast != null) {
                fast = fast.next
                slow = slow?.next
            }
        }
        return slow
    }

    fun reverse(): SinglyLinkedList<T> {
        var node = nodeAt(index = 0)
        val list = SinglyLinkedList<T>()
        while (node != null) {
            list.push(value = node.value)
            node = node.next
        }
        return list
    }

}