package programmers.Lv3

/**
 * 섬 연결하기 (그리디 - 최소신장트리 - Kruskal, Prim)
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 * 어이없는 실수로 삽질
 * for (i in graph[cur].indices) 에서 i 는 인덱스 0, 1, 2... 이지 graph[cur] 의 원소 값이 아니다!!
 * 이것 때문에 뭐야 로직은 맞는데 왜 틀려?? 했다 다시는 이런 실수 하지 말자
 */
val graph = mutableListOf<MutableList<Int>>()
lateinit var checkVisit: Array<Boolean>
fun solution(n: Int, costs: Array<IntArray>): Int {
    var answer = 0

    for (i in 0 until n) {
        graph.add(mutableListOf())
    }
    val edges = costs.sortedWith { o1, o2 ->
        o1[2] - o2[2]
    }


    var cnt = 0
    var i = 0
    while (i < edges.size && cnt != n - 1) {

        val arr = edges[i]
        val from = arr[0]
        val to = arr[1]
        val cost = arr[2]

        graph[from].add(to)
        graph[to].add(from)
        checkVisit = Array(n) { false }
        if (checkCycle(from, -1)) {
            graph[from].remove(to)
            graph[to].remove(from)
        } else {
            cnt++
            answer += cost
        }
        i++
    }

    return answer
}

fun checkCycle(cur: Int, prev: Int): Boolean {
    checkVisit[cur] = true
    for (i in graph[cur].indices) { // 여기서 next 값은 index 값이지 graph[cur] 의 원소 값이 아니다!!!!
        val next = graph[cur][i]
        if (next != prev) {
            if (checkVisit[next]) return true
            if (checkCycle(next, cur)) return true
        }
    }
    return false
}