package trees

import org.junit.jupiter.api.Test
import kotlin.test.Ignore
import kotlin.test.assertEquals

internal class BinaryNodeTest {

    @Ignore
    private fun getSampleTree(): BinaryNode<Int> {
        val tree = BinaryNode(7)
        val zero = BinaryNode(0)
        val one = BinaryNode(1)
        val five = BinaryNode(5)
        val eight = BinaryNode(8)
        val nine = BinaryNode(9)
        tree.leftChild = one
        one.leftChild = zero
        one.rightChild = five
        tree.rightChild = nine
        nine.leftChild = eight
        return tree
    }

    @Test
    fun testTraversePreOrder() {
        val tree = getSampleTree()
        assertEquals(buildString {
            tree.traversePreOrder { appendLine(it.value) }
        }, buildString {
            appendLine(7)
            appendLine(1)
            appendLine(0)
            appendLine(5)
            appendLine(9)
            appendLine(8)
        })
    }

    @Test
    fun testTraversePostOrder() {
        val tree = getSampleTree()
        assertEquals(buildString {
            tree.traversePostOrder { appendLine(it.value) }
        }, buildString {
            appendLine(0)
            appendLine(5)
            appendLine(1)
            appendLine(8)
            appendLine(9)
            appendLine(7)
        })
    }

    @Test
    fun testTraverseInOrder() {
        val tree = getSampleTree()
        assertEquals(buildString {
            tree.traverseInOrder { appendLine(it.value) }
        }, buildString {
            appendLine(0)
            appendLine(1)
            appendLine(5)
            appendLine(7)
            appendLine(8)
            appendLine(9)
        })
    }


}