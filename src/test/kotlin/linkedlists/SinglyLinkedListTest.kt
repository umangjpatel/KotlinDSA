package linkedlists

import org.junit.jupiter.api.Assertions.*

internal class SinglyLinkedListTest {

    @org.junit.jupiter.api.Test
    fun testToString() {
        val list = SinglyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
    }

    @org.junit.jupiter.api.Test
    fun testIsEmpty() {
        val list = SinglyLinkedList<Int>()
        assertTrue(list.isEmpty())
    }
}