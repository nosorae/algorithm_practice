package programmers.brute_force

/**
 * 23.12.20 (수)
 * Lv2. 전력망을 둘로 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 * 최적의 끊는 지점을 찾아내는 특별한 알고리즘이 떠오르지 않음
 * 1개만 끊어보면 O(N)으로 확인이 되므로 다해본다고해도 O(N^2)
 * N의 최대는 100이므로 충분히 다 해볼만 함
 * 연결그래프 찾는 게 더 일이다.. 이경우엔 하나만 찾아도 나머지 개수를 알 수 있다.
 * 실수한 것: 복구 안해줌. 하나 끊고 시도해봤으면 끊었던 것 다시 복구해줘야함
 * [다른 사람 풀이 보고나서 개선하고 싶은 것]
 * 성능측면에서 굳이 map, set과 같은 자료구조를 사용해야할지 의문. 물론 vertex가 기본자료형이 아닌 경우는 유용하겠지만..
 * 다른 사람 풀이하고 비교했을 때 실행시간 거의 100배 차이나고, 메모리도 더 많이 먹는다.. 기본자료형 배열 활용하여 다시 풀어보기
 *
 */
import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs
import kotlin.math.min

class Solution86971 {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        val graph = makeGraph(wires = wires)
        return getMinDiffCountBetweenGraphs(totalNodeCount = n, wires = wires, graph = graph)
    }

    fun makeGraph(wires: Array<IntArray>): Map<Int, MutableSet<Int>> {
        val graph = mutableMapOf<Int, MutableSet<Int>>()
        for (edge in wires) {
            val start = edge[0]
            val end = edge[1]
            if (graph[start] == null) {
                graph[start] = mutableSetOf(end)
            } else {
                graph[start]?.add(end)
            }
            if (graph[end] == null) {
                graph[end] = mutableSetOf(start)
            } else {
                graph[end]?.add(start)
            }
        }
        return graph
    }

    fun getMinDiffCountBetweenGraphs(totalNodeCount: Int, wires: Array<IntArray>, graph: Map<Int, MutableSet<Int>>): Int {
        var min = Int.MAX_VALUE
        for (edge in wires) {
            val start = edge[0]
            val end = edge[1]
            graph[start]?.remove(end)
            graph[end]?.remove(start)
            val startNodeCount = getLinkedNodeCount(startNode = start, graph = graph)
            val endNodeCount = totalNodeCount - startNodeCount
            val diff = Math.abs(startNodeCount - endNodeCount)
            if (diff < min) {
                min = diff
            }
            graph[start]?.add(end) // 복구
            graph[end]?.add(start)
        }
        return min
    }

    fun getLinkedNodeCount(startNode: Int, graph: Map<Int, Set<Int>>): Int {
        val queue: Queue<Int> = LinkedList<Int>()
        val checkSet = mutableSetOf<Int>()
        queue.add(startNode)

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            checkSet.add(currentNode)
            graph[currentNode]?.forEach { node ->
                if (checkSet.contains(node).not()) {
                    queue.add(node)
                }
            }
        }

        return checkSet.size
    }

    /**
     * 다른 사람의 풀이
     */
    var answer: Int = Int.MAX_VALUE
    var vstd = Array(0) {IntArray(0)}
    var P = Array(0) {BooleanArray(0)}
    fun dfs(idx: Int, n: Int, wires: Array<IntArray>): Int {
        var ret = 1
        for (i in 0 until n) {
            if (P[idx][i]) {
                P[idx][i] = false
                P[i][idx] = false
                ret += dfs(i, n, wires)
                P[idx][i] = true
                P[i][idx] = true
            }
        }
        answer = min(answer, abs(n - ret - ret))
        return ret
    }

    fun solution2(n: Int, wires: Array<IntArray>): Int {
        vstd = Array(n) {IntArray(n)}
        P = Array(n) {BooleanArray(n)}

        repeat(wires.size) {
            val a = wires[it][0] - 1
            val b = wires[it][1] - 1

            P[a][b] = true
            P[b][a] = true
        }

        dfs(0, n, wires)



        return answer
    }
}