package tools.coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

import kotlinx.coroutines.*

fun testJobCancel() = runBlocking {
    val job = launch { // 부모
        launch(Job()) {
            println(coroutineContext[Job])
            println("launch1: ${Thread.currentThread().name}")
            delay(1000L)
            println("3!")
        }

        launch {
            println(coroutineContext[Job])
            println("launch2: ${Thread.currentThread().name}")
            delay(1000L)
            println("1!")
        }
    }

    delay(500L)
    job.cancelAndJoin()
    delay(1000L) // <- 3!이 찍힘, 부모가 더이상 launch1 기다려주지 않으니까 main 종료되고 3! 이 안찍힌 것, 근데 main 종료 안되면 cancelAndJoin 해도 3! 은 찍힌다.
    // 참고로 딜레이를 너무 작은 숫자로 하면 결과가 다르게 나올 수 있음
    println("Hello, world!")
}