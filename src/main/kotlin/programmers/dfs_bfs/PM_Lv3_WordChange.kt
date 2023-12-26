package programmers.dfs_bfs

import java.util.LinkedList
import java.util.Queue

/**
 * 23.12.21 (목)
 * Lv2. 단어변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * 단어를 정점으로 하고 한글자만 차이났을 때를 연결되어있다고 판단하면 그래프로 만들 수 있음
 * 그러면 가중치 없는 그래프 최단거리 문제로 풀 수 있으므로 BFS로 풀 수 있다.
 * 노드를 Int만으로 표현할 수 없으니 class 따로 만들기
 * TODO:: 노드 data class Word 로 놓고 풀었으면 더 편하게 풀 수 있지 않았을까?
 */
class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        return WordChange(
            begin = begin,
            words = words
        ).getMinDistance(
            target = target
        )
    }
}

class WordChange(
    val begin: String,
    val words: Array<String>
) {
    private val graph: MutableMap<String, MutableList<String>> = mutableMapOf()

    init {
        graph[begin] = mutableListOf<String>()
        for (word in words) {
            if (begin.isLinkedWord(other = word)) {
                graph[begin]?.add(word)
            }
        }

        for (word in words) {
            graph[word] = mutableListOf<String>()
        }
        for (word in words) {
            for (candidate in words) {
                if (word == candidate) continue
                if (word.isLinkedWord(other = candidate)) {
                    graph[word]?.add(candidate)
                }
            }
        }
    }

    fun getMinDistance(
        target: String
    ): Int {
        val checkSet: MutableSet<String> = mutableSetOf()
        val distance: MutableMap<String, Int> = mutableMapOf()
        val queue: Queue<String> = LinkedList()

        queue.add(begin)
        checkSet.add(begin)
        while (queue.isNotEmpty()) {
            val currentWord = queue.poll()

            if (currentWord == target) break

            graph[currentWord]?.forEach { word ->
                if (checkSet.contains(word).not()) {
                    distance[word] = (distance[currentWord] ?: 0) + 1
                    queue.add(word)
                    checkSet.add(word)
                }
            }
        }

        return distance[target] ?: 0
    }

    private fun String.isLinkedWord(other: String): Boolean {
        if (this.length != other.length) return false
        return this.filterIndexed { index, char -> char != other[index] }.length == 1
    }
}
