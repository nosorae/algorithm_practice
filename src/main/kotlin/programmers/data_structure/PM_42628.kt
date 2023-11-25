package programmers.data_structure

import java.util.Comparator
import java.util.PriorityQueue

/**
 * 23.11.25
 * Lv3. 이중우선순위큐
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * 주어진 I, D 연산 이후 남은 값 최대 최소를 IntArray로 리턴하는 문제
 * 일단 우선순위 큐로 최대, 최소를 동시에 관리할 순 없으니 -> PriorityQueue 를 두 개 만들어야겠다.
 * 마지막에 최대 최소값을 빼오는 건? -> 두  PriorityQueue 각각에서 하나씩 가져오면 된다.
 * 주의할 점은 비었을 경우이다. 비었을 경우에 대한 처리가 필요하다.
 * 그리고 시간복잡도도 주의해야함 입력 수가 100만까지 나올 수 있으므로 O(N^2) 미만으로 처리해야함
 * 두 개로 나뉜 것을 하나로 관리도 해야하는데 이건 어쩔거? -> Mpa<Int, Int> 으로 관리? 인덱스 숫자가 21억까지 커야하니 Map사용
 * 문제는 결국 두 PriorityQueue를 동일하게 관리해야할 것 같은데,.
 *
 * 다른 사람의 풀이 보니
 * 두 PriorityQueue를 하나로 관리하기 위해 Map을 쓰지 않고 다른 PriorityQueue에서도 삭제하는 방식으로 구현해도 실행시간에 큰 차이가 없다.. (1ms차이정도?)
 * 나는 PriorityQueue 의 remove가 O(N)이라고 생각해서 Map으로 관리한 건데.. 뭔가 속은 느낌
 * 근데 생각해보니 Map으로 관리해도 내부 while문도 O(N)이라 결국 O(N^2)이네..ㅋㅋ
 *
 * 예측성으로 시간복잡도를 계산하지 말고 코틀린 라이브러리를 적극적으로 활용하자!
 */
class Solution42628 {
    fun solution(operations: Array<String>): IntArray {
        val minPq = PriorityQueue<Int>()
        val maxPq = PriorityQueue<Int>(Comparator.reverseOrder())
        val map = mutableMapOf<Int, Int>()

        operations.forEach { input ->
            val splitedList = input.split(" ")
            val operation = splitedList[0]
            val value = splitedList[1]

            when (operation) {
                "I" -> {
                    val intValue = value.toInt()
                    minPq.add(intValue)
                    maxPq.add(intValue)
                    map[intValue] = (map[intValue] ?: 0) + 1
                }

                "D" -> {
                    if (value == "1") {
                        var intValue = maxPq.poll()
                        var old = map[intValue]
                        while (old == 0 && intValue != null) {
                            intValue = maxPq.poll()
                            old = map[intValue]
                        }
                        if (old != null) {
                            map[intValue] = old.minus(1)
                        }
                    } else {
                        var intValue = minPq.poll()
                        var old = map[intValue]
                        while (old == 0 && intValue != null) {
                            intValue = minPq.poll()
                            old = map[intValue]
                        }
                        if (old != null) {
                            map[intValue] = old.minus(1)
                        }
                    }
                }
            }
        }

        val keys = map.filter { it.value > 0 }.keys
        if (keys.isEmpty()) return intArrayOf(0, 0)

        val max = keys.maxOf { it }
        val min = keys.minOf { it }
        return intArrayOf(min, max)
    }

    fun solution2(operations: Array<String>): IntArray {

        var minHeap = PriorityQueue<Int>(compareBy { it })
        var maxHeap = PriorityQueue<Int>(compareByDescending { it })

        for ((index, value) in operations.withIndex()) {

            var curCmd = value

            var trans = curCmd.split(" ")

            if (trans[0] == "I") {
                //값 삽입
                minHeap.add(trans[1].toInt())
                maxHeap.add(trans[1].toInt())
            } else {
                when {
                    trans[1].equals("1") -> {
                        //최댓값 삭제
                        if (!maxHeap.isEmpty()) {

                            minHeap.remove(maxHeap.peek()) // 왜 시간복잡도에 문제가 되지 않는가? 이거 O(N)임

                            maxHeap.poll()


                        }
                    }
                    trans[1].equals("-1") -> {
                        //최솟값 삭제
                        if (!minHeap.isEmpty()) {
                            maxHeap.remove(minHeap.peek()) // 왜 시간복잡도에 문제가 되지 않는가? 이거 O(N)임

                            minHeap.poll()
                        }
                    }
                }
            }


        }

        if (minHeap.isEmpty() || maxHeap.isEmpty())
            return intArrayOf(0, 0)


        return intArrayOf(maxHeap.poll(), minHeap.poll())
    }
}

fun main() {
    Solution42628().apply {
        val answer = solution(
            operations = arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1")
        )
        print("${answer[0]}, ${answer[1]}")
    }
}