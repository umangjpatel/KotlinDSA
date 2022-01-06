package linkedlists

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SinglyLinkedListTest {

    @Test
    fun testToString() {
        val list = SinglyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
        list.push(1)
        assertEquals(list.toString(), "1")
        list.append(2)
        assertEquals(list.toString(), "1 -> 2")
        list.insertAfter(0, 3)
        assertEquals(list.toString(), "1 -> 3 -> 2")
    }

    @Test
    fun testIsEmpty() {
        val list = SinglyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.push(1)
        assertFalse(list.isEmpty())
        list.append(2)
        assertFalse(list.isEmpty())
        list.insertAfter(0, 3)
        assertFalse(list.isEmpty())
    }

    @Test
    fun testSize() {
        val list = SinglyLinkedList<Int>()
        assertEquals(list.size, 0)
        list.push(1)
        assertEquals(list.size, 1)
        list.append(2)
        assertEquals(list.size, 2)
        list.insertAfter(0, 3)
        assertEquals(list.size, 3)
    }

    @Test
    fun testPush() {
        val list = SinglyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.push(1)
        list.push(2)
        list.push(3)
        assertFalse(list.isEmpty())
        assertEquals(list.toString(), "3 -> 2 -> 1")
    }

    @Test
    fun testAppend() {
        val list = SinglyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.append(1)
        list.append(2)
        list.append(3)
        assertEquals(list.toString(), "1 -> 2 -> 3")
    }

    @Test
    fun testNodeAt() {
        val list = SinglyLinkedList<Int>()
        assertTrue(list.isEmpty())
        assertNull(list.nodeAt(0))
        assertNull(list.nodeAt(1))
        list.append(1).append(2).append(3)
        assertEquals(list.nodeAt(1).toString(), "2 -> 3")
        assertEquals(list.nodeAt(0).toString(), "1 -> 2 -> 3")
        assertEquals(list.nodeAt(2).toString(), "3")
        assertNull(list.nodeAt(-1))
        assertNull(list.nodeAt(3))
    }

    @Test
    fun testInsertAfter() {
        val list = SinglyLinkedList<Int>().apply {
            append(1)
            append(2)
            append(3)
        }
        assertEquals(list.toString(), "1 -> 2 -> 3")
        list.insertAfter(0, 4)
        assertEquals(list.toString(), "1 -> 4 -> 2 -> 3")
        list.insertAfter(3, 5)
        assertEquals(list.toString(), "1 -> 4 -> 2 -> 3 -> 5")
        list.append(6)
        assertEquals(list.toString(), "1 -> 4 -> 2 -> 3 -> 5 -> 6")
    }
}