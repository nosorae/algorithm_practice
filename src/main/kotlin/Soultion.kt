import java.util.*

/**
 * 2021.01.02
 * 조이스틱
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 * 예시 문제를 꼭 먼저 풀고 실제 문제를 푼다.
 */
class Solution {
    fun solution(name: String): Int {
        var answer = 0
        val len = name.length


        for (i in 0..name.length - 1) {
            answer += getAlphabetDistance(name[i])
        }

        return answer
    }

    fun getAlphabetDistance(cur: Char): Int =
        if (cur in 'A'..'N') {
            (cur - 'A')
        } else {
            ('Z' - cur) + 1
        }
    fun getRightPosition(cur: Int, len: Int): Int = if (cur + 1 < len) cur + 1 else 0
    fun getLeftPosition(cur: Int, len: Int): Int = if (cur - 1 >= 0) cur - 1 else len - 1
}