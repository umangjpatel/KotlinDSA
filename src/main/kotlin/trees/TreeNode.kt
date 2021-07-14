package trees

import queues.StackQueue

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {
    private val children = mutableListOf<TreeNode<T>>()

    fun add(child: TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach { child -> child.forEachDepthFirst(visit) }
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = StackQueue<TreeNode<T>>()
        children.forEach { child -> queue.enqueue(element = child) }
        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { child -> queue.enqueue(child) }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        forEachLevelOrder { node ->
            if (node.value == value)
                result = node
        }
        return result
    }
}