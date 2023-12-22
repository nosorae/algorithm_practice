package programmers.dfs_bfs

/**
 * 23.12.21 목
 * Lv2. 타겟넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 예외사항이 많아서 그리디로 풀 수 있는 문제는 아닌 것 같고
 * 2^20 이면 100만 정도이니 다 해볼만하다.
 */
class Solution43165 {
    fun solution(numbers: IntArray, target: Int): Int {
        return TargetNumber(
            numbers = numbers,
            target = target
        ).solution()
    }
}

class TargetNumber(
    val numbers: IntArray,
    val target: Int
) {
    var targetNumberCount = 0

    fun solution(): Int {
        tryAll(index = 0, currentNumber = 0)
        return targetNumberCount
    }

    private fun tryAll(index: Int, currentNumber: Int) {
        if (index > numbers.size - 1) {
            if (currentNumber == target) {
                targetNumberCount++
            }
            return
        }

        tryAll(index = index + 1, currentNumber = currentNumber + numbers[index])
        tryAll(index = index + 1, currentNumber = currentNumber - numbers[index])
    }

    /**
     * 다른 사람의 풀이
     */
    fun solution2(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { list, i ->
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
    }

    fun solution3(numbers: IntArray, target: Int): Int {
        var answer = 0
        fun dfs(sum: Int,idx: Int){
            if(idx<numbers.size-1){
                dfs(sum+numbers[idx],idx+1)
                dfs(sum-numbers[idx],idx+1)
            }
            else{
                if(sum+numbers[idx] == target) {answer++}
                if(sum-numbers[idx] == target) {answer++}
            }
        }
        dfs(0,0)
        return answer
    }
}