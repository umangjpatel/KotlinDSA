package trees

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinaryNodeTest {

    private fun makeBinaryTree(): BinaryNode<Int> {
        val root = BinaryNode(7)
        val zero = BinaryNode(0)
        val one = BinaryNode(1)
        val five = BinaryNode(5)
        val nine = BinaryNode(9)
        val eight = BinaryNode(8)

        one.leftChild = zero
        one.rightChild = five
        nine.leftChild = eight
        root.leftChild = one
        root.rightChild = nine
        return root
    }

    @Test
    fun testToString() {
        val tree = makeBinaryTree()
        assertEquals(tree.toString(), " ┌──null\n┌──9\n" +
                "│ └──8\n" +
                "7\n" +
                "│ ┌──5\n" +
                "└──1\n" +
                " └──0\n")
    }

    @Test
    fun traverseInOrder() {
        val tree = makeBinaryTree()
        assertEquals(buildString {
            tree.traverseInOrder { appendLine(it) }
        }, "0\n1\n5\n7\n8\n9\n")
    }

    @Test
    fun traversePreOrder() {
        val tree = makeBinaryTree()
        assertEquals(buildString {
            tree.traversePreOrder { appendLine(it) }
        }, "7\n1\n0\n5\n9\n8\n")
    }

    @Test
    fun traversePostOrder() {
        val tree = makeBinaryTree()
        assertEquals(buildString {
            tree.traversePostOrder { appendLine(it) }
        }, "0\n5\n1\n8\n9\n7\n")
    }
}