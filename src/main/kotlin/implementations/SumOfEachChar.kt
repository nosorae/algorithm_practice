package implementations

/**
 * 2021.08.12
 * Level1. 자릿수 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/12931
 * String 을 List<Char> 로 바꾸고 map 으로 List<Int>로 바꿔준 후 sum 으로 합을 구해준다.
 * 왜 프로그래머스에서는 sumOf 가 안될까?
 * OpenJDK 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release. 라고 에러내용이 나온다.
 *
 */
class SumOfEachChar {
    fun solution(n: Int): Int = n.toString().map { it-'0' }.sum()
}

