import java.util.*

/**
 * 2021.01.01 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 큐에 더미를 넣는 방식으로 트럭의 위치를 잡아주었음
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
}