package tools.rx

import io.reactivex.Observable


fun main() {
    Observable // 생산자 : 데이터를 생산하여 전달
        .just("Hello?", "RxJava!?") // 생성 연산자
        .map { it.dropLast(1) } // 변환 연산자 : 데이터의 가공 (뒷자리 하나 제거)
        .subscribe { println(it) } // 소비자 : 데이터를 받아서 처리 (println)
    println()

    /**
     * Observable : 데이터 순차적으로 발행 (onNext), 데이터 발행 끝났음을 알림 (onComplete), 오류발생 알림 (onError) to Observer
     * Observer : Observable 을 구독함
     * Emitter : Observable create 시 이것을 이용하여 직접 아이템을 발행하고 완료 및 오류의 알림을 직접 설정할 수 있음.
     */
    var source: Observable<String> = Observable.create { emitter ->
        emitter.onNext("Hello")
        emitter.onNext("World")
        emitter.onNext("SoRae")
        emitter.onComplete()
    }
    source.subscribe { println(it) }

    /**
     * onComplete 호출 후에는 아이템이 추가로 발행되더라도 구독자는 데이터 통지받지 못함
     */
    source = Observable.create { emt ->
        emt.onNext("Hello")
        emt.onComplete()
        emt.onNext("World")
    }
    source.subscribe { println(it) }

    /**
     * 에러발생 시 후에 추가 발행되는 아이템은 통지받지 못하고, Emittere 의 onError(Throwable) 을 호출하고 구독자는 이를 처리한다.
     */
    source = Observable.create { emt ->
        emt.onNext("Hello")
        emt.onError(Throwable())
        emt.onNext("World")
    }
    source.subscribe(
        { item ->
            println(item)
        },
        { throwable ->
            println("Error")
        }
    )
}