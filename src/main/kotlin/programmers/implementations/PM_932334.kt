package programmers.implementations

/**
 * 신고 결과 받기
 * https://programmers.co.kr/learn/courses/30/lessons/92334
 */
fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
    report.map { it.split(" ") }
        .groupBy { it[1] } // 신고당한 사람을 key 로 하고 listOf(listOf("신고한사람","신고당한사람"), ...) 을 value 로 담은 map 반환
        .asSequence() // entry 를 iterate 하기
        .map { it.value.distinct() } // entry 의 각 value(List<List<String>>)에서 같은 List<String> 제거하고 Sequence<List<List<String>>> 반환
        .filter { it.size >= k } // 신고횟수를 초과한 List<List<String>>  만 남긴다.
        .flatten() // ??
        .map { it[0] } //
        .groupingBy { it } // ??
        .eachCount()
        .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }


fun mySolution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val reportSet = report.toSet()
    val reportedCnt = mutableMapOf<String, Int>()
    val reportMapSet = mutableMapOf<String, MutableSet<String>>()
    val ansCnt = mutableMapOf<String, Int>()

    id_list.forEach {
        reportedCnt[it] = 0
        ansCnt[it] = 0
        reportMapSet[it] = mutableSetOf<String>()
    }


    reportSet.forEach {
        val arr = it.split(" ")
        val er = arr[0]
        val ed = arr[1]

        reportedCnt[ed] = reportedCnt[ed]?.plus(1) ?: 0
        reportMapSet[er]?.add(ed)
    }


    reportedCnt.forEach { ed, v ->
        if (v >= k) {
            reportMapSet.forEach { er, s ->
                if (s.contains(ed)) {
                    ansCnt[er] = ansCnt[er]?.plus(1) ?: 0
                }
            }
        }
    }

    return ansCnt.values.toIntArray()
}



