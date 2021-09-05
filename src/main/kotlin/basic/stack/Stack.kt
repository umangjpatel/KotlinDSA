package basic.stack

interface Stack<T> {
    val size: Int
    fun push(value: T)
    fun pop(): T?
    fun peek(): T?
    fun isEmpty(): Boolean = size == 0
}