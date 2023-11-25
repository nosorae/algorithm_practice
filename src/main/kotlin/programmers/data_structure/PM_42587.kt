package programmers.data_structure

import java.util.LinkedList
import java.util.Queue

/**
 * 23.11.25
 * Lv2. 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * 큐에 넣고 더 큰 숫자가 있으면 그 숫자가 나올때까지 큐에 다시넣고 우선순위 가장 높은 것을 실행하는데
 * 두번째 인자로 주어진 인덱스의 프로세스가 실행되는 실행 번째 수를 구하는 문제
 *
 * 시간복잡도를 최소화하기 위해 정렬을 추가했다. 물론 최악의 경우는 비슷하게 O(N^2)으로 보임,
 * 다른 사람의 풀이를 보니 O(N^2)이어도 통과가 되는 듯 해보인다. (while 안에 또 O(N)짜리 연산)
 */
class Solution42587 {
    fun solution(priorities: IntArray, location: Int): Int {
        val queue: Queue<Process> = LinkedList()
        val priorityQueue: Queue<Process> = LinkedList()

        priorities.mapIndexed { index, priority ->
            val process = Process(
                location = index,
                priority = priority
            )

            queue.add(process)

            process
        }.sortedByDescending { process ->
            process.priority
        }.forEach {  process ->
            priorityQueue.add(process)
        }

        var answer = 0
        do {
            answer++

            val maxPriority = priorityQueue.poll().priority

            var process = queue.poll()
            while (maxPriority > process.priority) {
                queue.add(process)
                process = queue.poll()
            }

        } while (process.location != location)


        return answer
    }

    data class Process(
        val location: Int,
        val priority: Int
    )

    fun solution2(priorities: IntArray, location: Int): Int {
        var printerQueue = LinkedList<Pair<Int,Int>>()
        priorities.forEachIndexed{index, i ->
            printerQueue.offer(Pair(index,i))
        }

        var count = 0
        while (!printerQueue.isEmpty()){
            var first = printerQueue.poll()

            if(printerQueue.any { first.second < it.second }){
                printerQueue.offer(first)
            }else{
                count++
                if(first.first == location) return count
            }
        }
        return 0
    }
}

fun main() {
    Solution42587().apply {
        val answer = solution(
            priorities = intArrayOf(2, 1, 3, 2),
            location = 2
        )

        print(answer)
    }
}