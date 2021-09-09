package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


/**
 * 2021.08.28
 * BOJ 4574 스도미노쿠
 * https://www.acmicpc.net/problem/4574
 *
 * 문제 소개
 * 스도쿠랑 룰은 비슷한데, 1~9에서 두개뽑아서 나오는 모든 조합을 숫자 두개가진 블록으로 생각하고 배치해서, 문제를 풀어 출력하는 문제
 *
 * 나의 풀이 방식
 * 모든 놓는 방법 * (9*9-1) 의 경우의 수가 엄청 많을 거라 생각해서 시간복잡도를 줄이는 방법을 고민해봤지만..
 * 어떻게 해야할지 감이 잘 오지 않았다.
 *
 * 백준선생님 풀이 방식
 * 스도쿠 풀 때와 똑같이 check 배열을 만들어서 백트래킹 검사를 O(1) 로 처리할 수 있게 만든다.
 * 초기 좌표를 상단 좌측에서 우측 하단으로 한칸씩 이동하며 아래에 추가 한칸 또는 오른쪽에 추가 한칸 해서 놓아보면 모든 경우의 수를 다 해볼 수 있다.
 * 1. 정답을 찾은 경우 : cnt == 81
 * 2. 재귀 : 각 방향에 대해 범위 검사 통과하면 9*9 - 9 번 경우의 수를 모두 놓을 수 있는지 검사후에 재귀한다.
 *
 * 실수
 * 문제조건을 제대로 파악하지 못했다.
 * 도미노 타일이 갯수가 정해져있어서, 특정 도미노 타일을 썼는지 안썼는지도 체크해야한다.
 *
 */
private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private lateinit var board: Array<IntArray>
private lateinit var checkRow: Array<BooleanArray>
private lateinit var checkCol: Array<BooleanArray>
private lateinit var checkMatrix: Array<BooleanArray>
private lateinit var checkDominos: Array<BooleanArray>
private var caseCount: Int = 0


private fun main() {
    caseCount = 0
    while (true) {
        n = br.readLine().toInt()
        if (n == 0) break

        caseCount++
        board = Array(9) { IntArray(9) }
        checkRow = Array(9) { BooleanArray(10) }
        checkCol = Array(9) { BooleanArray(10) }
        checkMatrix = Array(9) { BooleanArray(10) }
        checkDominos = Array(10) { BooleanArray(10) }
        //printAnswer()
        initBoard()
        //printAnswer()
        makeAllCase(0)
    }
    bw.flush()
}

private fun initBoard() {
    repeat(n) {
        br.readLine().split(" ").apply {
            val num1 = get(0).toInt()
            val x1 = get(1).elementAt(0) - 'A'
            val y1 = get(1).elementAt(1) - '1'
            val num2 = get(2).toInt()
            val x2 = get(3).elementAt(0) - 'A'
            val y2 = get(3).elementAt(1) - '1'
            checkPlacing(x1, y1, num1, true)
            checkPlacing(x2, y2, num2, true)
            board[x1][y1] = num1
            board[x2][y2] = num2
            checkDominos[num1][num2] = true
            checkDominos[num2][num1] = true
        }
    }
    br.readLine().split(" ").forEachIndexed { index, position ->
        val x = position.elementAt(0) - 'A'
        val y = position.elementAt(1) - '1'
        val num = index + 1
        checkPlacing(x, y, num, true)
        board[x][y] = num
    }
}

private fun checkPlacing(x: Int, y: Int, num: Int, what: Boolean) {
    checkRow[x][num] = what
    checkCol[y][num] = what
    checkMatrix[mapToMatrixIndex(x, y)][num] = what
}

private fun mapToMatrixIndex(x: Int, y: Int): Int = (x / 3) * 3 + y / 3

private fun makeAllCase(cnt: Int): Boolean {
    if (cnt == 81) {
        printAnswer()
        return true
    }
    val x = cnt / 9
    val y = cnt % 9

    if (board[x][y] != 0) {
        if (makeAllCase(cnt + 1)) return true
    } else {
        val (nx1, ny1) = Pair(x + 1, y)
        val (nx2, ny2) = Pair(x, y + 1)

        for (i in 1..9) {
            for (j in 1..9) {
                if (i == j) continue
                if(checkDominos[i][j] || checkDominos[j][i]) continue


                if (isIn(nx1, ny1) && canPlace(x, y, i) && canPlace(nx1, ny1, j)) {
                    checkPlacing(x, y, i, true)
                    checkPlacing(nx1, ny1, j, true)
                    board[x][y] = i
                    board[nx1][ny1] = j
                    checkDominos[i][j] = true

                    if (makeAllCase(cnt + 1)) return true

                    checkPlacing(x, y, i, false)
                    checkPlacing(nx1, ny1, j, false)
                    board[x][y] = 0
                    board[nx1][ny1] = 0
                    checkDominos[i][j] = false
                }

                if (isIn(nx2, ny2) && canPlace(x, y, i) && canPlace(nx2, ny2, j)) {
                    checkPlacing(x, y, i, true)
                    checkPlacing(nx2, ny2, j, true)
                    board[x][y] = i
                    board[nx2][ny2] = j
                    checkDominos[i][j] = true

                    if (makeAllCase(cnt + 1)) return true

                    checkPlacing(x, y, i, false)
                    checkPlacing(nx2, ny2, j, false)
                    board[x][y] = 0
                    board[nx2][ny2] = 0
                    checkDominos[i][j] = false
                }

            }
        }
    }
    return false

}

private fun canPlace(x: Int, y: Int, num: Int): Boolean {
    return board[x][y] == 0 && !checkRow[x][num] && !checkCol[y][num] && !checkMatrix[mapToMatrixIndex(x, y)][num]
}


private fun isIn(x: Int, y: Int): Boolean =
    (x in 0 until 9) && (y in 0 until 9)

private fun printAnswer() {
    bw.write("Puzzle $caseCount\n")
    board.forEach { it ->
        bw.write(it.joinToString("") { "$it" } + "\n")
    }
}


