package implementations


/**
 * 2021.08.12
 * Level1. 약수의 합
 * https://programmers.co.kr/learn/courses/30/lessons/12928
 * 약수만 남기기위해 filter 사용
 * sum 으로 List 정수 원소의 합을 구함
 */
class SumOfMeasure {
    fun solution(n: Int): Int = (1..n).filter { n % it == 0 }.sum()
}