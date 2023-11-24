package playground.grammar


fun main() {
    val a = Alphabet.C

    test(Alphabet.A(1))
    test(Alphabet.B(1))
    test(Alphabet.C)
    test(Alphabet.D)
    test(Alphabet.E)
    test(Alphabet.F)
}

fun test(a: Alphabet) {
    when (a) {
        is Alphabet.A,
        is Alphabet.B,
        is Alphabet.D -> {
            println("1")
        }
        is Alphabet.C,
        is Alphabet.E,
        is Alphabet.F -> {
            println("2")
        }
    }
}


sealed class Alphabet {
    data class A(val a: Int) : Alphabet()
    data class B(val a: Int) : Alphabet()
    object C : Alphabet()
    object D : Alphabet()
    object E : Alphabet()
    object F : Alphabet()
}