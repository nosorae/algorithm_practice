package boj.sort

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.Comparator


/**
 * 2022.02.13
 * 단어 정렬
 * https://www.acmicpc.net/problem/1181
 * 코틀린에서 정렬문제를 풀어보자는 취지
 * MutableList 기준으로 sort 는 자신의 아이템들을 정렬하고, sorted 는 정렬된 새 리스트를 반환해준다.
 * 그리고 sortedWith 는 Comparator 를 인자로 받는다. object : 로 작성해도 되겠지만
 * 더욱 코틀린스럽게 Single Abstract Method (SAM) interface 라는 점을 생각해서 람다로 뺐다.
 * https://kotlinlang.org/docs/fun-interfaces.html#sam-conversions
 * 마지막으로 중복을 제거하기 위해 toSet 을 사용하였다.
 * Iterable.toSet 은 The returned set preserves the element iteration order of the original collection. 이다.
 */
val br = BufferedReader(InputStreamReader(System.`in`))
fun main(args: Array<String>) {
    val n = br.readLine().toInt()

    val a = (0..1)
    (0 until n)
        .map {
            br.readLine()
        }
        .sortedWith { o1, o2 ->
            if (o1.length > o2.length) {
                1
            } else if (o1.length < o2.length) {
                -1
            } else {
                o1.compareTo(o2)
            }
        }
        .toSet()
        .forEach { str ->
            print("$str\n")
        }
}
