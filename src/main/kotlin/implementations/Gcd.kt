package implementations



/**
 * 2021.08.17
 * Level1. 최대공약수와 최소공배수
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 * 유클리드 호제법을 이용해서 최대공약수를 구한다.
 * 유클리드 호제법은 https://myjamong.tistory.com/138 참고
 * 시간복잡도 O(logN)
 * 최소공배수 = 두 수의 곱 / 최대공약수
 * 원리가 잘 와닿지 않는다.
 * Kotlin 에서의 min max
 * Int.coerceAtLeast(Int) Max 와 같다.
 * Int.coerceAtMost(Int)  Min 과 같다.
 * 인데 생각해보니 안써도 자동으로 큰 수가 한쪽으로 이동해서 안써도 된다.
 *
 * 다른 사람의 풀이 (-님) 는 재귀를 써서 더 깔끔하게 코드를 작성하셨다.
 * tailrec 이라는 키워드를 처음 봤는데
 * 일단 꼬리재귀란 재귀함수가 자기자신만 리턴하다가 값을 리턴하는 구조일 때 사용된다고 한다.
 * 이 꼬리재귀인 함수에 tailrec 이라는 키워드를 붙이면 컴파일러가 꼬리재귀를 루프로 바꿔준다고 한다.
 * 런타임에 재귀함수 호출에 필요한 오버헤드를 줄이려는 목적인 것 같다.
 * 자세한 내용은 https://codechacha.com/ko/kotlin-tailrect/ 이분이 잘 정리해주셨다.
 *
 */
class MyGcd {
    fun solution(n: Int, m: Int): IntArray {
        val gcd = gcd(n, m)
        var answer = intArrayOf(gcd, n*m / gcd)
        return answer
    }

    fun gcd(n: Int, m: Int): Int {
//        var a = n.coerceAtLeast(m)
//        var b = n.coerceAtMost(m)
        var a = n
        var b = m
        while (b != 0) {
            val remainder = a % b
            a = b
            b = remainder
        }
        return a
    }


}

class Gcd {
    fun solution(n: Int, m: Int): IntArray {
        val gcd = gcd(n, m)

        return intArrayOf(gcd, n * m / gcd)
    }

    tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}



