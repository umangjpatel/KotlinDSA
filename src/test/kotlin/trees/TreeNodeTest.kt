package trees

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class TreeNodeTest {

    private fun makeBeverageTree(): TreeNode<String> {
        val beverages = TreeNode("beverages")

        val black = TreeNode("black")
        val green = TreeNode("green")
        val chai = TreeNode("chai")
        val tea = TreeNode("tea")
        tea.add(black)
        tea.add(green)
        tea.add(chai)

        val coffee = TreeNode("coffee")
        val cocoa = TreeNode("cocoa")
        val hot = TreeNode("hot")
        hot.add(tea)
        hot.add(coffee)
        hot.add(cocoa)

        val gingerAle = TreeNode("ginger ale")
        val bitterLemon = TreeNode("bitter lemon")
        val soda = TreeNode("soda")
        soda.add(gingerAle)
        soda.add(bitterLemon)

        val milk = TreeNode("milk")
        val cold = TreeNode("cold")
        cold.add(soda)
        cold.add(milk)

        beverages.add(hot)
        beverages.add(cold)
        return beverages
    }

    @Test
    fun forEachDepthFirst() {
        val tree = makeBeverageTree()
        val result = buildString { tree.forEachDepthFirst { node -> appendLine(node.value) } }
        assertEquals(result, buildString {
            appendLine("beverages")
            appendLine("hot")
            appendLine("tea")
            appendLine("black")
            appendLine("green")
            appendLine("chai")
            appendLine("coffee")
            appendLine("cocoa")
            appendLine("cold")
            appendLine("soda")
            appendLine("ginger ale")
            appendLine("bitter lemon")
            appendLine("milk")
        })
    }

    @Test
    fun forEachLevelOrder() {
        val tree = makeBeverageTree()
        val result = buildString { tree.forEachLevelOrder { node -> appendLine(node.value) } }
        assertEquals(result, buildString {
            appendLine("beverages")
            appendLine("hot")
            appendLine("cold")
            appendLine("tea")
            appendLine("coffee")
            appendLine("cocoa")
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
    fun search() {
        val tree = makeBeverageTree()
        assertNull(tree.search("ginger"))
        assertNull(tree.search("cha"))
        assertEquals(tree.search("ginger ale")?.value, "ginger ale")
        assertEquals(tree.search("bitter lemon")?.value, "bitter lemon")
    }
}