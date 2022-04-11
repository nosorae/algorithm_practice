package tools.rx

import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.Executors
import java.util.concurrent.Flow.Publisher
import java.util.concurrent.Future


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

    // 주의! create 연산자는 개발자가 직접 Emitter 를 제어하므로, 콜백을 직접 모두 제거해주지 않으면 메모리 누수가 발생할 수 있으니 주의한다.

    /**
     * create 끝, just 연산자 시작
     * 해당 아이템을 그대로 발행하는 Observable 생성해줌
     * 인자로 넣은 아이템을 차례로 발행하고
     * 한 개 이상의 같은 타입의 아이템을 넣을 수 있다.
     */
    source = Observable.just("Hello", "World")
    source.subscribe { println(it) }

    // null 을 넣고 싶다면? RxJava 는 기본적으로 null 을 허용하지 않아서 just 에 null 넣으면 안된다! 그 때는 empty 를 쓰자
    source = Observable.empty()
    source.subscribe { println(it) }

    /**
     * from~
     * 이미 참조하고 있는 자료구조, Future, Callable, Publisher 를
     * from 으로 시작하는 연산자를 통해 Observable 로 변환해보기
     *
     * Future 가 좀 어렵게 느껴질 수 있는데 비동기적인 작업의 결과를 구할 대 사용한다고 이해하면 된다.
     * Publisher 는 잠재적인 아이템 발행을 제공하는 생산자로 Subscriber 로부터 요청을 받아 아이템을 발행
     **/

    // Iterable 예시, Array 는 vargs 던데?
    val arr = listOf("a", "b", "c")
    source = Observable.fromIterable(arr)
    source.subscribe { println(it) }

    val future = Executors.newSingleThreadExecutor()
        .submit(
            { Thread.sleep(5000) }, // 왜 뒤에까지 5초가 미뤄지지?
            "Hello World"
        )
    source = Observable.fromFuture(future)
    source.subscribe { println(it) }

    val publisher = org.reactivestreams.Publisher<String> { subscriber ->
        subscriber.onNext("A")
        subscriber.onNext("B")
        subscriber.onNext("C")
        subscriber.onComplete()
    }
    source = Observable.fromPublisher(publisher)
    source.subscribe { println(it) }

    /**
     * Single : Observable 과 다르게 단 하나의 아이템만을 발행
     * - just 로 초기화 시 하나의 인자로만 초기화 가능
     * - create 로 초기화 시 Emitter 의 onSuccess 로 onNext, onComplete 대체, 또는 onError 로 오류를 구독자에게 통지
     */

    Single.just("Single Test").subscribe { it -> println(it) }
    Single.create<String> { emitter ->
        emitter.onSuccess("Hello World")
    }.subscribe { it ->
        println(it)
    }

}