package programmers.brute_force

/**
 * 23.11.26
 * Lv1. 소수 찾기
 * 포인트
 * 모든 조합 시도하는 코드 구현
 * 재귀로 바로 답 내는 게 어렵다면 우선 전역변수로 정답의 후보를 저장해놓고 재귀는 조합에만 신경써서 난이도를 낮출 수 있다.
 */
class Solution42839 {
    val combinationSet = mutableSetOf<Int>()
    fun solution(numbers: String): Int {
        var answer = 0
        combination(
            currentNumber = "",
            numbers = numbers
        )

        combinationSet.forEach { number ->
            if (isPrime(number)) {
                answer++
            }
        }
        return answer
    }

    private fun combination(currentNumber: String, numbers: String) {
        if (currentNumber.isNotEmpty()) {
            combinationSet.add(currentNumber.toInt())
        }

        if (numbers.isEmpty()) return

        numbers.forEachIndexed { index, number ->
            combination(
                currentNumber = currentNumber + numbers[index],
                numbers = numbers.substring(0, index) + numbers.substring(index + 1)
            )
        }
    }

    private fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        var i = 2
        while (i * i <= number) {
            if (number % i == 0) return false
            i++
        }
        return true
    }
}
