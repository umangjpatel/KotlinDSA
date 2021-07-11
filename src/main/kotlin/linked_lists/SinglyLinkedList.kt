package linked_lists

import linked_lists.SinglyNode as Node

class SinglyLinkedList<T>: MutableCollection<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size: Int = 0

    /**
     * Checks if the linked list is empty
     * Time complexity: O(1)
     */
    override fun isEmpty(): Boolean = size == 0


    /**
     * Represents the linked list in a string.
     * Time complexity: O(n)
     */
    override fun toString(): String =
        if (isEmpty()) "Empty list"
        else head.toString()

    /**
     * Adds a node at the head of the linked list.
     * Time complexity: O(1)
     */
    fun push(value: T): SinglyLinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null)
            tail = head
        size++
        return this
    }

    /**
     * Appends a node at the end of the list.
     * Time complexity: O(1)
     */
    fun append(value: T): SinglyLinkedList<T> {
        if (tail == null)
            return push(value = value)
        tail?.next = Node(value = value, next = null)
        tail = tail?.next
        size++
        return this
    }

    /**
     * Finds a node at a particular index
     * @index: Index for the requested node.
     * @return: Node at the particular index
     */
    fun nodeAt(index: Int): Node<T>? {
        if (index < 0)
            return null
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    /**
     * Inserts a node after a certain node at given index
     * Time complexity: O(i) where i is the index provided
     */
    fun insertAfter(index: Int, value: T): SinglyLinkedList<T> {
        val afterNode = nodeAt(index = index)
        if (tail == afterNode)
            return append(value = value)
        afterNode?.next = Node(value = value, next = afterNode?.next)
        size++
        return this
    }

    /**
     * Removes a node from the head of the linked list.
     * Also returns the value from that node.
     * Time complexity: O(1)
     */
    fun pop(): T? {
        if (!isEmpty())
            size--
        val result = head?.value
        head = head?.next
        if (isEmpty())
            tail = null
        return result
    }

    /**
     * Removes a node from the tail of the linked list.
     * Also returns the value from that node.
     * Time complexity: O(1)
     */
    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null)
            return pop()
        size--
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

    /**
     * Removes a node at a particular index.
     * Also returns the value from that node.
     * Time complexity: O(i) where i is the index of the requested node.
     */
    fun removeAt(index: Int): T? {
        if (index < 0 || index >= size)
            return null
        else if (index == 0)
            return pop()
        val beforeNode = nodeAt(index = index - 1)
        if (tail == beforeNode?.next)
            return removeLast()
        val result = beforeNode?.next?.value
        beforeNode?.next = beforeNode?.next?.next
        size--
        return result
    }

    /**
     * Checks if an element is in the linked list.
     * Time complexity: O(n)
     */
    override fun contains(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext())
            if (iterator.next() == element)
                return true
        return false
    }

    /**
     * Checks if all the elements are in the linked list.
     * Time complexity: O(n^2)
     */
    override fun containsAll(elements: Collection<T>): Boolean =
        elements.parallelStream()
            .allMatch { item -> contains(element = item) }

    /**
     * Adds an element to the linked list.
     * Similar to append() method.
     * Time complexity: O(1)
     */
    override fun add(element: T): Boolean = this.run {
        append(value = element)
        return true
    }

    /**
     * Adds all the elements to the linked list.
     * Time complexity: O(n)
     */
    override fun addAll(elements: Collection<T>): Boolean {
        elements.forEach { element -> add(element) }
        return true
    }


    /**
     * Deletes all the nodes from the linked list.
     * Time complexity: O(1)
     */
    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    /**
     * Removes an element from the linked list.
     * Time complexity: O(n)
     */
    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    /**
     * Removes the elements from the linked list.
     * Time complexity: O(n^2)
     */
    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        elements.forEach { element -> result = remove(element) || result }
        return result
    }

    /**
     * Removes all the elements which are not in the linked list.
     * Time complexity: O(m^n)
     */
    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = iterator()
        while (iterator.hasNext()) {
            if (!elements.contains(iterator.next())) {
                iterator.remove()
                result = true
            }
        }
        return result
    }

    override fun iterator(): MutableIterator<T> =
        SinglyLinkedListIterator(this)

    /**
     * MutableIterator class for the linked list
     */
    class SinglyLinkedListIterator<T>(private val list: SinglyLinkedList<T>): MutableIterator<T> {

        private var lastNode: Node<T>? = null
        private var index: Int = 0

        /**
         * Checks if there's any element remaining in the list to traverse
         * Time complexity: O(1)
         */
        override fun hasNext(): Boolean = index < list.size

        /**
         * Fetches the next node of the linked list.
         * Time complexity: O(1)
         */
        override fun next(): T {
            if (index >= list.size)
                throw IndexOutOfBoundsException()
            lastNode = if (index == 0) list.nodeAt(index = 0) else lastNode?.next
            index++
            return lastNode!!.value
        }

        /**
         * Removes the current node of the linked list.
         * Time complexity: O(i) where i is the index of the current node.
         */
        override fun remove() {
            if (index == 1)
                list.pop()
            else {
                list.removeAt(index = index - 1)
                lastNode = list.nodeAt(index = index - 2)
            }
            index--
        }

    }

}