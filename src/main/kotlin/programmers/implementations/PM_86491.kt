package programmers.implementations

class PM_86491 {
}

/**
 * 최소직사각형
 * LV.1
 * https://programmers.co.kr/learn/courses/30/lessons/86491
 * 간단한 문제인데 괜히 해멨다.
 * 눕히는 행위를 얼마나 효율적으로 수행할 것인가가 주요 문제인데
 * 두 페어중에 작은 것과 큰것을 비교해서 작은 것들 중에서 가장 큰 것
 * 큰 것들 중에서 가장 큰 것 두 개 곱하면 끝나는 문제였다.
 * 왜냐하면 (작은, 큰)구역 각각에서 가장 크면 나머지는 다 들어갈 것이기 때문이다.
 */
fun solution(sizes: Array<IntArray>): Int {
    var a = 0
    var b = 0

    for (array in sizes) {
        array.sort()
        if (array.isNotEmpty()) {
            a = array.first().coerceAtLeast(a)
            b = array.last().coerceAtLeast(b)
        }
    }
    return a * b
}

fun mySolution(sizes: Array<IntArray>): Int {
    var answer: Int = 0
    var max = 0
    for (i in sizes.indices) {
        if (max < sizes[i][0]) max = sizes[i][0]
        if (max < sizes[i][1]) max = sizes[i][1]
    }

    for (i in 0..1000) {
        var ok = true
        sizes.forEach {
            if ((it[0] > max || it[1] > i) && (it[1] > max || it[0] > i)) ok = false
        }
        if (ok) {
            answer = max * i
            break
        }
    }

    return answer
}