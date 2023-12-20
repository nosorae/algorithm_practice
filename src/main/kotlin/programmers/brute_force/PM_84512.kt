package programmers.brute_force

import kotlin.math.pow

/**
 * 23.12.20 (수)
 * Lv2. 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 *
 * TODO:: 수학적으로 풀 수 있는 방법을 이해해보기 (사실 잘 안 떠올라서 일단 다해봄)
 */
class Solution {
    fun solution(word: String): Int {
        return DictionaryOfAEIOU(inputWord = word).getCount()
    }
}

class DictionaryOfAEIOU(
    val inputWord: String
) {
    private val alphabets = charArrayOf('A', 'E', 'I', 'O', 'U')
    private var totalCount = 0

    fun getCount(): Int {
        tryAll()
        return totalCount
    }

    private fun tryAll(count: Int = 0, currentWord: String = ""): Boolean {
        if (currentWord.isNotEmpty()) {
            totalCount++
        }

        if (inputWord == currentWord) {
            return true
        }

        if (count >= alphabets.size) {
            return false
        }

        for (alphabet in alphabets) {
            if (tryAll(count + 1, currentWord + alphabet)) {
                return true
            }
        }

        return false
    }

    /**
     * 다른 사람의 풀이 (김예지님)
     * 수학적으로 풀이
     */
    fun solution(word: String): Int {
        val list = listOf('A', 'E', 'I', 'O', 'U')
        return word.mapIndexed { i, w ->
            getSum(5 - i) * list.indexOf(w)
        }.sum() + word.length
    }

    // 등비 급수 (S_n)
    private fun getSum(n: Int) = (((5.0).pow(n) - 1) / (5 - 1)).toInt()
}