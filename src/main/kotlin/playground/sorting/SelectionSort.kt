package playground.sorting

fun main() {
    selectionSort(intArrayOf(3, 1, 2, 4, 5, 6, 3, 10)).forEach {
        print("$it ")
    }
}

fun selectionSort(arr: IntArray): IntArray {
    val resultArr = arr.clone()
    for (i in resultArr.indices) {
        var min = resultArr[i]
        var minIndex = i
        for (j in i..resultArr.lastIndex) {
            if (min > resultArr[j]) {
                min = resultArr[j]
                minIndex = j
            }
        }
        resultArr[minIndex] = resultArr[i]
        resultArr[i] = min
    }
    return resultArr
}