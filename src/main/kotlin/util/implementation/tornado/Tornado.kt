package util.implementation.tornado

/**
 * 정사각형 2차원 배열에 소용돌이 모양 그리기
 * direction 으로 방향 설정
 */
fun tornado(n: Int, direction: Boolean): Array<IntArray> {
    var answer: Array<IntArray> = Array(n) { IntArray(n) { 0 } }
    val half = if(n % 2 == 0) n / 2 else (n / 2) + 1
    var cnt = 1

    if (direction) {
        for (i in 0 until half) {
            for (j in 0 until (n - 1 - (i * 2))) {
                answer[i][i+j] = cnt
                answer[j+i][n-1-i] = cnt
                answer[n-1-i][n-1-i-j] = cnt
                answer[n-1-j-i][i] = cnt
                cnt += 1
            }
        }
    } else {
        for (i in 0 until half) {
            for (j in 0 until (n - 1 - (i * 2))) {
                answer[i+j][i] = cnt
                answer[n-1-i][i+j] = cnt
                answer[n-1-j-i][n-1-i] = cnt
                answer[i][n-1-i-j] = cnt
                cnt += 1
            }
        }
    }

    if (n % 2 != 0) answer[n/2][n/2] = cnt


    return answer
}