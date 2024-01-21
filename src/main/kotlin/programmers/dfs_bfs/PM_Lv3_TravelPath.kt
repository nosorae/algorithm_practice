/**
 * 23.12.21 (목)
 * Lv3. 여행경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 *
 * 중복되는 항공권이 없다고는 말 안했다..
 * 추가 반례 : https://school.programmers.co.kr/questions/18184
 * 문제를 잘 읽어야한다. "항공권을 모두 사용"하는 게 먼저다.
 * 단순히 알파벳 순서로 방문하니 소진하지 못하는 티켓이 발생하는 반례에서 해멨다.
 * 방향그래프에서 dfs 는 순간이동하는 것처럼 보일 수 있다. (무방향은 백한다는 개념이 자연스러운데, 여기는 "티켓"이니까)
 * 티켓을 소진함을 편하게 표시하기 위해서 Queue 사용
 * (연결된 노드 정렬했다는 전제하에)
 * 입력은 무조건 모든 도시를 방문할 수 있기 때문에, 한 노드에서 다른 노드로가는 티켓이 여러개라면 첫번째 다른 노드로 가는 경로를 마지막에 넣어줘야한다.
 * 모든 도시를 방문할 수 있다는 전제는, 첫번째로 다른 노드로 가는 경로만 돌아오는 길이 없을 수 있고 다른 노드로 가는 경로는 돌아오는 길이 있을 수밖에 없기 때문이다.
 * 그래야 티켓을 모두 소진할 수 있다.
 *
 * TODO:: 다시 풀어보기, 다른 사람 풀이 참고하기
 */
import java.util.*

class Solution43164 {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        return TravelPath(edges = tickets).getPaths()
    }
}

class TravelPath(
    private val edges: Array<Array<String>>
) {
    private lateinit var graph: Map<String, Queue<String>>
    private val tickets = mutableMapOf<String, Int>()

    init {
        val tempGraph = mutableMapOf<String, Queue<String>>()

        for(edge in edges) {
            val from = edge[0]
            val to = edge[1]
            tempGraph[from]?.add(to) ?: run {
                tempGraph[from] = LinkedList<String>().apply {
                    add(to)
                }
            }
            tickets[getPathString(from, to)] = (tickets[getPathString(from, to)] ?: 0) + 1
        }

        tempGraph.keys.forEach { key ->
            tempGraph[key] = LinkedList(tempGraph[key]?.sorted()?.toMutableList() ?: mutableListOf())
        }

        graph = tempGraph
    }

    fun getPaths(): Array<String> {
        return travelAll(from = START_FROM)
    }

    private fun travelAll(from: String): Array<String> {
        var resultArr = arrayOf(from)

        graph[from]?.let { q ->
            val tempArr = Array(q.size) { arrayOf<String>() }
            var index = 0
            while (q.isNotEmpty()) {
                val to = q.poll()
                val path = getPathString(from = from, to = to)
                val ticketCount = tickets[path]
                if (ticketCount != null && ticketCount > 0) {
                    tickets[path] = ticketCount - 1
                    tempArr[index] = travelAll(to)
                }
                index++
            }


            if (tempArr.size > 1) {
                for (index in 1 until tempArr.size) {
                    resultArr += tempArr[index]
                }
            }


            if (tempArr.isNotEmpty()) {
                resultArr += tempArr[0]
            }
        }

        return resultArr
    }

    private fun getPathString(from: String, to: String): String = "$from$to"

    companion object {
        const val START_FROM = "ICN"
    }
}