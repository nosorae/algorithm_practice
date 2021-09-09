package univ


//
/**
 * 2021.09.10
 * 네트워크 보안 연습문제 풀다가
 * 덧셈 암호(Additive Cipher)
 * 암호화와 복호 연습
 */


//const val INPUT = "This is an exercise"


private fun encrypt(input: String, key: Int): String =
    input
        .lowercase()
        .filter {
            it != ' '
        }.map {
            if (it + key > 'z') {
                val dist = (it + key) - 'z'
                ('a' + dist - 1).toChar()
            } else {
                (it + key).toChar()
            }
        }
        .joinToString("") { "$it" }.uppercase()


private fun decrypt(input: String, key: Int): String =
    input
        .lowercase()
        .map {
            if (it - key < 'a') {
                val dist = 'a' - (it - key)
                'z' - dist + 1
            } else {
                (it - key)
            }
        }.joinToString("") { "$it" }