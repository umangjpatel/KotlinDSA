package queue

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LinkedQueueTest {
    @Test
    fun testGetCount() {
        val queue = LinkedQueue<Int>()
        assertEquals(queue.count, 0)
        queue.enqueue(1)
        assertEquals(queue.count, 1)
        queue.enqueue(2)
        assertEquals(queue.count, 2)
        queue.dequeue()
        assertEquals(queue.count, 1)
        queue.first()
        assertEquals(queue.count, 1)
        queue.dequeue()
        assertEquals(queue.count, 0)
        queue.dequeue()
        assertEquals(queue.count, 0)
    }

    @Test
    fun testEnqueue() {
        val queue = LinkedQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        queue.enqueue(1)
        assertEquals(queue.toString(), "1")
        queue.enqueue(2)
        assertEquals(queue.toString(), "1, 2")
        queue.enqueue(3)
        assertEquals(queue.toString(), "1, 2, 3")
    }

    @Test
    fun testDequeue() {
        val queue = LinkedQueue<Int>().apply {
            enqueue(1)
            enqueue(2)
            enqueue(3)
        }
        assertEquals(queue.toString(), "1, 2, 3")
        assertEquals(queue.dequeue(), 1)
        assertEquals(queue.toString(), "2, 3")
        assertEquals(queue.dequeue(), 2)
        assertEquals(queue.toString(), "3")
        assertEquals(queue.dequeue(), 3)
        assertEquals(queue.toString(), "Empty queue")
        assertNull(queue.dequeue())
        assertEquals(queue.toString(), "Empty queue")
    }

    @Test
    fun testFirst() {
        val queue = LinkedQueue<Int>()
        assertNull(queue.first())
        queue.enqueue(1)
        assertEquals(queue.first(), 1)
        queue.enqueue(2)
        assertEquals(queue.first(), 1)
        queue.dequeue()
        assertEquals(queue.first(), 2)
        queue.dequeue()
        assertNull(queue.first())
    }

    @Test
    fun testToString() {
        val queue = LinkedQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        queue.enqueue(1)
        assertEquals(queue.toString(), "1")
        queue.enqueue(2)
        assertEquals(queue.toString(), "1, 2")
        queue.dequeue()
        assertEquals(queue.toString(), "2")
        queue.dequeue()
        assertEquals(queue.toString(), "Empty queue")
    }
}