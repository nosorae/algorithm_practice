package util.dfs_bfs

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.ArrayList


class BfsTemplate {
    lateinit var edges: Array<ArrayList<Int>>
    lateinit var visited: BooleanArray

    val queue: Queue<Int> = LinkedList()

    // 너비우선 탐색
    fun bfs(start: Int) {
        queue.add(start) // 우선 큐에 넣는다.
        visited[start] = true // 첫 노드 방문 처리

        while (queue.isNotEmpty()) { // 큐가 빌때까지
            val head = queue.poll() // 노드를 하나씩 빼서
            println(head)

            for (next in edges[head]) { // 뺀 노드와 연결된 모든 노드를 순회하는데
                if (!visited[next]) { // 방문한 건 제외하고, 방문 안 한 노드라면
                    visited[next] = true // 방문처리하고
                    queue.add(next) // 큐에 넣는다.
                }
            }
        }
    }

    fun run() {
        val vertex = 8
        val edge = 7
        val connection = listOf(
            1 to 2,
            2 to 8,
            1 to 3,
            2 to 4,
            4 to 5,
            7 to 4,
            6 to 7
        )
        edges = Array(vertex + 1) { ArrayList() } // 0 버림
        visited = BooleanArray(vertex + 1) // 0 버림
        for (i in 1..edge) {
            val (a, b) = connection[i]
            edges[a].add(b)
            edges[b].add(a)
        }
        bfs(1)
    }
}

fun main() {
    BfsTemplate().apply {
        run()
    }
}

