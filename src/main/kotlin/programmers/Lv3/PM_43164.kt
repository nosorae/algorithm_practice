package programmers.Lv3

import java.util.*

class Solution {

    val graph = mutableMapOf<String, LinkedList<Pair<String, Int>>>()
    val answer = LinkedList<String>()
    val check = mutableSetOf<Int>()
    var size = 0

    fun solution(tickets: Array<Array<String>>): Array<String> {
        size = tickets.size

        tickets.forEachIndexed { i, v ->
            val from = v[0]
            val to = v[1]
            graph[from]?.add(Pair(to, i)) ?: run {
                graph[from] = LinkedList(listOf(Pair(to, i)))
            }
        }

        graph.forEach { _, v ->
            v.sortBy { pair ->
                pair.first
            }
        }
        dfs("ICN")

        return answer.toTypedArray()
    }

    private fun dfs(cur: String): Boolean {
        answer.add(cur)
        if (answer.size == size + 1) return true

        val curGraph = graph[cur]
        if (curGraph.isNullOrEmpty()) {
            return false
        } else {

            for (i in 0 until curGraph.size) {
                val pair = curGraph[i]
                val next = pair.first
                val mappedIdx = pair.second

                if (check.contains(mappedIdx)) continue else check.add(mappedIdx) // 중복되는 경로를 가진 티켓이 여러개 나오는 경우 때문

                if (dfs(next)) {
                    return true
                } else {
                    curGraph.add(pair)
                    check.remove(mappedIdx)
                    answer.removeLast()
                }
            }

        }

        return false
    }

}