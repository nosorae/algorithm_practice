package boj.bruteforce

import java.io.*

class BOJ_16198 {

    /**
     * 2021.08.28
     * BOJ 16198 에너지 모으기
     * https://www.acmicpc.net/problem/16198
     *
     * 문제 소개
     * 구슬 N 개 주어지고 각각 무게가 주어짐4
     * 에너지 얻는 법은
     * 1. 첫 끝 제외한 구슬을 하나 고르고
     * 2. 고른 구슬 양쪽에 있는 구슬의 무게를 곱한만큼 에너지를 얻게 됨
     * 3. N 을 1 감소시키고 구슬번호 다시매기고 반복
     * 얻을 수 있는 최대 에너지를 구하시오.
     *
     * 풀이 방법
     * 그리디인지 부르트포스인지 헷갈린다.
     * 일단 N 제한이 10이라서 약 8! (?) 이면 다 해볼만하다고 생각했다.
     * 재귀할 때마다 인자로 리스트를 새로 만들어서 전달하려 하니 메모리 괜찮을까? 살짝 걱정된다.
     * 1. 종료 조건 : list 의 size 가 2가 되는 순간 최대값 갱신
     * 2. 불가능 : 없음
     * 2. 재귀 o : 1~size-1 범위에 있는 모든 자연수 각각에 대해서 제거 시도
     * 3. 재귀 x : x
     *
     *
     *
     * 백준선생님 풀이
     * 입력에 따라 정답을 알수 없고 N 제한이 10이므로 브루트포스로 풀어봐야겠다.
     * (N-2)!, 최대 8! 40320
     * 1. 정답을 찾은 경우 (정답 갱신) : 리스트 크기가 2일 때
     * 2. 정답 찾은 경우 이전까지에서 불가능한 경우 : 없다.
     * 3. 다음 경우 호출 : 리스트 새로 만들어서 재귀
     * 리스트를 새로 만들어서 재귀하면 다음 재귀를 위해 다시 복원할 필요가 없어서 코드작성하기 편하다.
     *
     * 당연히 메모리도 속도도 진짜 넣었다가 빼는 게 더 빠르다.
     *
     *
     */
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n = 0
    lateinit var nums: MutableList<Int>
    var answer = 0

    fun main() {
        initVariables()
        makeAllCase(0, nums)
        printAnswer()
    }

    fun initVariables() {
        n = br.readLine().toInt()
        nums = mutableListOf()
        br.readLine().split(" ").map { nums.add(it.toInt()) }
        answer = 0
        br.close()
    }

    fun makeAllCase(localAnswer: Int, localNums: MutableList<Int>) {
        val size = localNums.size
        if (size == 2) {
            answer = Math.max(answer, localAnswer)
            return
        }
        for (i in 1 until size - 1) {
            val nextValue = localAnswer + (localNums[i - 1] * localNums[i + 1])
            val nextNums = mutableListOf<Int>().apply {
                addAll(localNums)
                removeAt(i)
            }
            makeAllCase(nextValue, nextNums)
        }
    }

    fun printAnswer() {
        bw.write(answer.toString())
        bw.flush()
        bw.close()
    }


}