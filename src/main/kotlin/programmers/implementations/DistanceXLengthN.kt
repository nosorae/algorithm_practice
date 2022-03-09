package programmers.implementations

/**
 * 2021.08.19
 * Level1. x만큼 간격이 있는 n개의 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 *
 *
 */
class DistanceXLengthN {
    fun solution(x: Int, n: Int): LongArray = LongArray(n) {
        (x.toLong() * (it + 1))
    }
}