package util.math

private fun gcd(a: Int, b: Int): Int {
    return if (a % b == 0) b else gcd(b, a % b)
}