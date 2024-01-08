package util.dfs_bfs

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class Graph(
    val nodeSize: Int
) {
    private val graph: Array<MutableList<Int>> = Array(nodeSize + 1) { mutableListOf() }

    fun addEdge(from: Int, to: Int) {
        graph[from].add(to)
        graph[to].add(from)
    }

    fun getLinkedNodesOf(node: Int): List<Int> {
        return graph[node]
    }
}

interface Search {
    fun search(startNode: Int)
}

class Dfs(
    val count: Int,
    val graph: Graph
) : Search {
    private val visited = BooleanArray(count) { false }
    private val stack = Stack<Int>()
    override fun search(startNode: Int) {
        stack.push(startNode)
        visited[startNode] = true

        while (stack.isNotEmpty()) {
            val currentNode = stack.pop()
            save(node = currentNode)
            for (node in graph.getLinkedNodesOf(currentNode)) {
                if (visited[node].not()) {
                    stack.push(node)
                    visited[node] = true
                }
            }
        }
    }

    private fun save(node: Int) {
        print("$node ")
    }
}

class Bfs(
    val count: Int,
    val graph: Graph
) : Search {
    private val visited = BooleanArray(size = count) { false }
    private val queue: Queue<Int> = LinkedList()

    override fun search(startNode: Int) {
        queue.add(startNode)
        visited[startNode] = true

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            save(node = currentNode)

            for (node in graph.getLinkedNodesOf(currentNode)) {
                if (visited[node].not()) {
                    queue.add(node)
                    visited[node] = true
                }
            }
        }
    }

    private fun save(node: Int) {
        print("$node ")
    }
}

class DirectedGraph(
    val nodeSize: Int
)

class WeightedGraph(
    val nodeSize: Int
)

class WeightedDirectedGraph(
    val nodeSize: Int
)

fun main() {
    val graph = Graph(nodeSize = 8).apply {
        addEdge(0, 1)
        addEdge(0, 2)
        addEdge(1, 3)
        addEdge(1, 4)
        addEdge(2, 5)
        addEdge(2, 6)
        addEdge(3, 7)
        addEdge(4, 5)
    }

    println("=======DFS=======")
    Dfs(
        count = 8,
        graph = graph
    ).search(startNode = 0)

    println()

    println("=======BFS=======")
    Bfs(
        count = 8,
        graph = graph
    ).search(startNode = 0)
}