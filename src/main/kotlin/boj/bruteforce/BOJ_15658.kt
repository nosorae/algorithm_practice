package boj.bruteforce

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class BOJ_15658 {
    /**
     * 2021.08.26
     * BOJ 15658 연산자 끼워넣기 ( 2 )
     * https://www.acmicpc.net/problem/15658
     *
     * 문제 소개
     * 연산자 끼워넣기 문제와 같은 조건이지만 이번엔 연산자 갯수 총합이 n-1 을 넘을 수 있다.
     * 즉 연산자를 다 사용하지 않고도 결과 (min, max) 를 갱신할 수 있다.
     *
     * 백준선생님 풀이
     *
     */

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n: Int = 0
    lateinit var nums: IntArray
    lateinit var opCnt: IntArray
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    fun main() {
        initVariables()
        placeAllCase(0, nums[0])
        printAnswer()
    }

    fun initVariables() {
        n = br.readLine().toInt()
        nums = IntArray(n)
        opCnt = IntArray(4)
        StringTokenizer(br.readLine()).iterator().withIndex().forEach {
            nums[it.index] = it.value.toString().toInt()
        }
        StringTokenizer(br.readLine()).iterator().withIndex().forEach {
            opCnt[it.index] = it.value.toString().toInt()
        }
    }

    fun placeAllCase(cnt: Int, calculatedValue: Int) {
        if (cnt == n - 1) {
            max = Math.max(max, calculatedValue)
            min = Math.min(min, calculatedValue)
            return
        }
        for (opIdx in 0 until 4) {
            if (opCnt[opIdx] > 0) {
                opCnt[opIdx]--
                placeAllCase(cnt + 1, calculate(calculatedValue, nums[cnt + 1], opIdx))
                opCnt[opIdx]++
            }
        }

    }

    fun calculate(operand1: Int, operand2: Int, operatorIdx: Int): Int =
        when(operatorIdx) {
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