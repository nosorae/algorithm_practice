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
    println(text.indices)
    println(text.iterator().next()) // A
    println(" ".isBlank()) // true
    println(" ".isEmpty()) // false
    println(" ".isNotBlank()) // false
    println(" ".isNotEmpty()) // true
    println(" ".isNullOrBlank()) // true
    println(" ".isNullOrEmpty()) // false
    println(text.indexOf('d', 5)) // 6
    println(text.indexOf("ev", 5)) // 9
    println(text.indexOf("ev", 10)) // -1
    println(text.indexOfFirst { c -> c > 'a'}) // 1
    println(text.indexOfLast { c -> c > 'a' }) // 17
    println(text.indexOfAny(listOf("and", "And", "roid", "developers"))) // (0, And)
    println(text.indexOfAny(listOf("and", "roid", "developers"))) //  (3, roid)
    println(text.indexOfAny(listOf("and", "developers"))) //  (8, developers)

    println("\n[L]")
    println(text.lowercase()) // android developers
    println(text.last()) // s
    println(text.last { c -> c < 's'}) // r
    println(text.lastOrNull()) // s
    println(text.length) // 18
    println(text.lastIndexOf('p')) // 14
    println(text.lastIndexOf("pe")) // 14
    println(text.lastIndexOf("an", ignoreCase = true)) // 0
    println(text.lastIndexOf("an", 3, ignoreCase = true)) // 0
    println(text.lastIndexOfAny(listOf("and", "And", "roid", "developers"))) // 8
    println(text.lastIndexOfAny(listOf("developers", "and", "And"))) //  8
    println(text.lastIndexOfAny(listOf("and", "developers"))) //  8
    println(text.lastIndex) // 17
    println(text.lineSequence())
    println(text.lines())

    println("\n[M]")
    println(text.map { c -> c.code })
    println(text.map { c -> null })
    println(text.mapIndexed { i, c -> "${c.code} $i"})
    println(text.matches(Regex("o")))
    println(text.mapIndexedNotNull { index, c -> null})
    println(text.maxOf { c -> c.code }) // 비었으면 예외 // 118
    println(text.maxOfOrNull {c -> c.code }) // 비면 null 반환 //118
    println(text.minOf { c -> c.code }) // 32
    println(text.minOfOrNull { c -> c.code }) // 32
    println(text.minOfWith(Comparator<Int> { o1, o2 -> if (o1 == o2) 0 else if (o1 < o2) 1 else -1 }) { c -> c.code }) // 내림차순일 때 min // 118
    println(text.minOfWithOrNull(Comparator<Int> { o1, o2 -> if (o1 == o2) 0 else if (o1 < o2) 1 else -1 }) { c -> c.code }) // 내림차순일 때 min // 118
    println(text.maxOfWith(Comparator<Int> { o1, o2 -> if (o1 == o2) 0 else if (o1 < o2) 1 else -1 }) { c -> c.code }) // 내림차순일 때 max // 32
    println(text.maxOfWithOrNull(Comparator<Int> { o1, o2 -> if (o1 == o2) 0 else if (o1 < o2) 1 else -1 }) { c -> c.code }) // 내림차순일 때 max // 32


    println("\n[O]")
    text.orEmpty()


    println("\n[P]")
    println(text.plus(1))
    println(text + 1)
    println(text.padStart(20, '['))
    println(text.padEnd(20, ']').padStart(22, '['))
    println(text.partition { c -> c > 'l' })
    println(text.prependIndent())

    println("\n[R]")
    println(text.random())
    println("".randomOrNull()) // null
    println(text.reversed()) // srepoleveD diordnA
    println(text.repeat(3)) // Android developersAndroid developersAndroid developers
    println(text.replace('d', '-')) // An-roi- -evelopers
    println(text.repeat(3).replace("dev", "-")) // Android -elopersAndroid -elopersAndroid -elopers
    println("-".repeat(3).replace("dev", "-")) // Android -elopersAndroid -elopersAndroid -elopers
    println(text.replace(Regex("d."), "-")) // An-oi--velopers
    println(text.replaceFirst('d', '-'))
    println(text.replaceAfter('d', "|replacement|"))
    println(text.replaceAfterLast('d', "|replacement|"))
    println(text.replaceBefore('d', "|replacement|"))
    println(text.replaceBeforeLast('d', "|replacement|"))
    println(text.replaceRange(0, 3, "-"))
    println(text.replaceRange(0..3, "-")) // -oid developers
    println(text.removePrefix("An")) // droid developers
    println(text.removePrefix("-")) // Android developers
    println(text.removeSuffix("rs")) // Android develope
    println(text.removeSuffix("-")) // Android developers
    println(text.removeRange(0, 3)) // roid developers
    println(text.removeRange(0..3)) // oid developers
    println(text.removeSurrounding("An", "An")) // Android developers
    println(text.removeSurrounding("An", "rs")) // droid develope
    println(text.runningFold(0) {a, c -> a + c.code})


    println("\n[S]")
    println(text.substring(0..3)) // Andr
    println(text.substring(0, 3)) // And
    println(text.substring(3)) // roid developers
    println(text.substringAfter(delimiter = 'd', "default")) // roid developers
    println(text.substringAfter(delimiter = '-', "default")) // default
    println(text.substringAfterLast(delimiter = 'd', "default")) // evelopers
    println(text.substringBefore(delimiter = 'd', "default")) // An
    println(text.substringBeforeLast(delimiter = 'd', "default")) // Android  (' ' space 있음 주의)
    println(text.slice(0..3))
    println(text.slice(listOf(0, 5, 17)))
    println(text.startsWith("a", 1, true)) // false
    println(text.startsWith("a", 0, true)) // true
    println(text.startsWith("a")) // false
    println(text.startsWith("A")) // true
    println(text.split("d")) // [An, roi,  , evelopers]
    println(text.split("d", limit = 2)) // [An, roi,  , evelopers]
    println(text.split("A")) // [, ndroid developers]
    println(text.split("A")) // [, ndroid developers]
    println(text.split('d')) // [An, roi,  , evelopers]
    println(text.split(Regex("d."))) // [An, oi, , velopers]
    println("dd".split("d")) // [, , ]
    println(text.scan(0) { a, c -> a + c.code })

    println("\n[T]")
    println("1A".toInt(16))
    println("13".toInt())
    println(text.toIntOrNull())
    println(text.trim())
    println(text.trimEnd())
    println(text.trimStart())
    println(text.trim { c -> c > 'd'})
    println(text.trimEnd { c -> c > 'd'})
    println(text.trimStart { c -> c > 'd'})

    println(text.take(5)) // Andro
    println(text.takeLast(5)) // opers
    println(text.takeWhile { c -> c > 'd' }) //
    println(text.takeWhile { c -> c < 'e' }) // A
    println(text.takeLastWhile { c -> c > 'd' }) // evelopers

    println("\n[U]")
    println(text.uppercase()) // ANDROID DEVELOPERS

    println("\n[W]")
    println("abcd".windowed(3, 1, true)) // [abc, bcd, cd, d]
    println("abcd".windowed(3, 1, false)) // [abc, bcd]
    println(text.windowed(5, 5, true)) // [Andro, id de, velop, ers]
    println(text.windowed(5, 1, false)) // [Andro, ndroi, droid, roid , oid d, id de, d dev,  deve, devel, evelo, velop, elope, loper, opers]
    println(text.windowed(5, 1, false) { c -> "${c}_"})
    println(text.windowed(5, 1, false).map { c -> "${c}_"})


    println("\n[Z]")
    println(text.zip("other string"))
    println(text.zip("other string") { c1, c2 -> c1.code + c2.code })
    println(text.zipWithNext())
    println(text.zipWithNext { a, b -> a.code+b.code  })


    //println(text.coerceAtLeast("a"))
    //println(text.coerceAtMost("a"))
    //println(text.coerceIn("a".."c"))
}