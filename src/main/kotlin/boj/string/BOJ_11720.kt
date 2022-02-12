package boj.string


/**
 * 2022.02.12
 * 11718 문자 그대로 출력하기
 * https://www.acmicpc.net/problem/11718
 * 오랜만에 다시 코틀린으로 알고리즘 공부를 시작하니 기본인 입력과 출력 해보았다. (1일 1알고리즘 꼭 하자!)
 * BufferedReader
 */
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sc = Scanner(System.`in`)

    do {
        val input = br.readLine()
        print("$input\n")
    } while(br.ready())

    while(sc.hasNext()) {
        val input = sc.nextLine()
        print("$input\n")
    }

}



