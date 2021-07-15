package binary_search

fun <T : Comparable<T>> ArrayList<T>.binarySearch(
    value: T,
    range: IntRange = indices,
): Int? {
    if (range.first > range.last)
        return null

    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    return when {
        this[middle] == value -> middle
        value < this[middle] -> binarySearch(value = value, range = range.first until middle)
        else -> binarySearch(value = value, range = (middle + 1)..range.last)
    }
}