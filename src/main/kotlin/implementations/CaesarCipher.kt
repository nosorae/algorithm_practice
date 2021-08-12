package implementations

/**
 * 2021.08.12
 * Level1. 시저암호
 * https://programmers.co.kr/learn/courses/30/lessons/12926
 * String 을 구현한 CharSequence 의 확장함수 map 사용
 * joinToString 으로 List<Char> 를 다시 String 으로 변환 separator 의 default 값은 ", " 인 것을 "" 로 변환
 * joinToString 의 인자는 아래와 같다.
 * (separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((T) -> CharSequence)? = null)
 * Char 의 isLetter, isLowerCase, isUpperCase 활용
 *
 * 다른 사람의 코드 (Kinetic 님) 를 보니 when 과 in 을 활용해서 코드가 더 깔끔하다.
 */
class MyCaesarCipher {
    fun solution(s: String, n: Int): String {
        var answer = ""
        answer = s.map {
            if (!it.isLetter()) {
                " "
            } else if ((it.isLowerCase() && it + n > 'z') || (it.isUpperCase() && it + n > 'Z') ) {
                it + n - 26
            } else {
                (it + n)
            }

        }.joinToString(separator = "") { "$it" }

        return answer
    }
}

class CaesarCipher {
    fun solution(s: String, n: Int): String =
        s.toList().joinToString(separator = "") {
            when (it) {
                in 'A'..'Z' -> ('A'.toInt() + (it.toInt() - 'A'.toInt() + n) % ('Z' - 'A' + 1)).toChar()
                in 'a'..'z' -> ('a'.toInt() + (it.toInt() - 'a'.toInt() + n) % ('z' - 'a' + 1)).toChar()
                else -> it
            }.toString()
        }
}