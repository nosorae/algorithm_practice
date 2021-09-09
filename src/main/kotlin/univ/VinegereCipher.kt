package univ

/**
 * 2021.09.10
 * 네트워크 보안 3장 연습문제 풀다가
 * 비네게르 암호로 암호화 연습
 */
private fun encrypt(input: String, keyword: String): String {
    val keys = keyword.map { it - 'A' }
    val output =
        input
            .uppercase()
            .filter { it != ' ' }
            .mapIndexed { i, letter ->

                val key = keys[i % keys.size]

                if (letter + key > 'Z') {
                    'A' + (letter + key - 'Z') - 1
                } else {
                    letter + key
                }
            }

    return output.joinToString("") { "$it" }
}