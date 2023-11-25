package programmers.data_structure

import java.util.LinkedList
import java.util.Queue

/**
 * ⭐️
 * 2023.11.25
 * Level2. 기능 개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * Queue를 쓴 이유는 peek때문
 * 제일 앞에 넣은 것이 더 오래걸리면 뒤에것은 나갈 수 없기 때문.
 * 함정은 앞 피쳐가 뒷 피쳐와 완성일이 같을 때 배포일이 같다는 것
 *
 * 다른 사람 풀이 보고 느낀점
 * 완료되는 데 걸리는 일 수를 구할 때 나눗셈 결과를 소수점으로 바꾼 다음 ceil하는 센스
 * Queue로 peek만 쓸 거라면 외부 변수 하나 마지막으로 저장된 가장 높은 숫자를 저장하는 방법으로 대체할 수 있다.
 * 속도 자체는 내 풀이가 거의 모든 케이스에서 절반 이상 빠르다 (IntArray.plus 에서 속도 차이 나는 듯, 물론 mutableList 를 쓰는 것 보다 immutable한 array를 쓰는 게 더 좋은 습관이지)
 */
class Solution42586 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()

        val pendingFeatures: Queue<Int> = LinkedList()

        for (index in progresses.indices) {
            val progress = progresses[index]
            val speed = speeds[index]
            val remaining = 100 - progress
            var day = remaining / speed
            if (remaining > speed * day) {
                day++
            }

            if (pendingFeatures.isEmpty()) {
                pendingFeatures.add(day)
                continue
            }

            if (pendingFeatures.peek() < day) { // <= 이면 통과되지 않는 경우가 생김에 주의하라 == 는 무시하고 지나가야 정확한 개수 측정 가능
                answer.add(pendingFeatures.size)

                pendingFeatures.clear()
            }

            pendingFeatures.add(day)
        }
        answer.add(pendingFeatures.size)

        return answer.toIntArray()
    }

    fun solution2(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()

        var lastDay = 0
        var cnt = 0
        progresses
            .mapIndexed {idx, progress -> Pair(progress, speeds[idx].toDouble())}
            .map { (100 - it.first) / it.second }
            .map { Math.ceil(it) } // ceil 활용
            .map { it.toInt() }
            .asSequence()
            .forEach { curDay ->
                if (lastDay >= curDay) {
                    cnt++
                } else {
                    if (lastDay != 0)
                        answer = answer.plus(cnt)
                    lastDay = curDay
                    cnt = 1 // 초기화
                }
            }
        answer = answer.plus(cnt)

        return answer
    }
}

fun main() {
    Solution42586().apply {
        val answer =  solution(
            progresses = intArrayOf(93, 30, 55),
            speeds = intArrayOf(1, 30, 5)
        )
        val answer2 =  solution(
            progresses = intArrayOf(95, 90, 99, 99, 80, 99),
            speeds = intArrayOf(100, 100, 100, 1, 1, 1)
        )

        println(answer.toList())
        println(answer2.toList())
    }
}