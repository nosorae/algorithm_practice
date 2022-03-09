package programmers.implementations


/**
 * 2021.08.19
 * Level1. 직사각형 별찍기
 * https://programmers.co.kr/learn/courses/30/lessons/12969?language=kotlin
 *
 * 이거 * 를 채우는 방식으로 하면 더 쉬우려나
 * repeat 의 람다 인자는 zero-based index 이다.
 *
 */
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    repeat(a) {
        repeat(b) {
            print("*")
        }
        println()
    }
}