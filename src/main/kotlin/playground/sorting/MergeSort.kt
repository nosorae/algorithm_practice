package playground.sorting

fun main() {
    val arr = intArrayOf(5, 8, 7, 1, 6, 2, 4, 3)

    mergeSort2(arr, 0, arr.lastIndex)
//    mergeSort(arr).forEach {
//        print("$it ")
//    }
}

fun mergeSort(arr: IntArray): IntArray {
    if (arr.size <= 1) return arr

    val middleIndex = (arr.size - 1) / 2
    val leftArr = mergeSort(arr.sliceArray(0..middleIndex))
    val rightArr = mergeSort(arr.sliceArray(middleIndex + 1..arr.lastIndex))
    val mergedArr = IntArray(leftArr.size + rightArr.size)

    var leftIndex = 0
    var rightIndex = 0
    var mergedIndex = 0

    while (leftIndex in leftArr.indices || rightIndex in rightArr.indices) {
        if (rightIndex > rightArr.lastIndex || (leftIndex <= leftArr.lastIndex && leftArr[leftIndex] <= rightArr[rightIndex])) {
            mergedArr[mergedIndex] = leftArr[leftIndex]
            leftIndex++
        } else {
            mergedArr[mergedIndex] = rightArr[rightIndex]
            rightIndex++
        }
        mergedIndex++
    }

    return mergedArr
}

val buffer = IntArray(30)
fun mergeSort2(arr: IntArray, start: Int, end: Int) {
    if (start >= end) return

    val middle = (start + end) / 2
    mergeSort2(arr, start, middle)
    mergeSort2(arr, middle + 1, end)
    merge(arr, start, middle, end)
}

private fun merge(arr: IntArray, start: Int, middle: Int, end: Int) {
    var i = start
    var j = middle + 1
    var k = start
    while (i <= middle && j <= end) {
        buffer[k] = if (arr[i] <= arr[j]) {
            arr[i++]
        } else {
            arr[j++]
        }
        k++
    }

    if (i > middle) {
        for (t in j..end) {
            buffer[k++] = arr[t]
        }
    } else {
        for (t in i..middle) {
            buffer[k++] = arr[t]
        }
    }

    for (t in start..end) {
        arr[t] = buffer[t]
    }

    println(arr.joinToString { it.toString() })
}