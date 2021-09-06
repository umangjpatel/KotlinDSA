package basic.queues

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LinkedQueueTest {

    @Test
    fun getSize() {
        val queue = LinkedQueue<Int>()
        assertEquals(queue.size, 0)
        queue.enqueue(element = 1)
        assertEquals(queue.size, 1)
        queue.enqueue(element = 2)
        assertEquals(queue.size, 2)
        queue.dequeue()
        assertEquals(queue.size, 1)
        queue.dequeue()
        assertEquals(queue.size, 0)
    }

    @Test
    fun enqueue() {
        val queue = LinkedQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        queue.enqueue(element = 1)
        assertEquals(queue.toString(), "1")
        queue.enqueue(element = 2)
        assertEquals(queue.toString(), "1 , 2")

    }

    @Test
    fun dequeue() {
        val queue = LinkedQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        queue.enqueue(element = 1)
        queue.enqueue(element = 2)
        assertEquals(queue.dequeue(), 1)
        assertEquals(queue.dequeue(), 2)
        assertNull(queue.dequeue())
    }

    @Test
    fun peek() {
        val queue = LinkedQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        queue.enqueue(element = 1)
        queue.enqueue(element = 2)
        assertEquals(queue.peek(), 1)
        assertEquals(queue.toString(), "1 , 2")
        assertEquals(queue.dequeue(), 1)
        assertEquals(queue.toString(), "2")
        assertEquals(queue.peek(), 2)
        assertEquals(queue.toString(), "2")
    }

    @Test
    fun testToString() {
        val queue = LinkedQueue<Int>()
        assertEquals(queue.toString(), "Empty queue")
        queue.enqueue(element = 1)
        assertEquals(queue.toString(), "1")
        queue.enqueue(element = 2)
        assertEquals(queue.toString(), "1 , 2")
        queue.dequeue()
        assertEquals(queue.toString(), "2")
        queue.dequeue()
        assertEquals(queue.toString(), "Empty queue")
    }
}