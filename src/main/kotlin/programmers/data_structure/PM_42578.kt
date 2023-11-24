package programmers.data_structure

/**
 * ⭐️
 * 2021.08.12
 * Level2. 의상
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=kotlin#
 * 의상 종류와 의상으로 이루어진 쌍을 입력으로 받아서, 가능한 모든 의상 조합의 경우의 수를 구하는 문제
 * 특정 종류의 선택되지 않는 경우도 카운트해야함에 주의해야한다. (제공된 테스트 케이스에서 알 수 있다.)
 */
private class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = mutableMapOf<String, Int>()

        clothes.forEach { pair ->
            val category = pair[1]
            var count = map.getOrDefault(
                key = category,
                defaultValue = 1
            ) // 선택 안하는 경우를 defaultValue
            count++
            map[category] = count
        }

        var answer = 1
        map.values.forEach { value ->
            answer *= value
        }
        answer-- // 모두 선택하지 않는 경우

        return answer
    }
}

fun main() {
    val answer = Solution().solution(
        arrayOf(
            arrayOf("yellow_hat", "headgear"),
            arrayOf("blue_sunglasses", "eyewear"),
            arrayOf("green_turban", "headgear")
        )
    )
    print(answer)
}