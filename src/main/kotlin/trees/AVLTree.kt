package trees

import kotlin.math.max

class AVLTree<T : Comparable<T>> {

    var root: AVLNode<T>? = null

    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.rightChild!!
        node.rightChild = pivot.leftChild
        pivot.leftChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }

    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }

    private fun rightLeftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightRotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.leftChild ?: return node
        node.leftChild = leftRotate(leftChild)
        return rightRotate(node)
    }

    private fun balanced(node: AVLNode<T>): AVLNode<T> {
        return when (node.balanceFactor) {
            2 -> {
                if (node.leftChild?.balanceFactor == -1)
                    leftRightRotate(node)
                else
                    rightRotate(node)
            }
            -2 -> {
                if (node.rightChild?.balanceFactor == 1)
                    rightLeftRotate(node)
                else
                    leftRotate(node)
            }
            else -> node
        }
    }

    fun insert(value: T) {
        root = insert(node = root, value = value)
    }

    private fun insert(node: AVLNode<T>?, value: T): AVLNode<T> {
        node ?: return AVLNode(value = value)

        if (value < node.value)
            node.leftChild = insert(node.leftChild, value)
        else
            node.rightChild = insert(node.rightChild, value)

        val balancedNode = balanced(node)
        balancedNode.height = max(balancedNode.leftHeight, balancedNode.rightHeight) + 1
        return balancedNode
    }

    fun search(value: T): Boolean {
        var current = root
        while (current != null) {
            if (current.value == value)
                return true
            else if (value < current.value)
                current = current.leftChild
            else
                current = current.rightChild
        }
        return false
    }

    fun remove(value: T) {
        root = remove(node = root, value = value)
    }

    private fun remove(node: AVLNode<T>?, value: T): AVLNode<T>? {
        node ?: return null
        when {
            node.value == value -> {
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
        val balancedNode = balanced(node)
        balancedNode.height = max(balancedNode.leftHeight, balancedNode.rightHeight) + 1
        return balancedNode
    }

    override fun toString(): String =
        root?.toString() ?: "Empty tree"


}