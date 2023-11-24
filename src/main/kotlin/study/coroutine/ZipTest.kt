package study.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun basicZipTest() = runBlocking {
    val nums = (1..3).asFlow()
    val strs = flowOf("일", "이", "삼")
    nums.zip(strs) { a, b -> "${a} - $b" }
        .collect { println(it) }

    println("---")

    val nums2 = (1..5).asFlow().onEach {
        delay(2000L)
        println("number $it")
    }
    val strs2 = flowOf("일", "이").onEach {
        delay(100L)
        println("숫자 $it")
    }

    nums2.zip(strs2) { a, b -> "${a} -  $b" }
        .collect { println(it) } // 더 긴 것에 짝맞춰서 프린트함을 확인
}

fun errorZipTest() = runBlocking {
    val nums = (1..3).asFlow().onEach {
        delay(200L)
        println("number $it")
    }
    val strs = flowOf("일", "이", "삼").onEach {
        delay(100L)
        if (it == "이") throw Exception("error")
        println("숫자 $it")
    }
    nums.zip(strs) { a, b -> "result : ${a} - $b" }
        .catch {
            println("error $it")
        }
        .collect { println(it) }
}

fun errorZipTest2() = runBlocking {
    val nums = (1..3).asFlow().onEach {
        delay(200L)
        println("number $it")
    }
    val strs = flowOf("일", "이", "삼", "사").onEach {
        delay(100L)
        if (it == "사") throw Exception("error")
        println("숫자 $it")
    }
    nums.zip(strs) { a, b -> "result : ${a} - $b" }
        .catch {
            println("error $it")
        }
        .collect { println(it) }
}