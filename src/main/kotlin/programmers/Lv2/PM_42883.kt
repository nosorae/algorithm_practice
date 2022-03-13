package programmers.Lv2


import java.util.*

/**
 * 2022.03.13
 * 큰 수 만들기
 * LV.2
 * 내 솔루션은 입력에 따라 시간 차가 큰 반면 (내림차순으로 된 length 가 긴 number, 작은 k 가 오면 시간이 커진다.)
 * 내 풀이는 사실상 O(N) 이라 생각했는데.. O(N^2).. 통과한 게 용하다.
 * 다른 사람의 풀이는 입력에 따른 시간차가 크게 나지 않는다.
 * 근데 생각해보니 그렇다치면 다른 사람 풀이도 시간복잡도 O(N^2) 인 것 같은데..
 * 케이스 마다 다른 것 같다. 10번 케이스를 제외하면 대부분 내 풀이가 더 빠르다.
 * 더 공부가 필요하다.
 *
 */
fun solution(number: String, k: Int): String {
    var answer = ""
    var kCnt = k
    val numberStack: Stack<Char> = Stack()
    var numArray = CharArray(number.length - k)


    number.forEach {
        while (!numberStack.isEmpty() && numberStack.peek() < it && kCnt != 0) {
            numberStack.pop()
            kCnt--
        }
        numberStack.push(it)
    }

    for (i in 0 until kCnt) {
        numberStack.pop()
    }

    numberStack.forEachIndexed { index, c ->
        numArray[index] = c
    }

    return String(numArray)
}


var answer = StringBuilder()
fun mySolution(number: String, k: Int): String {

    val len = number.length - k
    var start = 0
    val arr = number.toCharArray()

    var max = '0'
    var idx = 0
    while (answer.length < len) {
        max = arr[start]
        idx = start
        for (i in start until (arr.size - (len - answer.length - 1))) {
            if (max < arr[i]) {
                idx = i
                max = arr[i]
            }
        }
        answer.append(max)
        start = idx + 1
    }

    return answer.toString()
}

