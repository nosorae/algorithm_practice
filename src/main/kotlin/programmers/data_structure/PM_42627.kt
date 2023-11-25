package programmers.data_structure

import java.util.*

/**
 * 23.11.25
 * Level3. 디스크 컨트롤러
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 * while 블록 안에 매초 실행될 코드 작성
 * 현재 요청대기 중인 요청 중에 처리 소요시간이 제일 작은 요청부터 처리
 * '소요시간'기준으로 작은 요청부터 처리하면 좋겠다. -> PriorityQueue 사용
 * 물론 현재 시간이 요청시간보다 크거나 같아야 처리할 수 있다.
 * 그렇다면 현재 시간이 요청시간보다 작을 때는? -> 다른 우선순위큐에 넣어야하는가? -> pendingQueue따로 둠
 * 그리고 결국 요청~완료까지의 소요시간의 평균을 구해줘야한다. -> sum 변수 필요
 *
 * 주의)
 * poll, peek은 큐가 비었어도 예외를 던지지 않고 null로 반환함에 주의한다.
 * NPE발생 가능성이 높다. -> null처리를 항상 염두해두어야함
 *
 * TODO:: 다른 사람의 풀이 분석
 */
class Solution42627 {
    fun solution(jobs: Array<IntArray>): Int {
        val pq = PriorityQueue(
            jobs.map { job ->
                Job(
                    requestedAt = job[0],
                    cost = job[1]
                )
            }
        )


        var sum = 0
        var currentTime = 0

        while (pq.isNotEmpty()) {
            val pendingQueue: Queue<Job> = LinkedList()
            while (pq.isNotEmpty() && pq.peek().requestedAt > currentTime) {
                pendingQueue.add(pq.poll())
            }

            val job = pq.poll()
            if (job != null) {
                sum += ((currentTime - job.requestedAt) + job.cost)
                currentTime += job.cost
            } else {
                currentTime++
            }
            pq.addAll(pendingQueue)
        }

        return sum / jobs.size
    }

    data class Job(
        val requestedAt: Int,
        val cost: Int
    ) : Comparable<Job> {
        override fun compareTo(other: Job): Int {
            return cost - other.cost
        }
    }

    // TODO:: 분석 필요
    fun solution2(jobs: Array<IntArray>): Int {
        var jobList = jobs.map { it[0] to it[1] }.sortedBy { it.first }
        var sortedTime: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second })
        var current = 0
        var sum = 0
        while (!jobList.isEmpty() || !sortedTime.isEmpty()) {
            val c = jobList.takeWhile { it.first <= current }
            sortedTime.addAll(c)
            jobList = jobList.drop(c.size)
            if (sortedTime.isEmpty()) {
                current = jobList.first().first
            } else {
                val j = sortedTime.poll()
                current += j.second
                sum += current - j.first
            }
        }

        return sum / jobs.size
    }
}

fun main() {
    Solution42627().apply {
        val answer = solution(
            jobs = arrayOf(
                intArrayOf(0, 3),
                intArrayOf(1, 9),
                intArrayOf(2, 6)
            )
        )

        println(answer)
        val answer2 = solution(
            jobs = arrayOf(
                intArrayOf(0, 3),
                intArrayOf(100, 9),
                intArrayOf(1, 32)
            )
        )
        println(answer2)
    }
}