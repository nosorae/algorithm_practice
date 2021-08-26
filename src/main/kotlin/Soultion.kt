import java.io.*
import java.util.*

/**
 * 21.08.26
 * BOJ 14500 테트로미노
 * https://www.acmicpc.net/problem/14500
 * 백준선생님의 풀이
 * 재귀함수로 해결 ㅗ 모양을 제외하면 모두 한점에서 시작해서 연속 3번 방문하는 모양임에 유의
 * ㅗ 는 재귀함수로 할 수 없으니 ㅗ 만 따로 떼어 for 문으로 처리한다.
 * 그럼 이 문제가 dfs 로 풀 수 있다고 해야하나? ㄴㄴ 모든 정점을 한번만 방문한다는 dfs 의 목적과 맞지 않다.
 * 같은 곳을 두번 방문하는 경우가 필요하다. 그래서 이 경우에는 dfs 가 아닌 부르트포스이다.
 * 코드로는 한줄차이지만 시간복잡도는 크게 차이난다.
 * cnt == 4 면 최대값 갱신
 * 범위조건
 * 방문여부 check
 * 재귀하기 전 check 하고 나와서 check 를 풀어줘야한다.
 * check 를 푸는 부분이 dfs 와의 차이이다.
 * 한번 더 방문하는 경우가 생기기 때문에 check 를 풀어주는 것이다.
 * ㅗ 까지 dfs 로 처리하는 것은 코드상 비효율 적이다.
 *
 *
 */

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
