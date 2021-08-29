package boj.bruteforce

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class BOJ_16197_HARD {

    /**
     * 2021.08.28
     * BOJ 16197 두 동전
     * https://www.acmicpc.net/problem/16197
     *
     * 문제 소개
     * 빈칸, 벽, 동전위치가 주어진 n*m 2차원 배열이 주어지면
     * 동서남북 네 방향으로만 동시에 이동시켜 두 동전 중 하나만 떨어뜨릴 수 있는 최소 이동 횟수를 구하는 문제
     *
     * 풀이 방법
     * 처음엔 bfs 문제라고 생각했다.
     * 하지만 두개를 동시에 고려하기엔 bfs 로 구현하기 까다롭다고 느껴졌다.
     * 다해보는 방법이 있다.
     * 어차피 버튼누르기를 10번을 초과하면 답이 없다고 판정하라고 했기 때문에
     * 모든 경우의 수는 4^10 즉 2^20 으로 약 백만 정도면 다 해볼 수 있다.
     *
     * 실수
     * 1. directions 를 초기화할 때 방향 상수를 잘못적어서 시간을 낭비했다.
     * 다음부터는 프린트 디버깅할 때 이런 기본적인 상수입력에서 실수는 없었는지 다시 체크해본다.
     * 2. 현재 재귀상태에서 재귀하기 전에 다음 재귀상태를 미리 보는 방식을 채택했는데 탈출조건에는 -1 을 하지 않았다.
     * 즉 cnt == 10 이라고 해야하는데 cnt == 11 로 풀어서 계속 틀렸다.
     *
     *
     * 백준선생님 풀이
     * 각 시도마다 4가지 시도를 할 수 있고 최대 10번 시도하니
     * 4^10 == 2^20 == 약 백만
     * 매 시도마다 동전의 위치만 변하니 보드 초기화 이후에는 보드상태는 동전의 위치로 정의할 수 있다.
     * 그래서 초기 동전도 보드상으로는 빈칸으로 처리해주는 것이 맞다.
     * 일단 이동하고 범위검사를 해줄 것이다.
     * 그 이유는 문제에서 이동하려는 칸이 없으면 장외라고 했기 때문에 일단 이동은 할 수 있다는 말이기 때문이다.
     * 1. 정답을 찾은 경우 : 하나만 장외
     * 2. 불가능한 경우 : 둘 다 장외인 경우, 시도가 10회 초과한 경우
     * 3. 다음 경우 : 1, 2 를 통과하고 다음 좌표가 범위안에 있는데 벽인경우 다시 원래좌표로 재귀
     *
     * 다른 사람 코드는 njh21598 님의 코드
     * typealias 로 코드 잘 읽힌다.
     * bfs 로도도풀 수 있구나
     *
     *
     *
     */
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n: Int = 0
    var m: Int = 0
    lateinit var board: Array<IntArray>
    lateinit var firstCoinPosition: Array<Pair<Int, Int>>
    var answer = 0
    val directions = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

    fun main() {
        initVariables()
        placeAllCase(0, firstCoinPosition[0], firstCoinPosition[1])
        printAnswer()
    }

    fun initVariables() {
        br.readLine()!!.split(" ").apply {
            n = this[0].toInt()
            m = this[1].toInt()
        }
        board = Array(n) { IntArray(m) }
        firstCoinPosition = Array(2) { Pair(0, 0) }
        answer = Int.MAX_VALUE
        var coinIdx = 0
        for (i in 0 until n) {
            br.readLine().forEachIndexed { j, c ->
                board[i][j] = when (c) {
                    '.' -> {
                        1
                    }
                    'o' -> {
                        firstCoinPosition[coinIdx++] = Pair(i, j)
                        1
                    }
                    '#' -> {
                        -1
                    }
                    else -> Int.MAX_VALUE
                }
            }
        }
        br.close()
    }


    fun isIn(pair: Pair<Int, Int>): Boolean = (pair.first in 0 until n) && (pair.second in 0 until m)
    fun isOpened(pair: Pair<Int, Int>): Boolean = board[pair.first][pair.second] != -1


    fun placeAllCase(cnt: Int, pos1: Pair<Int, Int>, pos2: Pair<Int, Int>) {
        if (cnt == 10) // 여기서 10번째에 들어왔다면 정답을 낼 때 11이 나올 수도 있으므로 cnt == 10 이면 리턴해야한다. 9번째 시도할 때 10번째것을 미리 보고 답을 내는 방식이라 그렇다.
            return

        for (i in 0 until 4) {
            var nextPos1 = Pair(pos1.first + directions[i].first, pos1.second + directions[i].second)
            var nextPos2 = Pair(pos2.first + directions[i].first, pos2.second + directions[i].second)

            if ((isIn(nextPos1) && !isIn(nextPos2)) || (!isIn(nextPos1) && isIn(nextPos2))) {
                answer = Math.min(answer, cnt + 1)
                return
            }
            // 여기부터는 하나만 장외인 경우는 없다.
            // 둘 다 장외거나 둘 다 장외는 아닌 것이다.

            if ((!isIn(nextPos1) && !isIn(nextPos2)) || (!isOpened(nextPos1) && !isOpened(nextPos2)))
                continue
            // 여기부터는 장외인 경우가 없고, 둘 다 막힌 경우도 없다.
            // 그래서 각각 벽 검사하고 재귀해본다.

            if (!isOpened(nextPos1)) {
                nextPos1 = pos1
            }
            if (!isOpened(nextPos2)) {
                nextPos2 = pos2
            }
            placeAllCase(cnt + 1, nextPos1, nextPos2)


        }
    }

    fun printAnswer() {
        answer = if (answer == Int.MAX_VALUE) -1  else answer
        bw.write(answer.toString())
        bw.flush()
        bw.close()
    }
}


