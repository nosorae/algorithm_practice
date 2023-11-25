package programmers

import java.util.*

/**
 * 2021.01.01 -> 23.11.25
 * Lv2. 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 큐에 더미를 넣는 방식으로 트럭의 위치를 잡아주었음
 * while 블록안의 코드로 1초동안 발생하는 일을 작성하는 방식
 * IntArray로 Queue바로 만드는 법  Queue<Int> = LinkedList(truck_weights.toList())
 *
 * 다른 사람의 풀이처럼 Queue를 두 개 이용하는 방법도 있겠다.
 * 다리 상태를 나타내는 Queue, 아직 다리 위에 올라가지 못하고 대기하는 Queue
 * 다른 내용은 내 구현과 동일
 */
class Solution {
    fun solution(bridge_length: Int, limit: Int, truck_weights: IntArray): Int {
        var answer = 0
        var cur = 0
        var weightSum = 0
        val q = LinkedList<Int>() as Queue<Int>

        do {

            answer += 1

            if (q.size >= bridge_length) {
                val w = q.poll()
                if (w >= 0) weightSum -= w
            }

            if (cur < truck_weights.size && weightSum + truck_weights[cur] <= limit) {
                q.add(truck_weights[cur])
                weightSum += truck_weights[cur]
                cur += 1
            } else {
                q.add(0)
            }
        } while (weightSum != 0)

        return answer
    }

    fun solution2(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val bridgeQueue: Queue<Int> = LinkedList(List(bridge_length){0})
        val waitingQueue: Queue<Int> = LinkedList(truck_weights.toList())

        while (bridgeQueue.isNotEmpty()) {
            answer++
            bridgeQueue.poll()
            if (waitingQueue.isNotEmpty()) {
                if (bridgeQueue.sum() + waitingQueue.peek() <= weight) { // 현재 다리위 무게 합을 나타내는 변수를 따로 두면 더 효율적일듯
                    bridgeQueue.add(waitingQueue.poll())
                } else {
                    bridgeQueue.add(0)
                }
            }
        }
        return answer
    }
}