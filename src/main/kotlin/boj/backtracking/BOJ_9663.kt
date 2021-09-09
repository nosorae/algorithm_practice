package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 2021.08.28
 * BOJ 9663 N-Queen
 * https://www.acmicpc.net/problem/9663
 *
 * 문제 소개
 * N*N 2차원 보드에 퀸 N 개가 서로 죽는 위험 없이 놓게 하는 방법의 수를 구하는 문제
 *
 * 풀이 방식
 * 같은 행이나 열은 어차피 놓을 수 없으니 각 행마다 어느 열에 넣을 지 모두 시도해보며 재귀한다.
 * 그리고 체크배열을 둬서 열이 겹치거나 대각선상에 놓인 퀸이 있는지 검사해서 가지치기 한다.
 * 1. 정답이 되는 경우 : cnt == N 즉, 모든 열을 검사해서 문제가 없었을 때 -> 카운트
 * 2. 정답이 될 수 없는 경우 (가지치기) : 같은 열이나 대각선으로 겹치는 퀸이 있으면 -> 다음 열 시도
 * 3. 재귀 : 모든 열에대해 시도
 *
 *
 * 백준선생님 풀이
 * N! 지만 중간에 안하는 시도 덕분에 괜찮다.
 * 그런데 같은 열이나 대각선을 겹치는 퀸이 있는지 검사하는 부분을 O(N) 이 아닌 O(1) 로도 처리할 수 있다.
 * 열 check 는 쉽게 다가오지만 대각선은 바로 이해되지 않을 수 있다.
 * 표를 그려 행과 열을 더해보면 대각선으로 같은 숫자를 갖게 됨을 알 수 있다.
 * 이를 1차원 Boolean 배열로 쓰는 것이다.
 * 대각선이 두 방향이 있다는 것에 주의한다.
 * 그래서 check 배열은 총 세개가 되는 것이다.
 * 재귀 준비 - 재귀 - 복원
 *
 */
private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private lateinit var checkCols: BooleanArray
private lateinit var checkDiagonalLeft: BooleanArray
private lateinit var checkDiagonalRight: BooleanArray
private var answer = 0

private fun main() {
    initVariables()
    placeAllCase(0)
    printAnswer()
}
private fun initVariables() {
    n = br.readLine().toInt()
    checkCols = BooleanArray(n)
    checkDiagonalLeft = BooleanArray(n*2) { false }
    checkDiagonalRight = BooleanArray(n*2) { false }
    answer = 0
    br.close()
}
private fun placeAllCase(row: Int) {
    if (row == n) {
        answer++
        return
    }
    for(col in 0 until n) {
        if (canPlace(row, col)) {
            checkThisPosition(row, col, true)
            placeAllCase(row + 1)
            checkThisPosition(row, col, false)
        }
    }

}
private fun canPlace(x: Int, y: Int) = !checkCols[y] && !checkDiagonalLeft[n-(y-x)-1] && !checkDiagonalRight[x+y]

private fun checkThisPosition(x: Int, y: Int, what: Boolean) {
    checkCols[y] = what
    checkDiagonalLeft[n-(y-x)-1] = what
    checkDiagonalRight[x+y] = what
}

private fun printAnswer() {
    bw.write(answer.toString())
    bw.flush()
    bw.close()
}
