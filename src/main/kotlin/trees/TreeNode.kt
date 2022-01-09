package trees

import queues.LinkedQueue

private typealias TreeVisitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(var value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) {
        children.add(child)
    }

    fun traverseDepthWise(visit: TreeVisitor<T>) {
        visit(this)
        children.forEach {
            it.traverseDepthWise(visit)
        }
    }

    fun traverseLevelWise(visit: TreeVisitor<T>) {
        val queue = LinkedQueue<TreeNode<T>>()
        queue.enqueue(this)
        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        traverseLevelWise {
            if (it.value == value)
                result = it
        }
        return result
    }
}