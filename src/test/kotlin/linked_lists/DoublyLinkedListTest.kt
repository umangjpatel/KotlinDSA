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

    @Test
    fun contains() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        assertEquals(list.toString(), "Empty list")
        assertFalse(list.contains(1))
        list.addAll(listOf(1, 2, 3, 4))
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4")
        assertTrue(list.contains(1))
        assertTrue(list.contains(2))
        assertTrue(list.contains(3))
        assertTrue(list.contains(4))
        assertFalse(list.contains(5))
    }

    @Test
    fun containsAll() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        assertEquals(list.toString(), "Empty list")
        assertFalse(list.contains(1))
        list.addAll(listOf(1, 2, 3, 4))
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4")
        assertTrue(list.containsAll(listOf(1)))
        assertTrue(list.containsAll(listOf(2, 1)))
        assertTrue(list.containsAll(listOf(1, 2)))
        assertTrue(list.containsAll(listOf(3, 2, 1)))
        assertTrue(list.containsAll(listOf(1, 2, 3)))
        assertTrue(list.containsAll(listOf(4, 2, 3, 1)))
        assertTrue(list.containsAll(listOf(1, 2, 3, 4)))
        assertFalse(list.containsAll(listOf(1, 2, 4, 5)))
        assertFalse(list.containsAll(listOf(4, 5, 6, 7)))
    }

    @Test
    fun add() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        assertEquals(list.toString(), "Empty list")
        list.add(1)
        assertEquals(list.toString(), "1")
        list.add(2)
        assertEquals(list.toString(), "1 <-> 2")
    }

    @Test
    fun addAll() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        assertEquals(list.toString(), "Empty list")
        list.addAll(listOf(1, 2, 3, 4))
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4")
    }

    @Test
    fun clear() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        list.addAll(listOf(1, 2, 3))
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        list.clear()
        assertEquals(list.toString(), "Empty list")
    }

    @Test
    fun remove() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
        assertEquals(list.toString(), "Empty list")
        assertFalse(list.remove(element = 1))
        list.addAll(listOf(1, 2, 3, 4))
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4")
        assertTrue(list.remove(element = 4))
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertFalse(list.remove(element = 4))
        assertEquals(list.toString(), "1 <-> 2 <-> 3")
        assertTrue(list.remove(element = 2))
        assertEquals(list.toString(), "1 <-> 3")
        assertTrue(list.remove(element = 1))
        assertEquals(list.toString(), "3")
        assertTrue(list.remove(element = 3))
        assertEquals(list.toString(), "Empty list")
        assertFalse(list.remove(element = 3))
        assertEquals(list.toString(), "Empty list")
    }

    @Test
    fun iterator() {
        val list1 = DoublyLinkedList<Int>()
        list1.addAll(listOf(1, 2, 3))
        assertEquals(list1.toString().replace(" <-> ", "\n"), "1\n2\n3")
        val list2 = DoublyLinkedList<Int>().apply { addAll(listOf(1, 2, 3)) }
        assertEquals(buildString { for (item in list2) appendLine(item) },
            list1.toString().replace(" <-> ", "\n") + "\n")
    }

    @Test
    fun removeAll() {
        val list = DoublyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
        assertFalse(list.removeAll(listOf()))
        assertEquals(list.toString(), "Empty list")
        list.addAll(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6")
        assertFalse(list.removeAll(listOf(7)))
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6")
        assertTrue(list.removeAll(listOf(3)))
        assertEquals(list.toString(), "1 <-> 2 <-> 4 <-> 5 <-> 6")
        assertTrue(list.removeAll(listOf(2, 3)))
        assertEquals(list.toString(), "1 <-> 4 <-> 5 <-> 6")
        assertTrue(list.removeAll(listOf(4, 5)))
        assertEquals(list.toString(), "1 <-> 6")
        assertTrue(list.removeAll(listOf(1)))
        assertEquals(list.toString(), "6")
        assertTrue(list.removeAll(listOf(6)))
        assertEquals(list.toString(), "Empty list")
        assertTrue(list.isEmpty())
    }

    @Test
    fun retainAll() {
        val list = DoublyLinkedList<Int>()
        assertEquals(list.toString(), "Empty list")
        assertFalse(list.retainAll(listOf(1, 2, 3)))
        list.addAll(listOf(1, 2))
        assertEquals(list.toString(), "1 <-> 2")
        assertTrue(list.retainAll(listOf(1)))
        assertEquals(list.toString(), "1")
        list.addAll(listOf(2,3,4,5,6,7))
        assertEquals(list.toString(), "1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7")
        assertTrue(list.retainAll(listOf(3,7,6)))
        assertEquals(list.toString(), "3 <-> 6 <-> 7")
        assertTrue(list.retainAll(listOf()))
        assertEquals(list.toString(), "Empty list")
    }
}