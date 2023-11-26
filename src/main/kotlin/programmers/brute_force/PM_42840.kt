package programmers.brute_force

/**
 * 23.11.26
 * Lv1. 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * 말그대로 다 해보는 문제.. 반복되는 패턴이니 나머지 연산자 활용
 * 3가지 중 Max를 구해야하니 List에 넣어서 maxOf {} 사용
 * 차례대로 넣어달래서 max값과 같은지 차례대로 따져서 리스트에 넣고 toIntArray 사용하여 반환
 */
class Solution42840 {
    val supo1 = intArrayOf(1, 2, 3, 4, 5)
    val supo2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val supo3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    fun solution(answers: IntArray): IntArray {
        var supo1Answer = 0
        var supo2Answer = 0
        var supo3Answer = 0
        for ((index, answer) in answers.withIndex()) {
            if (supo1[index % supo1.size] == answer) supo1Answer++
            if (supo2[index % supo2.size] == answer) supo2Answer++
            if (supo3[index % supo3.size] == answer) supo3Answer++
        }

        val max = listOf(supo1Answer, supo2Answer, supo3Answer).maxOf { it }

        return mutableListOf<Int>().apply {
            if (supo1Answer == max) add(1)
            if (supo2Answer == max) add(2)
            if (supo3Answer == max) add(3)
        }.toIntArray()
    }
}