package tools.string

fun main() {
    val text = "Android developers"
    println("\n[A]")
    println(text.all { c -> c <= 'z' }) // true
    println(text.all { c -> c <= 'b' }) // false
    println(text.associate { c -> c to (c.code) })

    println("\n[C]")
    println(Regex("d d") in text)
    println("b".compareTo("c"))
    println("c".compareTo("c"))
    println("z".compareTo("c"))
    println("A".compareTo("c"))
    println(text.compareTo("c"))
    println(text.codePointAt(0))
    println(text.codePointAt(1))
    println(text.contentEquals("Android developer"))
    println(text.contentEquals("Android developers"))
    println(text.chunked(2))
    println(text.chunked(5))
    println(text.chunked(2) { c -> "${c}_"})
    println(text.commonPrefixWith("android experts", true))
    println(text.commonPrefixWith("android experts", false))
    println(text.count())
    println(text.lowercase().count { c -> c > 'b'})

    println("\n[D]")
    println(text.drop(1))
    println(text.drop(3))
    println(text.dropLast(1))
    println(text.dropLast(3))
    println(text.dropLastWhile { c -> c > 'a' })
    println(text.dropLastWhile { c -> c == 's' })

    println("\n[E]")
    println(text.elementAtOrNull(1))
    println(text.elementAtOrNull(100))
    println(text.elementAtOrElse(1) { n -> 'd'})
    println(text.elementAtOrElse(100) { n -> 'd'})
    println(text.endsWith("devleo"))
    println(text.endsWith("pers"))

    println("\n[F]")
    println(text.filter { c -> c > 'a'})
    println(text.filterNot { c -> c > 'a' })
    println(text.filterIndexed { idx, c -> idx < 7 && c > 'a'})
    println(text.first()) // A
    println(text.first { c -> c > 'a'}) // n
    println(text.firstOrNull { c -> c > 'a'}) // n
    println(text.find { c -> c > 'a' }) // n
    println(text.findLast { c -> c > 'a' }) // s
    println("입력된 숫자는 %d 입니다.".format(7))
    println(text.findAnyOf(listOf("and", "And", "roid", "developers"))) // (0, And)
    println(text.findAnyOf(listOf("and", "roid", "developers"))) //  (3, roid)
    println(text.findAnyOf(listOf("and", "developers"))) //  (8, developers)
    text.forEach { c -> print(c) } // Android developers
    println()
    println(text.flatMap { c -> listOf(c, c) }) // [A, A, n, n, d, d, r, r, o, o, i, i, d, d,  ,  , d, d, e, e, v, v, e, e, l, l, o, o, p, p, e, e, r, r, s, s]
    println(text.flatMapIndexed { index, c -> listOf(c, c) })
    println(text.fold("") { r, c -> "$r${c}_" }) //A_n_d_r_o_i_d_ _d_e_v_e_l_o_p_e_r_s_
    println(text.foldRight("") {c, r -> "$r${c}_"}) // s_r_e_p_o_l_e_v_e_d_ _d_i_o_r_d_n_A_
    println(text.foldRight("") {c, r -> "$r$c"}) // srepoleved diordnA


    println("\n[G]")
    println(text[1]) // n
    println(text.getOrNull(1)) // n
    println(text.getOrNull(100)) // null
    println(text.getOrElse(1) { n -> 'd'}) // n
    println(text.getOrElse(100) { n -> 'd'}) // d
    println(text.groupBy { c -> c })
    println(text.groupBy { c -> "c" })
    println(
        text.groupBy(
        keySelector = {c -> c},
        valueTransform = {c -> "${c}변형"}
        )
    )


    println("\n[I]")




    //println(text.coerceAtLeast("a"))
    //println(text.coerceAtMost("a"))
    //println(text.coerceIn("a".."c"))
}