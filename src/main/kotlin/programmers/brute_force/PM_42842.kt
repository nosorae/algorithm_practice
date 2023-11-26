package programmers.brute_force

/**
 * 23.11.26
 * Lv2. 카펫
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * 3, 3 부터 다 해보며 만족하는 가로, 세로 길이를 찾아준다.
 * 갈색 테두리가 1줄이라 했으므로, 전체 카펫 크기로 부터 역으로 갈색, 노란색 개수 구할 수 있다.
 * 문제는 언제까지 시도해봐야하는가인데, 최소 brown/2 까지는 해봐야할 것으로 보인다.
 *
 * 브루트포스라고 해서 무조건 재귀인 것은 아니다.
 *
 * 다른 사람의 풀이 보고 배운점
 * O(N)으로 해결할 수 있는 문제였다. 브루트포스 카테고리에 있어서 다 해본다는 고정관념에 빠졌던 거 반성
 * yellow가 어떤 모양이든 yellow를 통해 brown을 만들 수 있다면? 을 생각해봤어야한다.
 */
class Solution42842 {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = IntArray(size = 2) { 0 }

        for (w in 3..(brown / 2)) {
            for (h in 3..w) {
                if (brown == calculateBrown(w = w, h = h) && yellow == calculateYellow(w = w, h = h)) {
                    answer[0] = w
                    answer[1] = h
                    return answer
                }
            }
        }
        return answer
    }

    private fun calculateBrown(w: Int, h: Int): Int = (w * 2) + ((h - 2) * 2)

    private fun calculateYellow(w: Int, h: Int): Int = (w - 2) * (h - 2)

    fun solution2(brown: Int, red: Int): IntArray {
        return (1..red)
            .filter { red % it == 0 }
            .first { brown == (red / it * 2) + (it * 2) + 4 } // brown 과 yellow의 상관관계로 풀이
            .let { intArrayOf(red / it + 2, it + 2) }
    }
}