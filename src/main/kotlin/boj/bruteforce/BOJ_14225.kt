package boj.bruteforce

import java.util.*
import kotlin.system.exitProcess

/**
 * 2021.08.26
 * BOJ 14225 부분수열의 합
 * 수열이 주어졌을 때 부분 수열의 합으로 나올 수 없는 가장 작은 자연수를 구하는 문제
 * 입력이 뭐가 올지 모르고 수열의 크기가 20으로 작기 때문에 다 해볼 수 있다. 시간복잡도 O(N^2) 로 해결할 수 있다.
 * 나온적이 있는지 숫자인지 조회하는 구현을 Boolean 배열로 하면 더 빠르겠지만 코드의 단순화를 위해 Set 으로 했다.
 *
 *
 * 다른 사람의 풀이 (vega 님) 속도가 빠르다.
 * 재귀할 때 현재 인덱스의 다음 인덱스부터 for 문을 돌아서 모든 조합을 다해본다.
 *
 * 백준선생님의 풀이
 * 크기가 2^20 으로 백만 정도니까 다 해볼 수 있다.
 * 이 문제에서는 만들 수 있는지 없는지만 중요
 * 모든 수가 10만이고 20개 있을 수 있으니까 최대값은 200만 그러니 200만 boolean 배열을 만든다.
 * 이 문제도 포함하고 안하고로 풀 수 있다.
 * check 를 배열로 구현했는데 배열로 만들 수 없는 범위면 set 을 이용
 * 여기서는 모든 합 저장하고 오름차순 정렬 해서 d[0] != 1, d[i-1]+1 != d[i] 를 이용해서 d[i-1] 을 답으로 낼 수도 있다.
 */
class BOJ_14225 {
    var n: Int = 0
    lateinit var nums: List<Int>
    lateinit var check: MutableSet<Int>
    fun main() {
        initVariables()
        searchAllCase(0, 0)
        printMinOfNotInSet()
    }

    fun initVariables() {
        n = readLine()!!.toInt()
        nums = readLine()!!.split(" ").map { it.toInt() }
        check = mutableSetOf()
    }

    fun searchAllCase(depth: Int, sum: Int) {
        if (depth == n) {
            check.add(sum)
            return
        }
        searchAllCase(depth + 1, sum)
        searchAllCase(depth + 1, sum + nums[depth])
    }

    fun printMinOfNotInSet() {
        (1..(20 * 100000)).forEach {
            if (!check.contains(it)) {
                println(it)
                return@printMinOfNotInSet
            }
        }
    }

}

class BOJ_14225_Other {


    var v = IntArray(100001) {0}
    var arr = IntArray(2000001) {0}
    var n:Int = 0

    fun ans(idx:Int,sum:Int)
    {
        arr[sum] = 1
        for(i in idx..n-1)
            ans(i+1,sum+v[i])
    }
    fun main(args:Array<String>)
    {
        val sc: Scanner = Scanner(System.`in`)
        n = sc.nextInt()

        for(i in 0..n-1)
        {
            var a = sc.nextInt()
            v[i] = a
        }

        ans(0,0)
        for(i in 1..2000001)
        {
            if (arr[i] == 0)
            {
                print(i)
                exitProcess(0)
            }
        }

    }
}
