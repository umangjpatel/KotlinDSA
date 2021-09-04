package basic.linkedlists

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String =
        if (next == null) "$value"
        else "$value -> ${next.toString()}"
}