package tools.lambda

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

