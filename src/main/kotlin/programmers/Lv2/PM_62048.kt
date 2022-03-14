package programmers.Lv2

/**
 * 멀쩡한 사각형 (수학)
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 * 나는 일차 방정식 그래프로 생각해서 계산해줬는데
 * 다른 사람의 풀이 보고 간단한 식으로도 풀 수 있다는 것을 알게 되었다.
 * 전체 (w*h) 에서 대각선으로 가로지르면 w 또는 h 이상은 무조건 지워지게 되는데
 * 일단 w, h 둘 다 빼서 지워진 칸에서, 중복으로 카운트된 것(gcd)을 다시 더해주면 답이된다.
 * 내 방법은 (1, 1억) 으로 입력이 들어오면 시간초과가 날 것이다.
 */
fun solution(w: Int, h: Int): Long {
    var wl = w.toLong()
    var hl = h.toLong()
    return wl*hl-wl-hl+gcd(w,h)
}


fun mySolution(w: Int, h: Int): Long {
    var answer: Long = 0

    val gcd = gcd(w, h)
    val x = w / gcd
    val y = h / gcd

    var cnt = 0L
    for (i in 1..y) {
        val blocks = ((x.toDouble()/y) * (y - i)).toLong()
        cnt = cnt + blocks
    }
    var deletedArea = (x.toLong() * y) - (cnt * 2)
    answer = (w.toLong() * h) - (deletedArea * gcd.toLong())


    return answer
}

fun gcd(a: Int, b: Int): Int {
    if (a % b == 0) return b else return gcd(b, a % b)
}