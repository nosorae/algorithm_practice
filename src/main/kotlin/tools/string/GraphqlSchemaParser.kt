package tools.string


fun main() {
    val result = parseDataClass(
        ""
    )
    print(result)
}

private fun parseSchemaTypeWithDescription(text: String): String {
    val list =  text.split("\n")
    val sb = StringBuilder()
    var i = 0
    while (i in list.indices) {
        if (list[i].contains("\"")) {
            sb.append("\t\t${list[i+1].trim()}")
            sb.append("\t// ${list[i].trim()}\n")
            i += 2
        } else {
            sb.append("\t\t${list[i].trim()} \n")
            i += 1
        }
    }
    return sb.toString()
}

private fun parseSchemaTypeWithType(text: String): String {
    val list =  text.split("\n")
    val sb = StringBuilder()
    var i = 0
    while (i in list.indices) {
        if (list[i].contains("\"")) {
            sb.append("${list[i+1].trim()}\n")
            i += 2
        } else {
            sb.append("${list[i].trim()} \n")
            i += 1
        }
    }
    return sb.toString()
}

private fun parseDataClass(text: String): String {
    return text.split("\n").filter { it.contains("public val") }.map { it.trim().drop(11) }.joinToString("\n") { it }
}