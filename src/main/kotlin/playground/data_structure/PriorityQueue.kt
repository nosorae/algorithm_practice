package playground.data_structure

import java.lang.Exception
import java.util.*

/**
 * Implementation note: 공식문서의 시간복잡도 설명
 * this implementation provides O(log(n)) time for the enqueuing and dequeuing methods (offer, poll, remove() and add);
 * linear time for the remove(Object) and contains(Object) methods;
 * and constant time for the retrieval methods (peek, element, and size).
 * https://notepad96.tistory.com/104 참고
 */
fun main(args : Array<String>) {
    val pq = PriorityQueue<Int>()
    val reversePq = PriorityQueue<Int>(Collections.reverseOrder())
    /* 삽입 */
    pq.add(4)
    pq.addAll(listOf(1, 3, 5, 6, 6))
    pq.offer(2)

    reversePq.addAll(listOf(1, 3))
    reversePq.add(4)
    reversePq.add(5)
    reversePq.add(6)
    reversePq.add(6)

    println("삽입 성공 여부 ${reversePq.add(2)}")
    println(pq)
    println(reversePq)

    println("====================탐 색====================")
    println("pq 4 포함 여부 : ${pq.contains(4)}")
    println("pq Size : ${pq.size}")
    println("pq 맨 위 : ${pq.peek()}")
    println("reversePq 맨 위 : ${reversePq.peek()}")

    println("===================삭 제=====================")
    print("reversePq = ")
    while(reversePq.isNotEmpty()) print("${reversePq.poll()} ")

    println("\n====================삭 제====================")
    print("pq = ")
    while (pq.isNotEmpty()) print("${pq.remove()} ")

    println("\n====================비정상적인 동작 테스트====================")
    try {
        print("빈 리스트 넣기 가능?")
        pq.addAll(listOf())
        println(" ㅇㅇ 가능")
    } catch (e: Exception) {
        println(" ㄴㄴ 불가함 왜냐면 $e 라서")
    }

    try {
        print("빈 큐에 poll 가능?")
        println(" ㅇㅇ 가능 ${pq.poll()}")
        print("빈 큐에 remove 가능?")
        println(" ㅇㅇ 가능 ${pq.remove()}")
    } catch (e: Exception) {
        println(" ㄴㄴ 불가함 왜냐면 $e 라서")
    }

    try {
        print("큐에 null 삽입 가능?") // 문서에도 안된다고 나와있음
        print(" ㅇㅇ 가능 ${pq.add(null)}")
    } catch (e: Exception) {
        println(" ㄴㄴ 불가함 왜냐면 $e 라서")
    }
}