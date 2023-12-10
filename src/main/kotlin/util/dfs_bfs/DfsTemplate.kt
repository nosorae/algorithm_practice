package util.dfs_bfs


class DfsTemplate {
    lateinit var edges: Array<ArrayList<Int>>
    lateinit var visited: BooleanArray

    private fun dfs(index: Int) {
        println(index)

        // 들어왔으면 체크
        visited[index] = true

        // 연결 된 모든 노드에 대하여
        for (next in edges[index]) {
            // 방문하지 않은 노드가 있다면
            if (!visited[next]) {
                // 방문
                dfs(next)
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
        // 입력을 배열로 저장
        edges = Array(vertex + 1) { ArrayList() } // 0 버림
        visited = BooleanArray(vertex + 1) // 0 버림
        for (i in 1..edge) {
            val (a, b) = connection[i]
            edges[a].add(b)
            edges[b].add(a)
        }

        println("============= dfs 시작 =============")
        dfs(1)
    }
}

fun main() {
    DfsTemplate().apply {
        run()
    }
}

