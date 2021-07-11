package linked_lists

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SinglyLinkedListTest {

    @Test
    fun isEmpty() {
        val list = SinglyLinkedList<Int>()
        assertTrue(list.isEmpty())
    }

    @Test
    fun testToString() {
        val list = SinglyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
    }

    @Test
    fun push() {
        val list = SinglyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.push(value = 3).push(value = 1).push(value = 2)
        assertEquals(list.toString(), "2 -> 1 -> 3")
    }

    @Test
    fun append() {
        val list = SinglyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.append(value = 1)
        assertEquals(list.toString(), "1")
        list.append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 -> 2 -> 3")
    }

    @Test
    fun nodeAt() {
        val list = SinglyLinkedList<Int>()
        assertNull(list.nodeAt(index = -1))
        assertNull(list.nodeAt(index = 2))
        assertNull(list.nodeAt(index = 0))
        list.push(value = 1)
        assertNull(list.nodeAt(index = -1))
        assertNull(list.nodeAt(index = 1))
        assertEquals(list.nodeAt(index=  0).toString(), "1")
        list.append(value = 2)
        assertEquals(list.nodeAt(index=  0).toString(), "1 -> 2")
    }

    @Test
    fun insertAfter() {
        val list = SinglyLinkedList<Int>()
        list.insertAfter(index = -1, value = 1)
        assertEquals(list.toString(), "1")
        list.insertAfter(index = 0, value = 2)
        assertEquals(list.toString(), "1 -> 2")
        list.insertAfter(index = 0, value = 3)
        assertEquals(list.toString(), "1 -> 3 -> 2")
    }

    @Test
    fun pop() {
        val list = SinglyLinkedList<Int>()
        assertNull(list.pop())
        list.append(value = 1)
        assertEquals(list.pop(), 1)
        assertTrue(list.isEmpty())
        assertEquals(list.toString(), "Empty list")
        list.append(value = 2).append(value = 3)
        assertEquals(list.pop(), 2)
        assertFalse(list.isEmpty())
        assertEquals(list.toString(), "3")
    }

    @Test
    fun removeLast() {
        val list = SinglyLinkedList<Int>()
        assertNull(list.removeLast())
        list.append(value = 1)
        assertEquals(list.removeLast(), 1)
        assertTrue(list.isEmpty())
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 -> 2 -> 3")
        assertFalse(list.isEmpty())
        assertEquals(list.removeLast(), 3)
        assertEquals(list.toString(), "1 -> 2")
        assertFalse(list.isEmpty())
        assertEquals(list.removeLast(), 2)
        assertEquals(list.toString(), "1")
        assertEquals(list.removeLast(), 1)
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
    }

    @Test
    fun removeAt() {
        val list = SinglyLinkedList<Int>()
        assertNull(list.removeAt(index = -1))
        assertNull(list.removeAt(index = 2))
        list.append(value = 1)
        assertNull(list.removeAt(index = -1))
        assertNull(list.removeAt(index = 1))
        assertEquals(list.removeAt(index = 0), 1)
        assertTrue(list.isEmpty())
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 -> 2 -> 3")
        assertEquals(list.removeAt(index = 1), 2)
        assertEquals(list.toString(), "1 -> 3")
        assertEquals(list.removeAt(index = 0), 1)
        assertEquals(list.toString(), "3")
    }


}