package programmers.implementations

/**
 * 2021.08.19
 * Level1. 콜라츠 추측
 * https://programmers.co.kr/learn/courses/30/lessons/12943
 *
 * cur 에서 Int 오버플로가 발생할 수 있음을 간과해서 시간을 썼다.
 * Int 범위를 벗어날 수 있다는 게 직관적으로 다가오지 않았는데
 * 프린트 해보니 - 가 나와서 Long 으로 바꿔주니 통과했다.
 *
 */
class CollatzGuess {
    fun solution(num: Int): Int = collatzGuess(0, num)

    tailrec fun collatzGuess(cnt: Int, cur: Int): Int  {
        println("$cnt -> $cur")
        return if (cnt > 500) -1
        else if (cur == 1) cnt
        else if (cur % 2 == 0)  collatzGuess(cnt + 1, cur/2)
        else collatzGuess(cnt + 1, cur * 3 + 1)
    }
}