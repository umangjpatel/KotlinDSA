package linked_lists

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DoublyLinkedListTest {

    @Test
    fun isEmpty() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.push(value = 1)
        assertFalse(list.isEmpty())
    }

    @Test
    fun push() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.push(value = 1).push(value = 2)
        assertEquals(list.toString(), "2 <-> 1")
    }

    @Test
    fun append() {
        val list = DoublyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
        list.append(value = 1).append(value = 2)
        assertEquals(list.toString(), "1 <-> 2")
    }

    @Test
    fun nodeAt() {
        val list = DoublyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
        assertNull(list.nodeAt(index = -1))
        assertNull(list.nodeAt(index = 0))
        list.append(value = 1)
        assertNull(list.nodeAt(index = -1))
        assertEquals(list.nodeAt(index = 0).toString(), "1")
        assertNull(list.nodeAt(index = 1))
        list.append(value = 2).append(value = 3)
        assertEquals(list.nodeAt(index = 0).toString(), "1 <-> 2 <-> 3")
        assertEquals(list.nodeAt(index = 1).toString(), "2 <-> 3")
        assertEquals(list.nodeAt(index = 2).toString(), "3")
    }

    @Test
    fun insertAfter() {
        val list = DoublyLinkedList<Int>()
        list.insertAfter(index = 0, value = 1)
        assertEquals(list.toString(), "1")
        assertEquals(list.insertAfter(index = 1, value = 2).toString(), "1")
        list.insertAfter(index = 0, value = 2)
        assertEquals(list.toString(), "1 <-> 2")
        list.insertAfter(index = 0, value = 3)
        assertEquals(list.toString(), "1 <-> 3 <-> 2")
        list.insertAfter(index = 1, value = 4)
        assertEquals(list.toString(), "1 <-> 3 <-> 4 <-> 2")
        list.insertAfter(index = 2, value = 5)
        assertEquals(list.toString(), "1 <-> 3 <-> 4 <-> 5 <-> 2")
    }

    @Test
    fun pop() {
        val list = DoublyLinkedList<Int>()
        assertNull(list.pop())
        list.append(value = 1)
        assertEquals(list.toString(), "1")
        assertEquals(list.pop(), 1)
        assertEquals(list.toString(), "Empty list")
        list.append(value = 2).append(value = 1)
        assertEquals(list.toString(), "2 <-> 1")
        assertEquals(list.pop(), 2)
        assertEquals(list.toString(), "1")
        assertEquals(list.pop(), 1)
        assertEquals(list.toString(), "Empty list")
    }

    @Test
    fun removeLast() {
        val list = DoublyLinkedList<Int>()
        assertNull(list.pop())
        list.append(value = 1)
        assertEquals(list.toString(), "1")
        assertEquals(list.removeLast(), 1)
        assertEquals(list.toString(), "Empty list")
        list.append(value = 2).append(value = 1).append(value = 3)
        assertEquals(list.toString(), "2 <-> 1 <-> 3")
        assertEquals(list.removeLast(), 3)
        assertEquals(list.toString(), "2 <-> 1")
        assertEquals(list.removeLast(), 1)
        assertEquals(list.toString(), "2")
        assertEquals(list.removeLast(), 2)
        assertEquals(list.toString(), "Empty list")
    }

    @Test
    fun removeAt() {
        val list = DoublyLinkedList<Int>()
        assertNull(list.removeAt(index = 0))
        list.append(value = 0)
        assertEquals(list.toString(), "0")
        assertNull(list.removeAt(index = -1))
        assertNull(list.removeAt(index = 1))
        assertEquals(list.removeAt(index = 0), 0)
        assertEquals(list.toString(), "Empty list")

        list.append(value = 1).append(value = 2).append(value = 3).append(value = 4)
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4")
        assertNull(list.removeAt(index = -1))
        assertNull(list.removeAt(index = 4))
        assertEquals(list.removeAt(index = 1), 2)
        assertEquals(list.toString(), "1 <-> 3 <-> 4")
        assertEquals(list.removeAt(index = 1), 3)
        assertEquals(list.toString(), "1 <-> 4")
        assertEquals(list.removeAt(index = 1), 4)
        assertEquals(list.toString(), "1")
        assertEquals(list.removeAt(index = 0), 1)
        assertEquals(list.toString(), "Empty list")


    }
}