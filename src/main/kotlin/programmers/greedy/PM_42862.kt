package programmers.greedy

/**
 * ⭐️⭐⭐
 * 23.11.26
 * Lv1. 체육복
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * 한방향으로, 예를 들어 앞에 사람에게 먼저 빌리기 시도한다면 최적해가 나올 것이다.
 * 전체 번호에 대해서 시도할 필요도 없이 lost나 reserve 입장에서 각 원소에 대해서 진행해도 되겠다.
 *
 * 아직 이해되지 않은 문제
 * 왜 정렬을 해야지만 통과되지? -> 일관된 적용이 필요하기 때문 reserve에서 마구잡이로 뽑아서 왼쪽/오른쪽부터 확인하는 방식이면 반대편 끝자락에 O X 있는 경우 X가 받을 수 있음에도 받지 못하는 경우 발생
 * 왜 + 1 부터 따지면 틀리지? 왜 -1 부터 따져야 통과되지? -> 이건 좀 알겠음 정렬해서 오른쪽으로 가는데, 오른쪽부터 따지면 소외된 받을 수 있는데 못받는 lost학생이 발생할 수 있음
 *
 * 그리디는 "일관된" 부분해가 중요한 듯 하다.
 * 맨 처음 답이 틀린 이유는 reserveSet 대신 reserve를 사용했기 때문으로 보인다... sorting할 필요도 없이 더 낮은 시간복잡도로 정답으로 갈 수 있는 길이었다.
 *
 */
class Solution42862 {
    fun wrongSolution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var lostSet = (lost.toSet() - reserve.toSet()).toMutableSet()
        var reserveSet = (reserve.toSet() - lost.toSet()).toMutableSet()

        for (id in 0..n) {
            if (lostSet.contains(id)) {
                if (reserveSet.contains(id - 1)) {
                    reserveSet.remove(id - 1)
                    lostSet.remove(id)
                } else if (reserve.contains(id + 1)) {
                    reserveSet.remove(id + 1)
                    lostSet.remove(id)
                }
            }
        }
        return n - lostSet.size
    }

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var lostSet = (lost.toSet() - reserve.toSet()).toMutableSet()
        var reserveSet = (reserve.toSet() - lost.toSet()).toMutableSet()

        for (id in 0..n) {
            if (lostSet.contains(id)) {
                if (reserveSet.contains(id - 1)) {
                    reserveSet.remove(id - 1)
                    lostSet.remove(id)
                } else if (reserveSet.contains(id + 1)) {
                    reserveSet.remove(id + 1)
                    lostSet.remove(id)
                }
            }
        }
        return n - lostSet.size
    }

    fun solution2(n: Int, lost: IntArray, reserve: IntArray): Int {
        setOf(1, 2)
        val lostSet = (lost.toSet() - reserve.toSet()).sorted().toMutableSet() // 정렬 안하면
        val reserveSet = (reserve.toSet() - lost.toSet()).sorted().toMutableSet()

        reserveSet.forEach { reserver ->
            if (lostSet.contains(reserver - 1)) { // +부터 따지면 틀린다.
                lostSet.remove(reserver - 1)
            } else if (lostSet.contains(reserver + 1)) {
                lostSet.remove(reserver + 1)
            }
        }
        return n - lostSet.size
    }

}