
/**
 * 2021.08.06
 * Level 1. 부족한 금액 계산하기
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 * for 문 대신 repeat 함수를 사용해보았다. 람다의 인수로는 index 를 0부터 n-1 까지 받아온다.
 *
 *
 * aw 님의 코드에 대해서
 * (n..m) 이런식으로  를 만들 수 있다.
 * 정수 타입에서 .. 연산자는 ClosedRange<T>와 *Progression을 모두 구현한 객체를 생성한다.
 * 예를들어, IntRange는 ClosedRange<Int>를 구현하고 IntProgression을 확장하므로 IntProgression에 정의된 모든 오퍼레이션을 IntRange에서도 사용 가능하다.
 * 코드 직접 확인해보니 IntProgression 는 Iterable<T> 를 구현하였고 map Iterable<T> 의 확장함수니까 가능한 코드였다.
 *
 * TODO 속도는 내가 더 빠르다. 왜인지는 모르겠다. 아마 두번 돌 걸 한 번 돌아서?
 */


// aw 님의 코드
class CalculateShortMoney {
    fun solution(price: Int, money: Int, count: Int): Long
            = (1..count).map { it * price.toLong() }.sum().let { if (money > it) 0 else it - money }
    // 아래 코드는 sumBy 의 반환값이 Int 로 고정되어있기 때문에 틀릴 수 있다.
   // = (1L..count.toLong()).sumBy { price.toLong() * it }.toLong().let { if (money > it) 0 else it - money }

}

class MyCalculateShortMoney {
    fun solution(price: Int, money: Int, count: Int): Long {
        var sum: Long = 0
        repeat(count) { index ->
            sum += price * (index + 1)
        }
        var answer = sum
        answer = if (money - sum > 0) 0 else sum - money
        return answer
    }
}

