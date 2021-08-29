package boj.backtracking

import java.io.*


/**
 * 2021.08.28
 * BOJ 2580 스도쿠
 * https://www.acmicpc.net/problem/2580
 *
 * 문제 소개
 * 스도쿠 문제 (빈칸은 0) 가 주어졌을 때 그대로 정답 넣어서 출력하는 문제
 *
 * 내 풀이 방법
 * 빈칸 좌표 리스트를 만들고 모든 경우의 수(1~9)를 다 시도해보려고 한다.
 * 종료조건 : cnt == 좌표리스트 사이즈
 * 세가지를 검사해야한다.
 * 1. 3*3 안에서
 * 2. 가로에서
 * 3. 세로에서
 * 쓰고
 * 이를 만족하면 다음 빈칸 좌표와 함께 재귀한다.
 * 복원
 *
 * 백준선생님 풀이
 * 원래 경우의 수가 너무 많아서 백트래킹으로 풀 수 없는데,
 * 이 문제에서는 백트래킹으로 풀 수 있는 입력만 주어진다고 해서 풀 수 있다.
 * N Queen 에서 검사를 O(1) 로 효율적이게 했던 것처럼 이 문제에서도 check 를 효율적으로 할 수 있다.
 * 2차원 배열을 열 행 3*3 각각의 check 배열로 만든다.
 * i 번째에 숫자 j (0~9) 가 있으면 true
 * 1. 정답인 경우 : cnt == 81
 * 2. 다음 경우 : 일단 빈칸이 아닌 경우 그냥 다음칸으로 재귀,
 * 빈칸인 경우 1~9 에 대하여 check 배열 통과한 경우 재귀할 것이다. 못하면 continue
 *
 * 교훈
 * 나는 빈칸 좌표 리스트를 만들어서 순회하며 시도해보려고 했는데
 * 그냥 이차원배열을 일차원화해서 이미 숫자가 써있으면 넘어가고 빈칸만 처리하며 81까지 재귀하는 방식이
 * 메모리와 코드면에서 더 깔끔한 것 같다.
 * 복원을 제대로 하지 않아서 시간을 낭비하였다. 준비 - 재귀 - 복원 프로세스는 생각했는데
 * 배열을 다시 0으로 만들어주는 작업을 빼먹었었다.
 *
 */
private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val board = Array(9) { IntArray(9) }
private val size = 9
private val checkRow = Array(9) { BooleanArray(10) }
private val checkCol = Array(9) { BooleanArray(10) }
private val checkMatrix = Array(9) { BooleanArray(10) }

private fun main() {
    initVariables()
    placeAllNums(0)
}

private fun initVariables() {
    for (i in 0 until 9) {
        br.readLine().split(" ").forEachIndexed { j, num ->
            checkForPlace(i, j, num.toInt(), true)
        }
    }

}

private fun mapToMatrixIndex(x: Int, y: Int): Int = ((x/3)*3) + (y/3)

private fun checkForPlace(x: Int, y: Int, num: Int, what: Boolean) {
    checkRow[x][num] = what
    checkCol[y][num] = what
    checkMatrix[mapToMatrixIndex(x, y)][num] = what
    board[x][y] = num
}

private fun placeAllNums(cnt: Int): Boolean {
    if (cnt == 81) {
        printAnswer()
        return true
    }
    val x = cnt / 9
    val y = cnt % 9
    if (board[x][y] != 0) {
        if (placeAllNums(cnt+1)) return true
    } else {
        for (num in 1..9) {
            if (canPlace(x, y, num)) {
                checkForPlace(x, y, num, true)
                if (placeAllNums(cnt + 1)) return true
                checkForPlace(x, y, num, false)
                board[x][y] = 0
            }
        }
    }
    return false

}
private fun canPlace(x: Int, y: Int, num: Int): Boolean =
    !checkRow[x][num] && !checkCol[y][num] && !checkMatrix[mapToMatrixIndex(x, y)][num]

private fun printAnswer() {
    board.forEachIndexed { i, arr ->
        bw.write(arr.joinToString(" ") { "$it" } + "\n")
    }
    bw.flush()
    bw.close()
}


