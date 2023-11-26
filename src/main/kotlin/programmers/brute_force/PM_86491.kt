package programmers.brute_force

import kotlin.math.min
import kotlin.math.max

/**
 * ⭐️⭐️⭐️
 * 23.11.26
 * Lv1. 최소 직사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * 많이 해멘 이유.. 일단 두 직사각형만 주어졌을 때도 어떻게 해야하는지 처음에 잘 떠오르지 않았음
 * 10000 보자마자 일단 O(N^2)으로는 시간초과 날 것이 예상됨
 * 이전 인텍스까지 구한 max값을 저장해놓고 새로운 max값을 갱신해나가면 O(N)으로 가능
 * 두 직사각형만 주어졌을 때 비교하는 방법은 정방향으로 비교해보고 90도 회전시켜서도 비교해서 크기가 더 작은 경우가 최소크기이다.
 * 여기서 max를 쓰는 이유는 포함시켜야하기 때문이다.
 *
 * 다른 사람의 풀이 참고 필요
 */
class Solution86491 {
    fun solution(sizes: Array<IntArray>): Int {
        var maxW = 0
        var maxH = 0
        for (currentSize in sizes) {
            val w = currentSize[0]
            val h = currentSize[1]

            if (max(maxW, w) * max(maxH, h) <= max(maxW, h) * max(maxH, w)) {
                maxW = max(maxW, w)
                maxH = max(maxH, h)
            } else {
                maxW = max(maxW, h)
                maxH = max(maxH, w)
            }
        }
        return maxW * maxH
    }
}