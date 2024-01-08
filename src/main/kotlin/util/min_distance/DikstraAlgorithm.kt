package util.min_distance


internal class MyGraph(//노드 수
    private val count: Int
) {
    private val vertexMatrix = Array(count) { IntArray(count) }// matrix로 그래프 표시
    private val distance = IntArray(count) // 특정 노드에 대한 각 노드의 최단 거리
    private val visited = BooleanArray(count) // already visited???

    fun calcShotestPath(from: Int) {
        for (i in 0 until count) {
            distance[i] = UNLIMIT
        }
        visited[from] = true
        distance[from] = 0 // 자기자신에게 가는 것이니 0
        //연결노드 distance갱신
        for (i in 0 until count) {
            if (visited[from] && vertexMatrix[from][i] != 0) {
                distance[i] = vertexMatrix[from][i] // 그저 초기화
            }
        }
        repeat(count - 1) { // 나를 제외한 모든 노드에 대해
            var min = UNLIMIT
            var minIndex = -1
            for (i in 0 until count) { // 초기화 된 것 중에 최소 거리 가진 노드
                if (!visited[i] && distance[i] != UNLIMIT) {
                    if (distance[i] < min) {
                        min = distance[i]
                        minIndex = i
                    }
                }
            }
            visited[minIndex] = true
            for (i in 0 until count) {
                if (!visited[i] && vertexMatrix[minIndex][i] != 0) {
                    if (distance[i] > distance[minIndex] + vertexMatrix[minIndex][i]) {
                        distance[i] = distance[minIndex] + vertexMatrix[minIndex][i]
                    }
                }
            }
        }
    }

    fun addEdges(from: Int, to: Int, weight: Int) {
        vertexMatrix[from][to] = weight
        vertexMatrix[to][from] = weight
    }

    fun showDistance(from: Int) {
        for (i in 0 until count) {
            println(from.toString() + " 노드로부터 " + i + " 노드의 최단 거리는 : " + distance[i])
        }
    }

    companion object {
        private const val UNLIMIT = 999999999 // 초기값
    }
}


object ShortestPath {
    @JvmStatic
    fun main(args: Array<String>) {
        val graph = MyGraph(6)
        graph.addEdges(0, 1, 1)
        graph.addEdges(0, 2, 4)
        graph.addEdges(1, 2, 2)
        graph.addEdges(2, 3, 1)
        graph.addEdges(3, 4, 8)
        graph.addEdges(3, 5, 3)
        graph.addEdges(4, 5, 4)
        graph.calcShotestPath(0)
        graph.showDistance(0)
    }
}