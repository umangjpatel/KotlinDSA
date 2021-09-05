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

    @Test
    fun push() {
        val list = DoublyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
        list.push(value = 1).push(value = 2)
        assertFalse(list.isEmpty())
        assertEquals(list.toString(), "2 <-> 1")
    }

    @Test
    fun append() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        assertEquals(list.toString(), "Empty list")
        list.append(value = 1)
        assertFalse(list.isEmpty())
        assertEquals(list.toString(), "1")
        list.append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
    }

    @Test
    fun nodeAt() {
        val list = DoublyLinkedList<Int>()
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
        assertEquals(list.nodeAt(index = 0).toString(), "1 <-> 2 <-> 3")
        assertEquals(list.nodeAt(index = 1).toString(), "2 <-> 3")
        assertEquals(list.nodeAt(index = 2).toString(), "3")
    }
    
    @Test
    fun insertAfter() {
        val list = DoublyLinkedList<Int>()
        list.insertAfter(-1, 1)
        assertEquals(list.toString(), "Empty list")
        list.append(value = 0)
        assertEquals(list.toString(), "0")
        list.insertAfter(index = -1, value = 1)
        assertEquals(list.toString(), "0")
        list.insertAfter(index = 0, value = 1)
        assertEquals(list.toString(), "0 <-> 1")
        list.insertAfter(index = 0, value = 2)
        assertEquals(list.toString(), "0 <-> 2 <-> 1")
        list.insertAfter(index = 1, value = 3)
        assertEquals(list.toString(), "0 <-> 2 <-> 3 <-> 1")
        list.insertAfter(index = 1, value = 4)
        assertEquals(list.toString(), "0 <-> 2 <-> 4 <-> 3 <-> 1")
    }

    @Test
    fun pop() {
        val list = DoublyLinkedList<Int>()
        assertNull(list.pop())
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertFalse(list.isEmpty())
        assertEquals(list.pop(), 1)
        assertEquals(list.toString(), "2 <-> 3")
        assertEquals(list.pop(), 2)
        assertEquals(list.toString(), "3")
        assertEquals(list.pop(), 3)
        assertTrue(list.isEmpty())
    }

    @Test
    fun removeLast() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertEquals(list.removeLast(), 3)
        assertEquals(list.toString(), "1 <-> 2")
        assertEquals(list.removeLast(), 2)
        assertEquals(list.toString(), "1")
        assertEquals(list.removeLast(), 1)
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
    }

    @Test
    fun removeAt() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3).append(value = 4)
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4")
        assertEquals(list.removeAt(index = 2), 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 4")
        assertEquals(list.removeAt(index = 2), 4)
        assertEquals(list.toString(), "1 <-> 2")
        assertEquals(list.removeAt(index = 0), 1)
        assertEquals(list.toString(), "2")
        assertNull(list.removeAt(index = 1))
        assertEquals(list.removeAt(index = 0), 2)
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
    }

    @Test
    fun iterator() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertEquals(buildString {
            for (item in list) appendLine(item)
        }, list.toString().replace(" <-> ", "\n") + "\n")
    }

    @Test
    fun removeIterator() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        val iterator = list.iterator()
        while (iterator.hasNext())
            iterator.remove()
        assertFalse(iterator.hasNext())
    }

    @Test
    fun contains() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertTrue(list.contains(1))
        assertTrue(list.contains(2))
        assertTrue(list.contains(3))
        assertFalse(list.contains(4))
    }

    @Test
    fun containsAll() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        val testList1 = listOf(1, 2, 3)
        assertTrue(list.containsAll(testList1))
        val testList2 = listOf(2, 3, 4, 5)
        assertFalse(list.containsAll(testList2))
    }

    @Test
    fun remove() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertTrue(list.remove(1))
        assertEquals(list.toString(), "2 <-> 3")
        assertFalse(list.remove(4))
        assertEquals(list.toString(), "2 <-> 3")
        assertTrue(list.remove(3))
        assertEquals(list.toString(), "2")
        assertTrue(list.remove(2))
        assertTrue(list.isEmpty())
        assertEquals(list.toString(), "Empty list")
    }

    @Test
    fun removeAll() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        list.removeAll(listOf(2))
        assertEquals(list.toString(), "1 <-> 3")
        list.removeAll(listOf(2))
        assertEquals(list.toString(), "1 <-> 3")
        list.removeAll(listOf(3, 1))
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
    }

    @Test
    fun retainAll() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        list.retainAll(listOf(3, 1))
        assertEquals(list.toString(), "1 <-> 3")
        list.retainAll(listOf(1))
        assertEquals(list.toString(), "1")
        list.retainAll(listOf(1))
        assertEquals(list.toString(), "1")
        list.retainAll(listOf())
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
    }

    @Test
    fun printReverse() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertEquals(list.printReverse(), "3 <-> 2 <-> 1")
    }



    @Test
    fun getMiddleNode() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertEquals(list.getMiddleNode()?.value, 2)
        list.append(value = 4)
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4")
        assertEquals(list.getMiddleNode()?.value, 3)
    }

    @Test
    fun reverse() {
        val list = DoublyLinkedList<Int>()
        list.append(value = 1).append(value = 2).append(value = 3)
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertEquals(list.reverse().toString(), "3 <-> 2 <-> 1")
    }
}