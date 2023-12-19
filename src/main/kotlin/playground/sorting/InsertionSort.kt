package playground.sorting

fun main() {
    insertionSort2(intArrayOf(11, 3, 9, 8, 7, 9, 1, 2, 4, 5, 6, 3, 10)).forEach {
        print("$it ")
    }
}

fun insertionSort(input: IntArray): IntArray {
    val arr = input.clone()
    for (i in 1..arr.lastIndex) {
        val target = arr[i]
        for (j in i - 1 downTo 0) {
            val temp = arr[j]
            arr[j] = target
            if (temp > target) {
                arr[j + 1] = temp
            } else {
                break
            }
        }
    }
    return arr
}

fun insertionSort2(input: IntArray): IntArray {
    val arr = input.clone()
    for (i in 1..arr.lastIndex) {
        val target = arr[i]
        var j = i
        while (j > 0 && arr[j - 1] > target) {
            arr[j] = arr[j - 1]
            j--
        }
        arr[j] = target
    }
    return arr
}