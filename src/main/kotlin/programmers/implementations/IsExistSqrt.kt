package programmers.implementations

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * 2021.08.12
 * Level1. 정수 제곱근 판별
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 * sqrt 가 루트
 * 숫자.pow(지수)
 * import 없이 Math.sqrt Math.pow 를 사용할 수도 있다.
 * % 나 Math.floor 를 활용해서 문제를 해결할 수도 있다.
 */
class IsExistSqrt {
    fun solution(n: Long): Long {
        val rootNum = sqrt(n.toDouble())
        val rootLongNum = sqrt(n.toDouble()).toLong()
        return if(rootNum - rootLongNum == 0.0) (rootLongNum + 1.0).pow(2.0).toLong() else -1
    }
}
