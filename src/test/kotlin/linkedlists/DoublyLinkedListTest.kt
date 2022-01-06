package linkedlists

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DoublyLinkedListTest {

    @Test
    fun testToString() {
        val list = DoublyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
        list.push(1)
        assertEquals(list.toString(), "1")
        list.append(2)
        assertEquals(list.toString(), "1 <-> 2")
        list.insertAfter(0, 3)
        assertEquals(list.toString(), "1 <-> 3 <-> 2")
        list.pop()
        assertEquals(list.toString(), "3 <-> 2")
        list.removeLast()
        assertEquals(list.toString(), "3")
        list.removeAt(index = 0)
        assertEquals(list.toString(), "Empty list")
    }

    @Test
    fun testIsEmpty() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.push(1)
        assertFalse(list.isEmpty())
        list.append(2)
        assertFalse(list.isEmpty())
        list.insertAfter(0, 3)
        assertFalse(list.isEmpty())
        list.pop()
        assertFalse(list.isEmpty())
        list.removeLast()
        assertFalse(list.isEmpty())
        list.removeAt(index = 1)
        assertFalse(list.isEmpty())
        list.removeAt(index = 0)
        assertTrue(list.isEmpty())
    }

    @Test
    fun testSize() {
        val list = DoublyLinkedList<Int>()
        assertEquals(list.size, 0)
        list.push(1)
        assertEquals(list.size, 1)
        list.append(2)
        assertEquals(list.size, 2)
        list.insertAfter(0, 3)
        assertEquals(list.size, 3)
        list.pop()
        assertEquals(list.size, 2)
        list.removeLast()
        assertEquals(list.size, 1)
        list.removeAt(index = 1)
        assertEquals(list.size, 1)
        list.removeAt(index = 0)
        assertEquals(list.size, 0)
    }

    @Test
    fun testPush() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.push(1)
        list.push(2)
        list.push(3)
        assertFalse(list.isEmpty())
        assertEquals(list.toString(), "3 <-> 2 <-> 1")
    }

    @Test
    fun testAppend() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.append(1)
        list.append(2)
        list.append(3)
        assertFalse(list.isEmpty())
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
    }

    @Test
    fun testNodeAt() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        assertNull(list.nodeAt(0))
        assertNull(list.nodeAt(1))
        list.append(1).append(2).append(3)
        assertEquals(list.nodeAt(1).toString(), "2 <-> 3")
        assertEquals(list.nodeAt(0).toString(), "1 <-> 2 <-> 3")
        assertEquals(list.nodeAt(2).toString(), "3")
        assertNull(list.nodeAt(-1))
        assertNull(list.nodeAt(3))
    }

    @Test
    fun testInsertAfter() {
        val list = DoublyLinkedList<Int>().apply {
            append(1)
            append(2)
            append(3)
        }
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        list.insertAfter(0, 4)
        assertEquals(list.toString(), "1 <-> 4 <-> 2 <-> 3")
        list.insertAfter(3, 5)
        assertEquals(list.toString(), "1 <-> 4 <-> 2 <-> 3 <-> 5")
        list.append(6)
        assertEquals(list.toString(), "1 <-> 4 <-> 2 <-> 3 <-> 5 <-> 6")
    }

    @Test
    fun testPop() {
        val list = DoublyLinkedList<Int>().append(1).append(2).append(3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertEquals(list.pop(), 1)
        assertEquals(list.toString(), "2 <-> 3")
        assertEquals(list.pop(), 2)
        assertEquals(list.toString(), "3")
        assertEquals(list.pop(), 3)
        assertEquals(list.toString(), "Empty list")
        val list2 = SinglyLinkedList<Int>()
        assertTrue(list2.isEmpty())
        assertEquals(list2.size, 0)
        assertNull(list.pop())
        assertTrue(list2.isEmpty())
        assertEquals(list2.size, 0)
    }

    @Test
    fun testRemoveLast() {
        val list = DoublyLinkedList<Int>().append(1).append(2).append(3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertEquals(list.removeLast(), 3)
        assertEquals(list.toString(), "1 <-> 2")
        assertEquals(list.removeLast(), 2)
        assertEquals(list.toString(), "1")
        assertEquals(list.removeLast(), 1)
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
        assertEquals(list.size, 0)

        val list2 = SinglyLinkedList<Int>()
        assertTrue(list2.isEmpty())
        assertEquals(list2.size, 0)
        assertNull(list2.removeLast())
        assertEquals(list2.size, 0)
    }

    @Test
    fun testRemoveAt() {
        val list = DoublyLinkedList<Int>().append(1).append(2).append(3).append(4).append(5)
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4 <-> 5")
        assertEquals(list.removeAt(index = 0), 1)
        assertEquals(list.toString(), "2 <-> 3 <-> 4 <-> 5")
        assertEquals(list.removeAt(index = 3), 5)
        assertEquals(list.toString(), "2 <-> 3 <-> 4")
        assertEquals(list.removeAt(index = 1), 3)
        assertEquals(list.toString(), "2 <-> 4")
        assertEquals(list.removeAt(index = 1), 4)
        assertEquals(list.toString(), "2")
        assertEquals(list.removeAt(index = 0), 2)
        assertEquals(list.toString(), "Empty list")
    }

}