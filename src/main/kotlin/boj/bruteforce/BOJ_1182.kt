package boj.bruteforce


/**
 * 2021.08.26
 * BOJ 1182 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 * N 개의 정수로 이루어진 수열과 정수 S 가 주어졌을 때 정수배열에서 1개 이상을 뽑아서 합이 S 가 되는 부분수열의 개수를 구하는 문제
 * 어떤 수가 올지 모르고, 배열의 길이가 최대 20으로 주어졌으므로 다 해볼만 하다.
 * 크기가 자연수인 부분수열이므로 0 은 포함되면 안되므로 1부터 시작하고 n까지 뽑아봐야하므로
 * 부분수열의 크기 범위는 1..n 이다.
 * 1~n 개를 각각 모든 경우의 수로 뽑아서 합이 목표합과 같은지 비교해서 정답을 카운트한다.
 * 일반적인 재귀 조합방식으로 구현한다.
 * 이런식으로 할 필요가 없었다.
 *
 *
 * 참고로 primary type 에는 lateinit 이 먹히지 않는다.
 *
 * 선택하고 안하고로 풀 수도 있다. ( 다른 사람의 풀이 	thinkingdobby  님 )
 *
 * 백준선생님 풀이
 * 2^n-1 인데 n 이 최대 20 이므로 1048575 로 전부 해볼만하다.
 * 넣고 안넣고로 풀이
 * 모두 안넣은 경우는 제외
 * 중간에 합을 찾았다 해도 뒤에서 +3 -3 이런식으로 하나 더 나올 수 있으니 멈추면 안된다.
 * placeAll2 는 main 에 코드를 좀 더 추가해줘야한다. 하나도 포함안된 경우 합은 0 인데 크기가 양수인 부분수열이니까
 * goal 이 0 인 경우는 정답에서 1을 빼줘야한다.
 */
class BOJ_1182 {

    var n: Int = 0
    var goal: Int = 0
    var nums: List<Int> = listOf()
    var answer = 0

    fun main() {
        initVariables()
        placeAll(0, 0)
        //placeAll2(0, 0)
        //if (goal == 0) answer--
        print(answer)
    }

    fun initVariables() {
        readLine()!!.split(" ").apply {
            n = get(0).toInt()
            goal = get(1).toInt()
        }
        nums = readLine()!!.split(" ").map { it.toInt() }
    }

    fun placeAll(idx: Int, sum: Int) {
        if (idx != 0 && sum == goal) {
            answer++
        }
        for (i in idx until n) {
            placeAll(i + 1, sum + nums[i])
        }
    }

    fun placeAll2(idx: Int, sum: Int) {
        if (idx == n) {
            if (sum == goal) {
                answer++
            }
            return
        }
        placeAll2(idx + 1, sum + nums[idx])
        placeAll2(idx + 1, sum)
    }


//import java.io.*
//import java.util.*
//
//private var n = 0
//private var s = 0
//private var cnt = 0
//lateinit var arr: Array<Int>
//
//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
//
//    val st1 = StringTokenizer(br.readLine())
//    n = st1.nextToken().toInt()
//    s = st1.nextToken().toInt()
//
//    arr = Array(n){0}
//    val st2 = StringTokenizer(br.readLine())
//    for (i in 0 until n)
//        arr[i] = st2.nextToken().toInt()
//
//    func(0, 0)
//    if (s == 0) cnt--
//    bw.write("$cnt")
//    bw.flush()
//    bw.close()
//}
//
//fun func(now: Int, sum: Int) {
//    if (now == n) {
//        if (sum == s) cnt++
//        return
//    }
//    func(now + 1, sum)
//    func(now + 1, sum + arr[now])
//}
}