typealias Coin = Pair<Int, Int>
typealias Coins = Pair<Coin, Coin>
class BOJ_16197_HARD_OTHER {
    private val dx = intArrayOf(0, 1, 0, -1)
    private val dy = intArrayOf(1, 0, -1, 0)
    private var n = 0
    private var m = 0
    private lateinit var arr: Array<CharArray>

    operator fun Coin.compareTo(oth: Coin): Int {
        val value = this.first.compareTo(oth.first)
        return if (value == 0) return this.second.compareTo(oth.second) else value
    }

    fun main() {
        val nums = readLine()!!.trim().split(" ").map { it.toInt() }
        n = nums[0]
        m = nums[1]
        arr = Array(n) { readLine()!!.trim().toCharArray() }
        println(bfs())
    }

    private fun bfs(): Int {
        val coins = Coins(findFirstCoin(), findSecondCoin())
        val queue = ArrayDeque<Pair<Coins, Int>>()
        queue.add(Pair(coins, 0))
        val visit = mutableSetOf<Coins>()
        visit.add(coins)
        while (!queue.isEmpty()) {
            val (cc, cd) = queue.removeFirst()
            val (cx1, cy1) = cc.first
            val (cx2, cy2) = cc.second
            if (cd >= 10) break
            for (i in 0..3) {
                var nc1 = Coin(cx1 + dx[i], cy1 + dy[i])
                var nc2 = Coin(cx2 + dx[i], cy2 + dy[i])
                val isIn1 = isIn(nc1.first, nc1.second)
                val isIn2 = isIn(nc2.first, nc2.second)
                if (!isIn1 && !isIn2) continue
                if ((isIn1 && !isIn2) || (!isIn1 && isIn2)) return cd + 1
                if (arr[nc1.first][nc1.second] == '#') nc1 = cc.first
                if (arr[nc2.first][nc2.second] == '#') nc2 = cc.second
                val nc = if (nc1 < nc2) {
                    Coins(nc1, nc2)
                } else {
                    Coins(nc2, nc1)
                }
                if (visit.contains(nc)) continue
                visit.add(nc)
                queue.add(Pair(nc, cd + 1))
            }
        }
        return -1
    }

    private fun findFirstCoin(): Coin {
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] == 'o') {
                    return Coin(i, j)
                }
            }
        }
        return Coin(-1, -1)
    }

    private fun findSecondCoin(): Coin {
        for (i in arr.indices.reversed()) {
            for (j in arr[i].indices.reversed()) {
                if (arr[i][j] == 'o') {
                    return Coin(i, j)
                }
            }
        }
        return Coin(-1, -1)
    }

    private fun isIn(x: Int, y: Int): Boolean {
        return (x in 0 until n) && (y in 0 until m)
    }


}

