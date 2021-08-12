package implementations

/**
 * 2021.08.12
 * Level1. 제일 작은 수 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12935
 * IntArray 에 주어지는 수가 중복이 없다는 점이 중요한 조건이다.
 * reduce 로 최소값을 찾고 remove 로 그 값을 지우고 toIntArray 로 변환하여 리턴했다.
 *
 * 다른 사람의 풀이 (Ayteneve) 가 훨신 간소했다.
 * min 함수를 활용하면 코드가 더 간소화된다.
 */
class MyRemoveMinNumber {
    fun solution(arr: IntArray): IntArray {
        val list = arr.toMutableList()
        if (list.size == 1) {
            return intArrayOf(-1)
        } else {
            val min = list.reduce { min, cur ->
                if (min > cur) {
                    cur
                } else {
                    min
                }
            }
            list.remove(min)
            return list.toIntArray()
        }
    }
}

class RemoveMinNumber {
    fun solution(arr: IntArray): IntArray = if(arr.size == 1) arrayOf(-1).toIntArray()
    else arr.filter { it != arr.minOrNull() }.toIntArray()
}
