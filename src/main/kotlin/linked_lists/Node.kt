package linked_lists

data class SinglyNode<T>(var value: T, var next: SinglyNode<T>? = null) {
    override fun toString(): String =
        if (next == null) "$value"
        else "$value -> ${next.toString()}"
}

data class DoublyNode<T>(var value: T, var prev: DoublyNode<T>? = null, var next: DoublyNode<T>? = null) {
    override fun toString(): String =
        if (next == null) "$value"
        else "$value <-> ${next.toString()}"
}