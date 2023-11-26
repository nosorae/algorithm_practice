package util.math

fun isPrime(number: Int): Boolean {
    if (number < 2) return false
    var i = 2
    while (i * i <= number) {
        if (number % i == 0) return false
        i++
    }
    return true
}