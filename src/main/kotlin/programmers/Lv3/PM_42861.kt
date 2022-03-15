package programmers.Lv3

/**
 * 섬 연결하기 (그리디 - 최소신장트리 - Kruskal, Prim)
 * https://programmers.co.kr/learn/courses/30/lessons/42861
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
    while (i < n && cnt != n - 1) {

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
            println(i)
            answer += cost
        }
        i++
    }

    return answer
}

fun checkCycle(cur: Int, prev: Int): Boolean {
    checkVisit[cur] = true
    for (next in graph[cur].indices) {
        if (next != prev) {
            if (checkVisit[next]) {
                return true
            }
            if(checkCycle(next, cur)) return true
        }
    }
    return false
}