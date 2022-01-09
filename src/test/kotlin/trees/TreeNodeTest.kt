package trees

import jdk.nashorn.internal.ir.annotations.Ignore
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TreeNodeTest {

    @Ignore
    private fun getSampleTree(): TreeNode<String> {
        val tree = TreeNode("beverages")
        val hot = TreeNode("hot")
        val cold = TreeNode("cold")

        val tea = TreeNode("tea")
        val coffee = TreeNode("coffee")
        val chocolate = TreeNode("chocolate")

        val blackTea = TreeNode("black")
        val greenTea = TreeNode("green")
        val chaiTea = TreeNode("chai")

        val soda = TreeNode("soda")
        val milk = TreeNode("milk")

        val gingerAle = TreeNode("ginger ale")
        val bitterLemon = TreeNode("bitter lemon")

        tea.add(blackTea)
        tea.add(greenTea)
        tea.add(chaiTea)

        hot.add(tea)
        hot.add(coffee)
        hot.add(chocolate)

        soda.add(gingerAle)
        soda.add(bitterLemon)

        cold.add(soda)
        cold.add(milk)

        tree.add(hot)
        tree.add(cold)

        return tree
    }

    @Test
    fun testDepthFirstTraversal() {
        val tree = getSampleTree()
        val outputString = buildString {
            tree.traverseDepthWise {
                appendLine(it.value)
            }
        }
        assertEquals(outputString, buildString {
            appendLine("beverages")
            appendLine("hot")
            appendLine("tea")
            appendLine("black")
            appendLine("green")
            appendLine("chai")
            appendLine("coffee")
            appendLine("chocolate")
            appendLine("cold")
            appendLine("soda")
            appendLine("ginger ale")
            appendLine("bitter lemon")
            appendLine("milk")
        })
    }

    @Test
    fun testLevelWiseTraversal() {
        val tree = getSampleTree()
        val outputString = buildString {
            tree.traverseLevelWise {
                appendLine(it.value)
            }
        }
        assertEquals(outputString, buildString {
            appendLine("beverages")
            appendLine("hot")
            appendLine("cold")
            appendLine("tea")
            appendLine("coffee")
            appendLine("chocolate")
            appendLine("soda")
            appendLine("milk")
            appendLine("black")
            appendLine("green")
            appendLine("chai")
            appendLine("ginger ale")
            appendLine("bitter lemon")
        })
    }

    @Test
    fun testSearch() {
        val tree = getSampleTree()
        assertNotNull(tree.search("hot"))
        assertNotNull(tree.search("ginger ale"))
        assertNull(tree.search("bitter ale"))
    }
}