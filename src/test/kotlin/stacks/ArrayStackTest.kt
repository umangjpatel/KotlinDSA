package stacks

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArrayStackTest {

    @Test
    fun getSize() {
        val stack = ArrayStack<Int>()
        assertEquals(stack.size, 0)
        stack.push(1)
        assertEquals(stack.size, 1)
        stack.pop()
        assertEquals(stack.size, 0)
    }

    @Test
    fun push() {
        val stack = ArrayStack<Int>()
        assertTrue(stack.isEmpty)
        stack.apply {
            push(value = 1)
            push(value = 2)
        }
        assertFalse(stack.isEmpty)
        assertEquals(buildString {
            appendLine("----top----")
            appendLine("2")
            appendLine("1")
            appendLine("-----------")
        }, stack.toString())
    }

    @Test
    fun pop() {
        val stack = ArrayStack<Int>()
        assertTrue(stack.isEmpty)
        assertEquals(stack.toString(), "Empty stack")
        assertNull(stack.pop())
        stack.apply {
            push(value = 1)
            push(value = 2)
        }
        assertFalse(stack.isEmpty)
        assertEquals(buildString {
            appendLine("----top----")
            appendLine("2")
            appendLine("1")
            appendLine("-----------")
        }, stack.toString())
        assertEquals(stack.pop(), 2)
        assertEquals(buildString {
            appendLine("----top----")
            appendLine("1")
            appendLine("-----------")
        }, stack.toString())
        assertEquals(stack.pop(), 1)
        assertEquals(stack.toString(), "Empty stack")
    }

    @Test
    fun peek() {
        val stack = ArrayStack<Int>()
        assertTrue(stack.isEmpty)
        assertEquals(stack.toString(), "Empty stack")
        assertNull(stack.peek())
        stack.apply {
            push(value = 1)
            push(value = 2)
        }
        assertFalse(stack.isEmpty)
        assertEquals(buildString {
            appendLine("----top----")
            appendLine("2")
            appendLine("1")
            appendLine("-----------")
        }, stack.toString())
        assertEquals(stack.peek(), 2)
        assertEquals(buildString {
            appendLine("----top----")
            appendLine("2")
            appendLine("1")
            appendLine("-----------")
        }, stack.toString())
        assertEquals(stack.pop(), 2)
        assertEquals(buildString {
            appendLine("----top----")
            appendLine("1")
            appendLine("-----------")
        }, stack.toString())
        assertEquals(stack.peek(), 1)
        assertEquals(buildString {
            appendLine("----top----")
            appendLine("1")
            appendLine("-----------")
        }, stack.toString())
    }

    @Test
    fun stackOf() {
        val stack1 = ArrayStack<Int>()
        stack1.apply {
            push(1)
            push(2)
            push(3)
        }
        val stack2 = stackOf(1, 2, 3)
        assertEquals(stack1.toString(), stack2.toString())
    }

    @Test
    fun createStack() {
        val stack1 = ArrayStack.create(listOf(1, 2, 3))
        val stack2 = stackOf(1, 2, 3)
        val stack3 = ArrayStack<Int>().apply {
            push(1)
            push(2)
            push(3)
        }
        assertEquals(stack1.toString(), stack2.toString(), stack3.toString())
    }
}