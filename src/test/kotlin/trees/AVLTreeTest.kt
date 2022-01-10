package trees


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

internal class AVLTreeTest {

    @Ignore
    private fun getSampleTree(): AVLTree<Int> {
        val tree = AVLTree<Int>()
        tree.insert(10)
        tree.insert(5)
        tree.insert(1)
        tree.insert(9)
        tree.insert(20)
        tree.insert(15)
        tree.insert(19)
        return tree
    }

    @Ignore
    private fun getAnotherSampleTree(): AVLTree<Int> {
        val tree = AVLTree<Int>()
        (0..4).forEach {
            tree.insert(it)
        }
        return tree
    }

    @Test
    fun testSearch() {
        val tree = getSampleTree()
        assertTrue(tree.search(10))
        assertFalse(tree.search(7))
        assertTrue(tree.search(20))
    }

    @Test
    fun testToString() {
        val tree = getAnotherSampleTree()
        assertEquals(tree.toString(), " ┌──4\n" +
                "┌──3\n" +
                "│ └──2\n" +
                "1\n" +
                "└──0\n")
    }

    @Test
    fun testInsert() {
        val tree = getSampleTree()
        tree.insert(10)
        assertTrue(tree.search(10))
        tree.insert(20)
        assertTrue(tree.search(20))
    }

    @Test
    fun testRemove() {
        val tree = getSampleTree()
        assertTrue(tree.search(10))
        tree.remove(10)
        assertFalse(tree.search(10))
        assertTrue(tree.search(20))
        tree.remove(20)
        assertFalse(tree.search(20))
    }
}