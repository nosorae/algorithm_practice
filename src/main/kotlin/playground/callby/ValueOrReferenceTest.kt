package playground.callby

fun main() {
    listComparisonByReferenceTest()
    listComparisonByItemTest()
}

fun listComparisonByReferenceTest() {
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(1, 2, 3)
    println(list1 == list2)


    val a = TestA(1)
    val a2 = TestA(1)
    println(a == a2)
}

fun listComparisonByItemTest() {
    // 참고: https://www.baeldung.com/kotlin/compare-lists
    val targetList = listOf("one", "two", "three", "four", "five")
    val listExactlySame = listOf("one", "two", "three", "four", "five")
    val listInDiffSizeButWithSameElements =
        listOf("one", "two", "three", "four", "five", "five", "five") // 순서 각 원소 모두 같음
    val listInDiffSizeAndElements = listOf("one", "two", "three", "four", "five", "five", "five", "I am a new element")
    val listInDiffOrder = listOf("two", "one", "three", "five", "four") // 순서 고려
    val listInDiffElement = listOf("ONE", "two", "three", "four", "FIVE")
    targetList.let {
        println(listExactlySame == it)
        println(listInDiffOrder == it)
        println(listInDiffSizeButWithSameElements == it)
        println(listInDiffSizeAndElements == it)
        println(listInDiffElement == it)
    }

    // 추가
    val mutableList = mutableListOf(1, 2)
    add(mutableList)
    println(mutableList)
    println(mutableList == listOf(1, 2, 3)) // true
}

fun add(list: MutableList<Int>) {
    list.add(3)
}

class TestA(val a: Int)