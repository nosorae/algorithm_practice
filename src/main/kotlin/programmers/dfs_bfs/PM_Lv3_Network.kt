package programmers.dfs_bfs

import java.util.LinkedList
import java.util.Queue
/**
 * 23.12.21 (목)
 * Lv3. 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * 연결된 그래프가 몇개있는지 구하는 문젤
 * visited 플래그로 이미 확인한 그래프에 속하는 노드는 얼리리턴 해준다.
 */
class Solution43162 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        return Network(
            nodeCount = n,
            graph = computers
        ).getNetworkCount()
    }
}

class Network(
    private val nodeCount: Int,
    private val graph: Array<IntArray>
) {
    private val visited = BooleanArray(nodeCount) { false }

    fun getNetworkCount(): Int = (0 until nodeCount).fold(0) { acc, node ->
        acc + bfs(startNode = node)
    }

    private fun bfs(startNode: Int): Int {
        if (visited[startNode]) return 0

        val queue: Queue<Int> = LinkedList()

        queue.add(startNode)
        visited[startNode] = true

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            for (node in graph[currentNode].indices) {
                if (graph[currentNode][node] == 1 && visited[node].not()) {
                    queue.add(node)
                    visited[node] = true
                }
            }
        }

        return 1
    }
}