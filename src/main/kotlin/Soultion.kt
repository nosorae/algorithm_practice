import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 2021.08.28
 * BOJ
 *
 */
val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

var n = 0
lateinit var nums: MutableList<Int>
var answer = 0

fun main() {
    initVariables()
    makeAllCase(0, nums)
    printAnswer()
}
fun initVariables() {
    n = br.readLine().toInt()
    nums = mutableListOf()
    br.readLine().split(" ").map { nums.add(it.toInt()) }
    answer = 0
    br.close()
}

fun makeAllCase(localAnswer: Int, localNums: MutableList<Int>) {
    val size = localNums.size
    if (size == 2) {
        answer = Math.max(answer, localAnswer)
        return
    }
    for(i in 1 until size - 1) {
        val nextValue = localAnswer + (localNums[i-1] * localNums[i+1])
        val nextNums = mutableListOf<Int>().apply {
            addAll(localNums)
            removeAt(i)
        }
        makeAllCase(nextValue, nextNums)
    }
}

fun printAnswer() {
    bw.write(answer.toString())
    bw.flush()
    bw.close()
}