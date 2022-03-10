package programmers.implementations


/**
 * 나머지가 1이 되는 수 찾기
 * Lv.1
 * https://programmers.co.kr/learn/courses/30/lessons/87389
 * 쉽지만 while 문 풀이도 참고
 */
fun solution(n: Int): Int {
    var answer = 1
    while (n % answer != 1) {
        answer++
    }
    return answer
}

fun mySolution(n: Int): Int {
    var answer: Int = 0
    for (i in 2 until n) {
        if (n % i == 1) {
            answer = i
            break
        }
    }
    return answer
}