package binary_search

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinarySearchTest {

    @Test
    fun binarySearch() {
        val list = arrayListOf(1, 2, 3, 4)
        assertEquals(list.binarySearch(1), list.indexOf(1))
        assertEquals(list.binarySearch(3), list.indexOf(3))
        assertEquals(list.binarySearch(2), list.indexOf(2))
        assertEquals(list.binarySearch(4), list.indexOf(4))
        assertNull(list.binarySearch(5))
    }
}