package tools.lambda

import kotlin.reflect.KClass
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2
import kotlin.reflect.KProperty1
import kotlin.reflect.KProperty

data class Car(val price: Int) {
    fun isExpensive(): Boolean {
        // 비싼지 안비싼지 복잡한 연산이 필요하다고 가정하자...
        return price > 10000
    }
}

fun Car.asEntity(): CarEntity {
    // 맵핑하는데 다양한 프로퍼티 있다고 가정하고 많은 연산 필요하다고 가정하자...
    return CarEntity(price = price)
}

data class CarEntity(val price: Int)

val Car.doublePrice: Int get() = price * 2

fun externalPrint() = println("아무말~")

fun sum(x: Int, y: Int) = x + y
val kFunction: KFunction2<Int, Int, Int> = ::sum
val carFunction: KFunction1<Car, Boolean> = Car::isExpensive
val carProperty: KProperty1<Car, Int> = Car::price
val carR: (Car) -> Boolean = { car -> true }

fun main() {
    val carCreator = ::Car // 생성자 참조
    val cars = listOf(carCreator(2000), carCreator(13000), carCreator(15000))

    println(cars.minByOrNull(Car::price)) // 멤버 프로퍼티 참조
    println(cars.minByOrNull(Car::doublePrice)) // 확장 멤버도 참조 가능

    cars.filter {
        it.isExpensive()
    }.map {
        it.asEntity()
    }.forEach {
        println(it)
    }

    cars.filter(Car::isExpensive) // 멤버 함수 참조
        .map(Car::asEntity)
        .forEach {
            println(it)
        }

    run(::externalPrint) // 최상위 선언 참조


}

interface Function2<in P1, in P2, in P3, out R> {
    operator fun invoke(p1: P1, p2: P2, p3: P3): R
}
