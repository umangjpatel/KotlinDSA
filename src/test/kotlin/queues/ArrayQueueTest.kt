package queues

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArrayQueueTest {

    @Test
    fun getCount() {
        val queue = ArrayQueue<Int>()
        assertEquals(queue.count, 0)
        queue.enqueue(1)
        assertEquals(queue.count, 1)
        queue.enqueue(2)
        assertEquals(queue.count, 2)
    }

    @Test
    fun enqueue() {
        val queue = ArrayQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        assertTrue(queue.isEmpty)
        queue.enqueue(1)
        assertEquals(queue.toString(), "1")
        assertFalse(queue.isEmpty)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)
        assertEquals(queue.toString(), "1 , 2 , 3 , 4")
    }

    @Test
    fun dequeue() {
        val queue = ArrayQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        assertTrue(queue.isEmpty)
        assertNull(queue.dequeue())
        queue.enqueue(1)
        assertEquals(queue.toString(), "1")
        assertEquals(queue.dequeue(), 1)
        assertEquals(queue.toString(), "Empty queue")
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        assertEquals(queue.toString(), "1 , 2 , 3")
        assertEquals(queue.dequeue(), 1)
        assertEquals(queue.toString(), "2 , 3")
        assertEquals(queue.dequeue(), 2)
        assertEquals(queue.toString(), "3")
        assertEquals(queue.dequeue(), 3)
        assertEquals(queue.toString(), "Empty queue")
    }

    @Test
    fun peek() {
        val queue = ArrayQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        assertTrue(queue.isEmpty)
        assertNull(queue.peek())
        queue.enqueue(1)
        assertEquals(queue.toString(), "1")
        assertEquals(queue.peek(), 1)
        assertEquals(queue.toString(), "1")
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)
        assertEquals(queue.toString(), "1 , 2 , 3 , 4")
        assertEquals(queue.dequeue(), 1)
        assertEquals(queue.toString(), "2 , 3 , 4")
        assertEquals(queue.peek(), 2)
        assertEquals(queue.toString(), "2 , 3 , 4")
        assertEquals(queue.dequeue(), 2)
        assertEquals(queue.toString(), "3 , 4")
        assertEquals(queue.peek(), 3)
        assertEquals(queue.toString(), "3 , 4")
        assertEquals(queue.peek(), 3)
        assertEquals(queue.dequeue(), 3)
        assertEquals(queue.toString(), "4")
        assertEquals(queue.peek(), 4)
        assertEquals(queue.dequeue(), 4)
        assertEquals(queue.toString(), "Empty queue")
        assertNull(queue.peek())
        assertNull(queue.dequeue())
    }

    @Test
    fun testToString() {
        val queue = ArrayQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        queue.enqueue(1)
        queue.enqueue(2)
        assertEquals(queue.toString(), "1 , 2")
        queue.dequeue()
        assertEquals(queue.toString(), "2")
        queue.dequeue()
        assertEquals(queue.toString(), "Empty queue")
    }
}