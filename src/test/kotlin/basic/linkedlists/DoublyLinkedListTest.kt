package basic.linkedlists

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DoublyLinkedListTest {

    @Test
    fun isEmpty() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
    }

    @Test
    fun testToString() {
        val list = DoublyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
    }
}