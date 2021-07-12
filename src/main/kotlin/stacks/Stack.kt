package stacks

interface Stack<T> {
    val size: Int
    fun push(value: T)
    fun pop(): T?
    fun peek(): T?
    val isEmpty: Boolean
        get() = size == 0
}