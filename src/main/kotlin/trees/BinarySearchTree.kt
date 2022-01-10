package trees

class BinarySearchTree<T : Comparable<T>> {

    var root: BinaryNode<T>? = null

    override fun toString(): String =
        root?.toString() ?: "Empty tree"

    fun insert(value: T) {
        root = insert(node = root, value = value)
    }

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        node ?: return BinaryNode(value = value)
        if (value < node.value)
            node.leftChild = insert(node.leftChild, value = value)
        else
            node.rightChild = insert(node.rightChild, value = value)
        return node
    }

    fun search(value: T): Boolean {
        var current = root
        while (current != null) {
            current = if (current.value == value)
                return true
            else if (value < current.value)
                current.leftChild
            else
                current.rightChild
        }
        return false
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
                if (node.rightChild == null)
                    return node.leftChild
                if (node.leftChild == null)
                    return node.rightChild

                node.rightChild?.min?.value?.let {
                    node.value = it
                }
                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }

}