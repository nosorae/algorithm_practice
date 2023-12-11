package util.search

fun List<Int>.binarySearch(number: Int): Int {
    var range = 0..this.lastIndex

    while (range.first <= range.last) {
        val midIndex = range.first + (range.last - range.first) / 2
        val midValue = this[midIndex]

        when {
            midValue == number -> return midIndex
            midValue < number -> range = (midIndex + 1)..range.last
            else -> range = range.first..(midIndex - 1)
        }
    }

    return -1
}