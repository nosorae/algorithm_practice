package tools.delegate_property

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.reflect.KProperty

class LazyTest {
    val test: String by lazy {
        runBlocking {
            println("초기화 로직...")
            delay(1000L)
            "값"
        }

    }
}

fun main() = runBlocking {
    val lazyTest = LazyTest().test
    repeat(3) {
        println(lazyTest)
    }

}
