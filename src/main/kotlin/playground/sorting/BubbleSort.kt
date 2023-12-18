package playground.sorting

fun main() {
    bubbleSort(intArrayOf(11, 3, 1, 2, 4, 5, 6, 3, 10)).forEach {
        print("$it ")
    }
}

fun bubbleSort(arr: IntArray): IntArray {
    val resultArr = arr.clone()
    for (i in resultArr.lastIndex - 1 downTo 1) {
        for (j in 0..i) {
            if (resultArr[j] > resultArr[j + 1]) {
                val temp = resultArr[j]
                resultArr[j] = resultArr[j + 1]
                resultArr[j + 1] = temp
            }
        }
    }

    return resultArr
}