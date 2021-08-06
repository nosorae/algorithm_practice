/**
 * 2021.08.06
 * 두개 뽑아서 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 * 브루트포스로 모든 경우의 수를 다 해보고
 * set 으로 중복 검사를 한다.
 * 인덱스와 그 값을 헷갈리지 말자
 * until 은 오른쪽에 적힌 정수 -1 까지 이다.
 * .. 오른쪽에 적힌 정수는 포함이다.
 * withIndex 를 사용하면 다음과 같은 IndexedValue 에 데이터를 담아서 Iterator 로 반환해준다.
 * public data class IndexedValue<out T>(public val index: Int, public val value: T)
 *
 * 왜 프로그래머스에서 forEachIndexed 를 사용할 수 없지??
 *
 *
 */

class FindDistinctNums {
    fun solution(numbers: IntArray): IntArray {
        val list = numbers.toList()
        return list
            .withIndex() // IndexedValue(인덱스, 값)라는 데이터 클래스의 Iterator 를 가져온다.
            .flatMap { i -> list.withIndex().map { i to it } } // i to j 즉 i 와 j 의 Pair 객체의 리스트로 만든다. i 와 j 모두 IndexedValue 이다. 이 부분이 이중반복문이라 할 수 있겠다.
            // 여기서 flatMap 과 map 을 쓰는 것의 차이는 map 으로하면 반환값이 List<List<Pair<IndexedValue<Int>, IndexedValue<Int>>>> 이 된다.
            // 하지만 flatMap 을 사용하면 반환값이 List<Pair<IndexedValue<Int>, IndexedValue<Int>>> 이 된다. 그래서 Pair 를 하나씩 꺼내올 수 있게 된다.
            .filter { it.first.index != it.second.index } // 인덱스가 같은 것은 거른다. 즉 인덱스가 다른 것만 살려서 리턴한다.
            .map { it.first.value + it.second.value } // 인덱스가 다른 페어들만 남았기 때문에 value 를 다 더한 값이 모인 리스트로 만든다. 아직 중복제거가 되지 않았다.
            .toSortedSet() // 중복제거
            .toIntArray()

    }
    fun main() {
        print(java.util.Arrays.toString(solution(intArrayOf(5,0,2,7))))
    }
}

class MyFindDistinctNums {
    fun solution(numbers: IntArray): IntArray {
        var set = mutableSetOf<Int>()
        for ((index, cur) in numbers.withIndex()) {
            for(otherIdx in index+1 until numbers.size) {
                set.add((cur + numbers[otherIdx]))
            }
        }
        var answer: IntArray = set.sorted().toIntArray()
        return answer
    }
    fun main() {
        print(java.util.Arrays.toString(solution(intArrayOf(5,0,2,7))))
    }
}
