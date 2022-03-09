package programmers.implementations

/**
 * 2021.08.12
 * Level1. 정수 내림차순으로 배치하기
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 * String 의 toList 로 List<Char> 로 만들고 sortedDescending 으로 내림차순으로 바꿔준 후 다시 정수로 만들어준다.
 */
class DescendingOrderOfNumber {
    fun solution(n: Long): Long =
        n.toString().toList().sortedDescending().joinToString(separator = "").toLong()
}

