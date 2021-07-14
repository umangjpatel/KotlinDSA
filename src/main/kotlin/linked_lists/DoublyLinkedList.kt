package linked_lists

import linked_lists.DoublyNode as Node

class DoublyLinkedList<T> : MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size: Int = 0

    /**
     * Checks if the linked list is empty or not.
     * Time complexity: O(1)
     */
    override fun isEmpty(): Boolean = size == 0

    /**
     * Represents the linked list in a string format
     */
    override fun toString(): String =
        if (isEmpty()) "Empty list"
        else head.toString()

    /**
     * Inserts a node at the head of the linked list.
     * Time complexity: O(1)
     */
    fun push(value: T): DoublyLinkedList<T> {
        val newNode = Node(value = value, next = head)
        head?.prev = newNode
        head = newNode
        if (tail == null)
            tail = head
        size++
        return this
    }

    /**
     * Inserts a node at the tail of the linked list.
     * Time complexity: O(1)
     */
    fun append(value: T): DoublyLinkedList<T> {
        if (isEmpty())
            return push(value = value)
        val newNode = Node(value = value, prev = tail)
        tail?.next = newNode
        tail = newNode
        size++
        return this
    }

    /**
     * Finds a node at a particular index in the linked list.
     * Returns null if index less than 0 or is greater than or equal to the size of the linked list.
     * Time complexity: O(i) where i is the index you requested for.
     */
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

    /**
     * Inserts a node after a particular index in the linked list.
     * Time complexity:-
     *  - Searching the node at the index takes O(i) where i is the index you requested.
     *  - Inserting the node takes O(1) time.
     */
    fun insertAfter(index: Int, value: T): DoublyLinkedList<T> {
        val afterNode = nodeAt(index = index)
        if (tail == afterNode)
            return append(value = value)
        val newNode = Node(value = value, prev = afterNode, next = afterNode?.next)
        afterNode?.next?.prev = newNode
        afterNode?.next = newNode
        size++
        return this
    }

    /**
     * Deletes and returns the value at the head of the linked list.
     * Time complexity: O(1).
     */
    fun pop(): T? {
        if (!isEmpty()) size-- else return null
        val result = head?.value
        head = head?.next
        head?.prev = null
        if (isEmpty())
            tail = null
        return result
    }

    /**
     * Deletes and returns the value at the tail of the linked list.
     * Time complexity: O(1).
     */
    fun removeLast(): T? {
        if (head?.next == null)
            return pop()
        val result = tail?.value
        val prevNode = tail?.prev
        tail?.prev = null
        prevNode?.next = null
        tail = prevNode
        size--
        return result
    }

    /**
     * Removes an element from a particular index in the linked list.
     * Time complexity (Let i be the requested index):
     *      - If i == 0 or i == size - 1, O(1)
     *      - Else, O(i)
     */
    fun removeAt(index: Int): T? {
        if (index < 0 || index >= size) return null
        if (index == 0) return pop() else if (index == size - 1) return removeLast()
        val prevNode = nodeAt(index = index - 1)
        val result = prevNode?.next?.value
        prevNode?.next = prevNode?.next?.next
        prevNode?.next?.prev = prevNode
        size--
        return result
    }

    /**
     * Checks if there's a node in the linked list with the provided value.
     * Time complexity: O(n)
     */
    override fun contains(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element)
                return true
        }
        return false
    }

    /**
     * Checks if the linked list contains all the nodes provided.
     * Time complexity: O(n^2)
     */
    override fun containsAll(elements: Collection<T>): Boolean =
        elements.parallelStream()
            .allMatch { element -> contains(element = element) }

    /**
     * Adds an element in the linked list.
     * Time complexity: O(1)
     */
    override fun add(element: T): Boolean {
        append(value = element)
        return true
    }

    /**
     * Adds the elements in the linked list.
     * Time complexity: O(n) where n is the number of elements to be added.
     */
    override fun addAll(elements: Collection<T>): Boolean =
        elements.all { element -> add(element = element) }

    /**
     * Deletes all the nodes in the linked list.
     * Time complexity: O(1)
     */
    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    /**
     * Removes a specific element from the linked list.
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
     * Remove the particular elements from the linked list.
     * Return true if any requested element gets deleted, else return false.
     * Time complexity: O(m^n)
     *      where m is the number of elements to be deleted
     *      and n is the size of the linked list
     */
    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        elements.forEach { element -> result = remove(element) || result }
        return result
    }

    /**
     * Removes all the elements in the linked list not presented in the provided list.
     * Time complexity: O(m^n)
     *          where m is the number of elements provided
     *          and n is the size of the linked list
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

    override fun iterator(): MutableIterator<T> = DoublyLinkedListIterator(this)

    class DoublyLinkedListIterator<T>(private val list: DoublyLinkedList<T>) : MutableIterator<T> {

        private var lastNode: Node<T>? = null
        private var index: Int = 0

        /**
         * Check if there are any nodes remaining in the linked list.
         * Time complexity: O(1)
         */
        override fun hasNext(): Boolean = index < list.size


        /**
         * Return the value of the next node in the linked list.
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
         * Removes the current node in the linked list.
         * Time complexity: O(i) where i is the current index.
         */
        override fun remove() {
            if (index == 1) list.pop()
            else {
                list.removeAt(index = index - 1)
                lastNode = list.nodeAt(index = index - 2)
            }
            index--
        }

    }
}