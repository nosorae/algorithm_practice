package implementations


/**
 * 2021.08.06
 * Level1. 숫자 문자열과 영단어
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 * 멤버변수에 0~9와 String 을 매치하는 맵을 만들어준다.
 * 그리고 replace 로 하나씩 바꿔준다.
 *
 * 다른 사람풀이 보면 풀이내용은 같지만 정말 깔끔하다. 본받자!
 *
 */
class MySpreadStringToNumber {
    val stringToNumber = mapOf(
        "zero" to "0",
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )
    fun solution(input: String): Int {
        var currentResult = input
        stringToNumber.keys.forEach {
            currentResult = currentResult.replace(it, stringToNumber[it]!!, false)
        }
        return currentResult.toInt()
    }
}


// aw , Seungyeon HWANG 님
class SpreadStringToNumber {
    fun solution(s: String): Int {
        return s
            .replace("zero", "0")
            .replace("one", "1")
            .replace("two", "2")
            .replace("three", "3")
            .replace("four", "4")
            .replace("five", "5")
            .replace("six", "6")
            .replace("seven", "7")
            .replace("eight", "8")
            .replace("nine", "9")
            .toInt()
    }
}