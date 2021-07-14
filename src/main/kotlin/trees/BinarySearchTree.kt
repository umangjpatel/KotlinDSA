package trees

class BinarySearchTree<T : Comparable<T>> {

    var root: BinaryNode<T>? = null

    override fun toString(): String = root?.toString() ?: "Empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }

    fun contains(value: T): Boolean {
        var current = root
        while (current != null) {
            current = when {
                current.value == value -> return true
                value < current.value -> current.leftChild
                else -> current.rightChild
            }
        }
        return false
    }

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        node ?: return BinaryNode(value = value)
        if (value < node.value)
            node.leftChild = insert(node.leftChild, value)
        else
            node.rightChild = insert(node.rightChild, value)
        return node
    }

    fun remove(value: T) {
        root = remove(node = root, value = value)
    }

    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null
        when {
            value == node.value -> {
                if (node.leftChild == null && node.rightChild == null)
                    return null
                else if (node.leftChild == null)
                    return node.rightChild
                else if (node.rightChild == null)
                    return node.leftChild
                node.rightChild?.min?.value?.let { node.value = it }
                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> node.leftChild = remove(node = node.leftChild, value = value)
            value > node.value -> node.rightChild = remove(node = node.rightChild, value = value)
        }
        return node
    }

}