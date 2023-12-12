package playground.data_structure


fun main() {

    // 기본적인 초기화와 set, get
    val map = mutableMapOf<String, Int>() // LinkedHashMap
    map["thfo"] = 10
    map["thfo"] = 10
    map["thfo"] = 10


    val mapTest = mutableMapOf<String, Int>()
    // Map<KeyType, Int> 으로 카운트하기
    mapTest["a"] = 0
    mapTest["b"] = 0
    mapTest["a"] = mapTest["a"]?.plus(1) ?: 0 // map 에서 key 가 없으면 null 을 반환하니까!
    println(mapTest.toString())

    // 다른 Iterable 로 부터 groupBy 로 카운트하고 변형해보기
    val list = listOf(1, 2, 3, 1, 1, 1, 2, 7, 7, 4)
    val groupedList = list.groupBy {
        it
    }
    val gList = list.groupBy(
        keySelector = {
            it
        },
        valueTransform = {
            it*2
        }
    )
    println(groupedList.toString())
    println(groupedList.forEach { (k, v) -> println("$k = " + v.size) })
    println(gList.toString())
    println(gList.forEach { (k, v) -> println("$k = " + v.size) })


    // LinkedHashMap 이 추가 순서를 지켜준다는 점을 이용해서 바로 value 들만 뽑아서 IntArray 로 반환환
    mapTest.values.toIntArray()

}
