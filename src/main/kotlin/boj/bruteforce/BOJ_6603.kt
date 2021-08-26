package boj.bruteforce

import java.util.*

/**
 * 2021.08.26
 * BOJ 6603 로또
 * 모든 조합을 사전순으로 출력하는 문제
 * let 안에서 break 쓰면 안된다. 반복문 바로 안에서 쓰는 것이다.
 *
 * 백선생님 풀이 (placeAll2)
 * 2^12 == 4096 이므로 다 해볼 수 있다.
 * index 와 cnt 필요
 * 정답을 찾은 경우, 불가능한 경우를 찾는 게 브루트포스의 기본이다.
 * cnt == 6 이 정답인 경우이고, index == n 인 것이 탈출조건이다. 재귀는 선택하고 안하고 두 가지이다.
 * 포함하는 것을 먼저해야 사전순이라는 조건을 만족한다.
 *
 */
class BOJ_6603 {
    lateinit var nums: List<Int>
    fun main() {
        while (true) {
            readLine()?.let {
                if (it == "0") { return }
                nums = it.split(" ").map { it.toInt() }
                nums = nums.subList(1, nums.size)
                //placeAll(nums, 0, mutableListOf<Int>())
                placeAll2(0, 0, "")
                println()
            }
        }


    }

    fun placeAll(input: List<Int>, idx: Int, answer: MutableList<Int>) {
        if (answer.size == 6) {
            println(answer.joinToString(" ") { "$it" })
            return
        }
        for (i in idx until input.size) {
            answer.add(input[i])
            placeAll(input, i + 1, answer)
            answer.removeLast()
        }
    }
    fun placeAll2(idx: Int, cnt:Int, ans: String) {
        if (cnt == 6) {
            println(ans)
            return
        }
        if (idx == nums.size) { return }
        placeAll2(idx + 1, cnt + 1, "$ans${nums[idx]} ")

        placeAll2(idx + 1, cnt, ans)
    }

}
fun main() {
    BOJ_6603().main()
}

