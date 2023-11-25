package programmers.sort

/**
 * 23.11.25
 * Lv1. K번째수
 * 리스트 잘라서 정렬하고 특정 인덱스 숫자를
 *
 * 다른 사람의 풀이보고 배운점
 * map -> toIntArray로 함수형 프로그래밍 가능
 */
class Solution42748 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands
            .map { command ->
                val start = command[0] - 1
                val end = command[1]
                val index = command[2] - 1
                array.toList().subList(start, end).sorted()[index]
            }
            .toIntArray()
    }

    fun solution2(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map { command ->
            array.slice(IntRange(command[0] - 1, command[1] - 1)).sorted()[command[2] - 1]
        }
            .toIntArray()
    }
}

fun main() {
    Solution42748().apply {
        val answer = solution(
            array = intArrayOf(1, 5, 2, 6, 3, 7, 4),
            commands = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
        )
        print(answer.joinToString { "$it\n" })
    }
}