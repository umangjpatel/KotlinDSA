package linked_lists

import linked_lists.DoublyNode as Node

class DoublyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    /**
     * Checks if the linked list is empty or not.
     * Time complexity: O(1)
     */
    fun isEmpty(): Boolean = size == 0

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
        if (tail == null)
            return push(value = value)
        tail?.next = Node(value = value, prev = tail)
        tail = tail?.next
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
}