package util.math

fun factorial(n: Int): Long {
    var result = 1L
    for (i in 2..n) {
        result *= i
    }
    return result
}

fun permutation(n: Int, r: Int): Long {
    return factorial(n) / factorial(n - r)
}

fun combination(n: Int, r: Int): Long {
    return factorial(n) / (factorial(r) * factorial(n - r))
}

fun main() {
    val n = 5
    val r = 3

    println("Permutation ($n P $r): ${permutation(n, r)}")
    println("Combination ($n C $r): ${combination(n, r)}")
}