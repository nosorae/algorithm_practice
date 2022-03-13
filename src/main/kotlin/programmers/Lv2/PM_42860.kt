package programmers.Lv2

/**
 * 2021.01.02
 * 조이스틱
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 * 예시 문제를 꼭 먼저 풀고 실제 문제를 푼다.
 * 그리디 문제였지만 실전에선 지금처럼 맘편하게 브루트포스로 풀 것 같다.
 */
class Solution {
    private var min = Int.MAX_VALUE
    private var gName = ""
    fun solution(name: String): Int {
        gName = name
        var answer = 0

        // 전처리
        val check = Array(name.length) { false }
        for (i in name.indices) {
            if (name[i] == 'A') check[i] = true
            if (name[i] > 'M') answer += ('Z' - name[i] + 1) else answer += (name[i] - 'A')
        }

        // 브루트 포스
        bruteforce(0, 0, check)

        // 최소 이동값 더해주기
        answer += min

        return answer
    }
    private fun bruteforce(cur: Int, dist: Int, check: Array<Boolean>) {
        // min 보다 같거나 높다면 더이상 검사할 필요도 없다.
        if (dist >= min) return

        // 왼오왼오왼 같은 경우에 방문했음에도 방문하지 않은 것처럼 되는 것을 방지하기 위해 매번 새롭게 생성해준다.
        val nextCheck = check.copyOf()

        // 정답이 될 수 있는지 체크
        nextCheck[cur] = true
        var all = true
        for (i in nextCheck.indices) {
            if (!nextCheck[i]) all = false
        }
        // 정답이라면 갱신 시도
        if (all && min > dist) min = dist

        // 양방향 각각 재귀로 시도
        if (cur >= gName.length - 1) bruteforce(0, dist + 1, nextCheck) else bruteforce(cur + 1, dist + 1,nextCheck)
        if (cur <= 0) bruteforce(gName.length - 1, dist + 1, nextCheck) else bruteforce(cur - 1, dist + 1, nextCheck)
    }
}

fun main() {
    println(Solution().solution("AAABBAB"))
}

