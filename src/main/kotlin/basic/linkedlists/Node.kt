package basic.linkedlists

data class SinglyNode<T>(var value: T, var next: SinglyNode<T>? = null) {
    override fun toString(): String =
        if (next == null) "$value"
        else "$value -> ${next.toString()}"
}