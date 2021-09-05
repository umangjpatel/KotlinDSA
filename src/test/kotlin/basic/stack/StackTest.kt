package basic.stack

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StackTest {

    @Test
    fun isEmpty() {
        val stack = StackImpl<Int>()
        assertTrue(stack.isEmpty())
        stack.push(value = 1)
        assertFalse(stack.isEmpty())
        stack.pop()
        assertTrue(stack.isEmpty())
    }

    @Test
    fun testToString() {
        val stack = StackImpl<Int>()
        assertEquals(stack.toString(), "Empty stack")
        stack.push(value = 1)
        stack.push(value = 2)
        stack.push(value = 3)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine("3")
            appendLine("2")
            appendLine("1")
            appendLine("-----------")
        })
        stack.pop()
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine("2")
            appendLine("1")
            appendLine("-----------")
        })
        stack.pop()
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine("1")
            appendLine("-----------")
        })
        stack.pop()
        assertEquals(stack.toString(), "Empty stack")
    }

    @Test
    fun getSize() {
        val stack = StackImpl<Int>()
        assertEquals(stack.size, 0)
        stack.push(value = 1)
        assertEquals(stack.size, 1)
        stack.push(value = 2)
        assertEquals(stack.size, 2)
        stack.push(value = 3)
        assertEquals(stack.size, 3)
    }

    @Test
    fun push() {
        val stack = StackImpl<Int>()
        assertEquals(stack.toString(), "Empty stack")
        stack.push(value = 1)
        stack.push(value = 2)
        stack.push(value = 3)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine("3")
            appendLine("2")
            appendLine("1")
            appendLine("-----------")
        })
    }

    @Test
    fun pop() {
        val stack = StackImpl<Int>()
        assertEquals(stack.toString(), "Empty stack")
        stack.push(value = 1)
        stack.push(value = 2)
        stack.push(value = 3)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine("3")
            appendLine("2")
            appendLine("1")
            appendLine("-----------")
        })
        assertEquals(stack.pop(), 3)
        assertEquals(stack.pop(), 2)
        assertEquals(stack.pop(), 1)
        assertEquals(stack.toString(), "Empty stack")
    }

    @Test
    fun peek() {
        val stack = StackImpl<Int>()
        assertEquals(stack.toString(), "Empty stack")
        stack.push(value = 1)
        assertEquals(stack.peek(), 1)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine("1")
            appendLine("-----------")
        })
        stack.push(value = 2)
        assertEquals(stack.peek(), 2)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine("2")
            appendLine("1")
            appendLine("-----------")
        })
    }
}