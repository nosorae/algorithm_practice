package programmers.sort

/**
 * ⭐️⭐️
 * 23.11.25
 * Lv2. 가장 큰 수
 * 배열에 있는 숫자 이어붙여 만들어지는 가장 큰 수
 * 앞자리 수 커지면 숫자 커지니 뭐든 앞자리만 크게 정렬하면 되겠다.
 * 주의 해야할 함정은 숫자 전체로 정렬하는 게 아니라 첫글자의 숫자를 기준으로 정렬해야함
 * 예를 들어, [3, 2, 100] 일 때 가장 크게 만드는 숫자는 10032가 아니라 32100이다.
 * 또 주의 해야할 점을 발견했다. [32, 30] 에서 더 큰 수를 만드는 방법은 3230 이지 3032가 아니다.
 * 결국 두 개를 비교할 때 앞뒤로 붙여서 더 높은 쪽을 선택해야한다.
 * 그런데 또 모든 숫자가 0일 수도 있다는 점도 주의해서 앞 숫자가 0이면 0을 리턴한다.
 */
class Solution42746 {
    fun solution(numbers: IntArray): String {
        val result = numbers.sortedWith { a, b ->
            "$b$a".compareTo("$a$b")
        }.joinToString("") { it.toString() }
        return if (result.startsWith("0")) "0" else result
    }
}