package programmers.brute_force

/**
 * 23.11.29 (수)
 * Lv2. 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 * 최소: 탐험조건 >= 소모: 탐험후
 * !유저가 탐험할 수 있는 최대 던전 수!
 * 뭔가 '최소필요피로도'와 '소모피로도' 두 개를 차례대로 기준으로해서 정렬하면 해결될 것 같지만 반례있음
 * 예를 들어 유저피로도 100에 (80, 80), (50, 20) 이 있다 했을 때 80짜리부터 돌면 1개밖에 못돈다.
 * 법칙이 있는 것 같지 않음 -> 다 해보자 8! (N의 크기가 완전탐색의 힌트가 되기도 한다.)
 * 실수했던 것: 재귀조건으로 유저의 현재 피로도를 최소필요피로도와 비교해야하는데 소모피로도와 비교하는 실수를 하였다.
 * 다른 사람의 풀이를 보고나서 발전시키고 싶은 것: 전역변수를 두지 않고 해결하기?
 */
class Solution {
    var maxDungeons = 0
    val checkSet = mutableSetOf<Int>()
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        bruteforce(k, dungeons, 0)
        return maxDungeons
    }

    private fun bruteforce(k: Int, dungeons: Array<IntArray>, count: Int) {
        if (maxDungeons < count) {
            maxDungeons = count
        }

        if (count >= dungeons.size) {
            return
        }

        for ((index, dungeon) in dungeons.withIndex()) {
            val enterK = dungeon[0]
            val minusK = dungeon[1]
            if (k >= enterK && checkSet.contains(index).not()) {
                checkSet.add(index)
                bruteforce(k - minusK, dungeons, count + 1)
                checkSet.remove(index)
            }
        }
    }

    fun solution2(k: Int, dungeons: Array<IntArray>): Int {
        var maxN = 0 // maxN 은 다음 던전들 끝까지 돌고나서 얻은 최대로 돌 수 있는 던전 개수
        for (i in 0 until dungeons.count()) {
            var d = dungeons[i]
            if (k >= d[0]) {
                var subN = solution2(
                    k - d[1],
                    dungeons.sliceArray(0..i - 1) +
                            dungeons.sliceArray(i + 1..dungeons.count() - 1)
                )
                if (subN + 1 > maxN) maxN = subN + 1
                if (maxN == dungeons.count()) return maxN
            }
        }
        return maxN
    }
}