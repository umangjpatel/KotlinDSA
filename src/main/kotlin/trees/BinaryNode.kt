package trees

typealias Traverser<T> = (T) -> Unit

class BinaryNode<T>(val value: T) {

    // Tracks the left child node
    var leftChild: BinaryNode<T>? = null
    // Tracks the right child node
    var rightChild: BinaryNode<T>? = null

    /**
     * Represents the binary tree in string format.
     * Time complexity: O(n) where n is the number of nodes.
     */
    override fun toString(): String = drawDiagram(this)

    /**
     * Traverse the nodes in in-order fashion
     * i.e visits the left node, then the current node and finally the right node
     * Time complexity: O(n)
     */
    fun traverseInOrder(visit: Traverser<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    /**
     * Traverse the nodes in pre-order fashion
     * i.e visits the current node, then the left node and finally the right node
     * Time complexity: O(n)
     */
    fun traversePreOrder(visit: Traverser<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    /**
     * Traverse the nodes in post-order fashion
     * i.e visits the left node, then the right node and finally the current node
     * Time complexity: O(n)
     */
    fun traversePostOrder(visit: Traverser<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    /**
     * Draws the binary tree in the console.
     *
     * This algorithm is based on an implementation by Károly Lőrentey
     * in his book Optimizing Collections,
     * available from https://www.objc.io/books/ optimizing-collections/.
     */
    private fun drawDiagram(node: BinaryNode<T>?,
                            top: String = "",
                            root: String = "",
                            bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                drawDiagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + drawDiagram(node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

}