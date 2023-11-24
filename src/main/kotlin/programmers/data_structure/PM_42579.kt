package programmers.data_structure

/**
 * ⭐️
 * 2023.11.24
 * Level3. 베스트 앨범
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * 해시와 정렬을 합친 문제
 * 장르로 먼저 정렬 후 각 장르의 가장 많은 플레이 수를 가진
 *
 * <다른 사람 풀이 배운 점>
 * index 를 key로 가져야 할 때는 indices -> groupBy를 활용하면 되는구나
 * Map에 toList확장함수가 있었구나 List<Pair<키, 밸류>>로 반환
 */
class Solution42579 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val map = mutableMapOf<String, MutableList<Song>>()
        genres.forEachIndexed { index, genre ->
            val list = map.getOrDefault(genre, mutableListOf())
            list.add(
                Song(
                    id = index,
                    playCount = plays[index]
                )
            )
            map[genre] = list
        }

        val sortedGenre = map.map { entry ->
            Genre(
                genre = entry.key,
                totalPlayCount = entry.value.sumOf {
                    it.playCount
                },
                songs = entry.value.sortedByDescending{ it.playCount }
            )
        }.sortedByDescending { it.totalPlayCount }

        val answer = mutableListOf<Song>()
        sortedGenre.forEach { genre ->
            answer.addAll(genre.songs.take(2))
        }

        return answer.map { it.id }.toIntArray()
    }

    data class Genre(
        val genre: String,
        val totalPlayCount: Int,
        val songs: List<Song>
    )

    data class Song(
        val id: Int,
        val playCount: Int,
    )


    fun solution2(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] } // index 를 key로 가져야 할 때는 indices -> groupBy를 활용하면 되는구나
            .toList() // Map에 toList확장함수가 있었구나 List<Pair<키, 밸류>>로 반환
            .sortedByDescending { it.second.sumOf { plays[it] } }
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten().toList()
            .toIntArray()
    }
}

fun main() {
    val answer = Solution42579().solution(
        genres = arrayOf(
            "classic", "pop", "classic", "classic", "pop"
        ),
        plays = intArrayOf(
            500, 600, 150, 800, 2500
        )
    )

    answer.forEach { print("$it, ") }
}