package basic.linkedlists

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LinkedListTest {

    @Test
    fun isEmpty() {
        val list = LinkedList<Int>()
        assertTrue(list.isEmpty())
        list.push(value = 1)
        assertFalse(list.isEmpty())
    }

    @Test
    fun testToString() {
        val list = LinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
        list.push(value = 1).push(value = 2)
        assertEquals(list.toString(), "2 -> 1")
    }

    @Test
    fun push() {
        val list = LinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
        list.push(value = 1).push(value = 2)
        assertFalse(list.isEmpty())
        assertEquals(list.toString(), "2 -> 1")
    }

    @Test
    fun append() {
        val list = LinkedList<Int>()
        assertTrue(list.isEmpty())
        assertEquals(list.toString(), "Empty list")
        list.append(value = 1)
        assertFalse(list.isEmpty())
        assertEquals(list.toString(), "1")
        list.append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 -> 2 -> 3")
    }

    @Test
    fun nodeAt() {
        val list = LinkedList<Int>()
        assertTrue(list.isEmpty())
        assertNull(list.nodeAt(index = -1))
        assertNull(list.nodeAt(index = 0))
        list.append(value = 1)
        assertNull(list.nodeAt(index = -1))
        assertNull(list.nodeAt(index = 1))
        assertNotNull(list.nodeAt(index = 0))
        assertEquals(list.nodeAt(index = 0).toString(), "1")
        list.append(value = 2).append(value = 3)
        assertNotNull(list.nodeAt(0))
        assertNotNull(list.nodeAt(1))
        assertNotNull(list.nodeAt(2))
        assertNull(list.nodeAt(3))
        assertEquals(list.nodeAt(index = 0).toString(), "1 -> 2 -> 3")
        assertEquals(list.nodeAt(index = 1).toString(), "2 -> 3")
        assertEquals(list.nodeAt(index = 2).toString(), "3")
    }

    @Test
    fun insertAfter() {
        val list = LinkedList<Int>()
        list.insertAfter(-1, 1)
        assertEquals(list.toString(), "Empty list")
        list.append(value = 0)
        assertEquals(list.toString(), "0")
        list.insertAfter(index = -1, value = 1)
        assertEquals(list.toString(), "0")
        list.insertAfter(index = 0, value = 1)
        assertEquals(list.toString(), "0 -> 1")
        list.insertAfter(index = 0, value = 2)
        assertEquals(list.toString(), "0 -> 2 -> 1")
        list.insertAfter(index = 1, value = 3)
        assertEquals(list.toString(), "0 -> 2 -> 3 -> 1")
        list.insertAfter(index = 1, value = 4)
        assertEquals(list.toString(), "0 -> 2 -> 4 -> 3 -> 1")
    }

    @Test
    fun pop() {
        val list = LinkedList<Int>()
        assertNull(list.pop())
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 -> 2 -> 3")
        assertFalse(list.isEmpty())
        assertEquals(list.pop(), 1)
        assertEquals(list.toString(), "2 -> 3")
        assertEquals(list.pop(), 2)
        assertEquals(list.toString(), "3")
        assertEquals(list.pop(), 3)
        assertTrue(list.isEmpty())
    }

    @Test
    fun removeLast() {
        val list = LinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 -> 2 -> 3")
        assertEquals(list.removeLast(), 3)
        assertEquals(list.toString(), "1 -> 2")
        assertEquals(list.removeLast(), 2)
        assertEquals(list.toString(), "1")
        assertEquals(list.removeLast(), 1)
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
    }

    @Test
    fun removeAt() {
        val list = LinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3).append(value = 4)
        assertEquals(list.toString(), "1 -> 2 -> 3 -> 4")
        assertEquals(list.removeAt(index = 2), 3)
        assertEquals(list.toString(), "1 -> 2 -> 4")
        assertEquals(list.removeAt(index = 2), 4)
        assertEquals(list.toString(), "1 -> 2")
        assertEquals(list.removeAt(index= 0), 1)
        assertEquals(list.toString(), "2")
        assertNull(list.removeAt(index = 1))
        assertEquals(list.removeAt(index = 0), 2)
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
    }

}