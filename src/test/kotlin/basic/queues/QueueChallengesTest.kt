package basic.queues

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QueueChallengesTest {

    @Test
    fun nextPlayer() {
        val queue = LinkedQueue<String>()
        queue.enqueue("Umang")
        queue.enqueue("Harsh")
        queue.enqueue("Yash")
        queue.enqueue("Harshil")
        assertEquals(queue.nextPlayer(), "Umang")
        assertEquals(queue.nextPlayer(), "Harsh")
        assertEquals(queue.nextPlayer(), "Yash")
        assertEquals(queue.nextPlayer(), "Harshil")
        assertEquals(queue.nextPlayer(), "Umang")
    }

    @Test
    fun reverse() {
        val queue = StackQueue<Int>()
        queue.enqueue(element = 1)
        queue.enqueue(element = 2)
        queue.enqueue(element = 3)
        assertEquals(queue.toString(), "1 , 2 , 3")
        assertEquals(queue.reverse().toString(), "3 , 2 , 1")
    }
}