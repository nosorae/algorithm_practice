package playground.data_structure

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() {
    val queue: Queue<Int> = LinkedList()
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)

    val stack: Stack<Int> = Stack()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)

    printPeekElements(
        queue = queue,
        stack = stack
    )

    queue.remove()
    stack.pop()

    printPeekElements(
        queue = queue,
        stack = stack
    )
}

private fun printPeekElements(queue: Queue<Int>, stack: Stack<Int>) {
    println("queue ${queue.peek()}")
    println("stack ${stack.peek()}")
}