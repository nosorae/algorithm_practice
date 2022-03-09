package programmers.implementations



/**
 * 2021.08.12
 * Level1. 자연수 뒤집어 배열로 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12932
 *
 * 다른 사람(현지훈님)의 풀이가 더 효율적인 것 같다.
 */
class MyReverseIntArray {
    fun solution(n: Long): IntArray = n.toString().toList().map { it - '0' }.reversed().toIntArray()
}


class ReverseIntArray {
    fun solution(n: Long): IntArray {
        var num = n
        var answer = intArrayOf()

        while(num>0) {
            answer = answer + (num%10).toInt()
            num = num/10
        }

        return answer
    }
}