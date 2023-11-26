package programmers.sort

import kotlin.math.min

/**
 * ⭐️⭐️⭐️
 * 23.11.25
 * Lv2. H-Index
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * 내림차순 정렬해서 H-Index가 가능한지 점검해서 해결
 * 조건을 끝까지 봐야한다.
 * 파라미터로 들어온 배열에 있는 숫자중에 정답이 있을 거라고 잘못생각했다.
 * 100, 100, 100 이면 H-Index는 0 이 아니고 3이다. 전달된 배열에 3 없지만 답은 3이 될 수 있다.
 * 주어진 케이스 외에도 다양한 케이스를 생각해봐야한다.
 *
 * 내림차순 정렬된 상태에서 count 번째인데 인용수가 count 이상이라는 건 count 이상 인용된 논문 수가 count 이상이라는 거 이용해서 풀이
 */
class Solution42747 {
    fun wrongSolution(citations: IntArray): Int {
        var answer = 0
        citations.sortDescending()

        for (citation in citations) {
            println(citations.joinToString { it.toString() })
            if (citations.takeWhile { citation <= it }.size >= citation) { // 여전히 O(N^2) 임
                answer = citation
                break
            }
        }
        return answer
    }

    fun solution(citations: IntArray): Int {
        var answer = 0
        citations.sortDescending()

        for ((i, citation) in citations.withIndex()) {
            val count = i + 1
            if (citation >= count) {
                // 내림차순 정렬된 상태에서 count 번째인데 인용수가 count 이상이라는 건 count 이상 인용된 논문 수가 count 이상이라는 거
                answer = count
            } else {
                break
            }
        }

        return answer
    }

    fun solutionChatGpt(citations: IntArray): Int {
        citations.sortDescending()
        var hIndex = 0

        for ((index, citation) in citations.withIndex()) {
            if (citation > index) {
                hIndex = index + 1
            } else {
                break
            }
        }

        return hIndex
    }

    fun solution3(citations: IntArray) = citations
        .sortedDescending()
        .mapIndexed { idx, item ->
            min(idx + 1, item)
        }
        .maxOf { it }
}

fun main() {
    Solution42747().apply {
        val answer = wrongSolution(citations = intArrayOf(5, 5, 5, 3, 3))
        println(answer)

        val answer3 = solution(citations = intArrayOf(5, 5, 5, 3, 3))
        println(answer3)

        val answer2 =
            solutionChatGpt(citations = intArrayOf(5, 5, 5, 3, 3))
        println(answer2)
    }
}