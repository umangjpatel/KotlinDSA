package linked_lists

import linked_lists.SinglyNode as Node

class SinglyLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    /**
     * Checks if the linked list is empty
     * Time complexity: O(1)
     */
    fun isEmpty(): Boolean = size == 0


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
}