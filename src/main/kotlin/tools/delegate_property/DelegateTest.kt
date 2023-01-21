package tools.delegate_property

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

data class Engine(val name: String, val old: Int)

class EngineDelegate(private val initEngine: Engine) {
    private var _engine: Engine? = null

    operator fun getValue(car: Car, property: KProperty<*>): Engine {
        println("엔진 대신 가져오는 중...")
        return _engine ?: run {
            _engine = initEngine
            initEngine
        }
    }

    operator fun setValue(car: Car, property: KProperty<*>, newEngine: Engine) {
        println("새로운 엔진으로 교체중...")
        _engine = newEngine
    }
}

class Car {
    var engine: Engine by EngineDelegate(Engine("구형 엔진", 9))
}

fun main() {
//    val lazyTest = LazyTest().test
//    repeat(3) {
//        println(lazyTest)
//    }

    Car().run {
        println(engine)
        println(engine)
        engine = Engine("신형 엔진", 0)
        println(engine)
    }
}

