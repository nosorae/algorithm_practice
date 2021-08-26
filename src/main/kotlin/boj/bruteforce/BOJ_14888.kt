package boj.bruteforce

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class BOJ_14888 {

    /**
     * 2021.08.26
     * BOJ 14888 연산자 끼워넣기
     * https://www.acmicpc.net/problem/14888
     *
     * 문제 소개
     * 수열과 + - * / 각각의 연산자의 개수가 주어졌을 때,
     * 수열 사이사이에 연산자 하나씩 끼워서 만들 수 있는 결과의 최대 최소를 구하는 문제이다.
     * 연산자 우선순위 무시하고 왼쪽에서 오른쪽 방향으로 계산한다.
     * 나눗셈은 몫만 취하고 음수/양수는 -(-음수/양수) 이다.
     *
     * 풀이 방식
     * 4^10 로 2^20 로 모든 경우를 다 시도해볼 만하다.
     * 이미 사용한 연산자의 갯수를 저장하는 배열을 연산자를 더 쓸 수 있는지 check 하는 기능으로 사용한다.
     * 재귀함수를 이용하여 연산자 n-1 개를 계산하면 뽑아본다. 그리고 다 뽑으면 계산결과로  min max 를 갱신하고 return 한다.
     *
     * 함수 정리
     * initVariables : 입력 및 변수 초기화
     * placeAll : 재귀를 통해 연산자를 n-1 개 놓아본다. cnt, calculatedValue
     *
     * 백준선생님 풀이
     * 이 문제에서 만들어 보는 것은 바뀌는 것은 연산자의 배열이다.
     * 실제 경우의 수는 2^20 보다 훨신 작다.
     * 연산자 자리가 총 n 개이고 각각 a b c d 개 왔다 하면
     * nCa * n-aCb * n-a-bCc * n-a-b-cCd 가지 경우가 있을 것이다.
     * 연산자 우선순위를 무시할 수 있으니 재귀함수에 인자로 누적해서 계산할 수 있다.
     * Pair<Int,Int> 로 min max 를 함께 관리하고 재귀함수의 리턴으로 사용한다.
     * 4가지 연산자 경우로 재귀하고 최대 4개의 Pair 에서 각각 min max 를 구해 리턴한다.
     *
     */
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n : Int = 0
    lateinit var nums: IntArray
    lateinit var opNums: IntArray
    lateinit var opCnt: IntArray
    var min: Int = 0
    var max: Int = 0

    fun main() {
        initVariables()
        placeAll(0, nums[0])
        printAnswer()
    }

    fun initVariables() {

        opNums  = IntArray(4) { 0 }
        opCnt = IntArray(4) { 0 }
        min = Int.MAX_VALUE
        max = Int.MIN_VALUE

        n = br.readLine()!!.toInt()
        nums = IntArray(n)
        StringTokenizer(br.readLine()).iterator().withIndex().forEach {
            nums[it.index] = it.value.toString().toInt()
        }

        StringTokenizer(br.readLine()).iterator().withIndex().forEach {
            opNums[it.index] = it.value.toString().toInt()
        }

        br.close()
    }

    fun placeAll(cnt: Int, calculatedValue: Int) {
        if (cnt == n - 1) {
            max = Math.max(max, calculatedValue)
            min = Math.min(min, calculatedValue)
            return
        }

        (0 until 4).forEach { opIdx ->
            if (opCnt[opIdx] < opNums[opIdx]) {
                opCnt[opIdx]++
                placeAll(cnt + 1, calculate(calculatedValue, nums[cnt+1], opIdx))
                opCnt[opIdx]--
            }
        }
    }

    fun calculate(operand1: Int, operand2: Int, operator: Int): Int =
        when(operator) {
            0 -> operand1 + operand2
            1 -> operand1 - operand2
            2 -> operand1 * operand2
            3 -> operand1 / operand2
            else -> 0
        }

    fun printAnswer() {
        bw.write("$max\n$min")
        bw.flush()
        bw.close()
    }

}