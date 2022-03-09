package programmers.implementations

import java.util.*

/**
 * 2021.08.13
 * Level1. 상호평가
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 *
 * 평가를 한 것과 받은 점수가 다르다. i, j 와 j, i 가 다르다.
 * 자신을 평가한 점수중에서 자기자신에게 부여한 점수가 유일한 최대 또는 유일한 최소이다.
 * 자신이 평가한 점수중에서가 아니다, 문제 조건을 잘 읽어야한다.
 * 중복과 최대최소여부를 검사하는 부분에서 N^2
 */
class MutualEvaluation {
    lateinit var scores: Array<IntArray>
    fun solution(scores: Array<IntArray>): String {
        this.scores = scores


        checkSelfScoreUniqueMinOrMax()

        scores.forEach {
            println(Arrays.toString(it))
        }

        return getStudentsGrade()
    }


    fun isSelfScoreUnique(studentIdx: Int): Boolean {
        for (i in scores.indices) {
            if (i != studentIdx && scores[i][studentIdx] == scores[studentIdx][studentIdx]) {
                return false
            }
        }
        return true
    }

    fun checkSelfScoreUniqueMinOrMax() {


        for (i in scores.indices) {
            var min = 101
            var max = -1
            if (isSelfScoreUnique(i)) {
                for (j in scores.indices) {
                    if (min > scores[j][i]) {
                        min = scores[j][i]
                    }
                    if (max < scores[j][i]) {
                        max = scores[j][i]
                    }
                }
                if (min == scores[i][i] || max == scores[i][i]) {
                    scores[i][i] = -1
                }
            }

        }
    }

    fun getStudentsGrade(): String {
        var answer: String = ""
        for (i in scores.indices) {
            var sum = 0
            var cnt = 0
            for (j in scores.indices) {
                if (scores[j][i] != -1) {
                    sum += scores[j][i]
                    cnt += 1
                }
            }
            val average = sum / cnt.toDouble()
            answer += scoreToGrade(average)
        }
        return answer
    }


    fun scoreToGrade(averageScore: Double): String {
        when {
            averageScore >= 90 -> {
                return "A"
            }
            averageScore >= 80 -> {
                return "B"
            }
            averageScore >= 70 -> {
                return "C"
            }
            averageScore >= 50 -> {
                return "D"
            }
            else -> {
                return "F"
            }
        }
    }
}