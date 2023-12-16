package playground.sorting

fun main() {
    val mutableList = mutableListOf(3, 1, 2, 4, 5)
    val array = intArrayOf(3, 1, 2, 4, 5)
    array.sort()
    println(array)

    println("--sorted vs sort--")
    val sortedList = mutableList.sorted()
    println(mutableList)
    println(sortedList)
    mutableList.sort()
    println(mutableList)


    // 편의 함수들
    mutableList.sortedDescending()
    mutableList.sortedBy { it }
    mutableList.sortedByDescending { it }
//    mutableList.sortWith(object : Comparator<Int> {
//        override fun compare(o1: Int?, o2: Int?): Int {
//            TODO("Not yet implemented")
//        }
//    })
    mutableList.sortedWith { o1, o2 -> o1 - o2 }
    mutableList.toSortedSet() // java.util.TreeSet <- Red Black Tree로 구현

}