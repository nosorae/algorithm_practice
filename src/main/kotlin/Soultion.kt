import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 2021.08.28
 * BOJ
 *
 */
val INPUT = "NCJAEZRCLASJLYODEPRLYZRCLASJLCPEHZDTOPDZQLNZTY"
fun main() {

    for (i in 0 until 13) {
        if (13 - i > 0) {
            println("Case Key ${13-i} : ${decryptToPlainText(13-i)}")
        }

        if (i == 0) continue

        if (13 + i < 26) {
            println("Case key ${13+i} : ${decryptToPlainText(13+i)}")
        }
    }

}


private fun decryptToPlainText(key: Int): String =
    INPUT
        .lowercase()
        .map {
            if (it - key < 'a') {
                val dist = 'a' - (it - key)
                'z' - dist + 1
            } else {
                (it - key)
            }
        }.joinToString("") { "$it" }



//answer : cryptography and steganography are two sides of a coin

