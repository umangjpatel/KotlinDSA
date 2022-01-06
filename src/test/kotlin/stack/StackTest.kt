package stack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StackTest {

    @Test
    fun testToString() {
        val stack = Stack<Int>()
        assertEquals(stack.toString(), "Empty stack")
        stack.push(1)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(1)
            appendLine("-----------")
        })
        stack.push(2)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(2)
            appendLine(1)
            appendLine("-----------")
        })
        stack.pop()
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(1)
            appendLine("-----------")
        })
        stack.peek()
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(1)
            appendLine("-----------")
        })
        stack.pop()
        assertEquals(stack.toString(), "Empty stack")
    }

    @Test
    fun testSize() {
        val stack = Stack<Int>()
        assertEquals(stack.count, 0)
        stack.push(1)
        assertEquals(stack.count, 1)
        stack.push(3)
        assertEquals(stack.count, 2)
        stack.push(2)
        assertEquals(stack.count, 3)
        stack.pop()
        assertEquals(stack.count, 2)
        stack.pop()
        assertEquals(stack.count, 1)
        stack.peek()
        assertEquals(stack.count, 1)
        stack.pop()
        assertEquals(stack.count, 0)
    }

    @Test
    fun testIsEmpty() {
        val stack = Stack<Int>()
        assertTrue(stack.isEmpty())
        stack.push(1)
        assertFalse(stack.isEmpty())
        stack.push(2)
        assertFalse(stack.isEmpty())
        stack.push(3)
        assertFalse(stack.isEmpty())
        stack.pop()
        assertFalse(stack.isEmpty())
        stack.pop()
        assertFalse(stack.isEmpty())
        stack.peek()
        assertFalse(stack.isEmpty())
        stack.pop()
        assertTrue(stack.isEmpty())
    }

    @Test
    fun testPush() {
        val stack = Stack<Int>()
        stack.push(1)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(1)
            appendLine("-----------")
        })
        stack.push(2)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(2)
            appendLine(1)
            appendLine("-----------")
        })
    }

    @Test
    fun testPop() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(2)
            appendLine(1)
            appendLine("-----------")
        })
        assertEquals(stack.pop(), 2)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(1)
            appendLine("-----------")
        })
        assertEquals(stack.pop(), 1)
        assertEquals(stack.toString(), "Empty stack")
    }

    @Test
    fun testPeek() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(2)
            appendLine(1)
            appendLine("-----------")
        })
        assertEquals(stack.peek(), 2)
        assertEquals(stack.toString(), buildString {
            appendLine("----top----")
            appendLine(2)
            appendLine(1)
            appendLine("-----------")
        })
    }

}