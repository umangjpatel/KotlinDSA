package basic.linkedlists

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    fun isEmpty(): Boolean = size == 0

    override fun toString(): String =
        if (isEmpty()) "Empty list"
        else head.toString()

    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null)
            tail = head
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
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

    fun insertAfter(index: Int, value: T): LinkedList<T> {
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

}