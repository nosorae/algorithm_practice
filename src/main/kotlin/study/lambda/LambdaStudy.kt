package study.lambda

fun main() {
    1.test { // 수신객체 1
        println("$this")
    }
}

fun Int.test(a: Int.() -> Unit) { // 수신객체는 이 함수를 호출한 Int 객체 1
    1000.a() // 수신객체 지정람다 호출을 수신객체가 아닌 로컬 객체(?) 로 지정
    a() // 수신객체가 이미 Int 이니 바로 호출 가능한 것 (this 의 타입이 Int 니까!)
    a()
    a() // 여러번 호출한 만큼 수신객체 지정람다로 전달된 블록이 실행됨을 확인
}
