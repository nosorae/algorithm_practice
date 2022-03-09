package programmers.implementations


/**
 * 없는 숫자 더하기
 * LV.1
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 */
fun solution(numbers: IntArray): Int = (0..9).filterNot(numbers::contains).sum()

fun mySolution(numbers: IntArray): Int {

    var answer: Int = 0
    val set = numbers.toSet()
    (0..9).forEach {
        if (set.contains(it).not()) answer += it
    }


    return answer
}