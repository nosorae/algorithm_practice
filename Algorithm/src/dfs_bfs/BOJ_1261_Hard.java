package dfs_bfs;
/*
 * 2021.07.11
 * BOJ 1261 알고스팟 https://www.acmicpc.net/problem/1261
 * 이것도 가중치가 0과 1인 bfs로 볼 수 있다. 정답의 핵심은 부숴야하는 벽 개수이기 때문이다.
 * 이동하려는 곳이 벽일 때는 1, 아닐 때는 0을 쓰면 된다.
 * 문제를 똑바로 읽자 n이 가로크기(열길이) m이 세로크기(행길이)라고 나와있다. 반대로해서 삽질했다..
 * 두개짜리를 앞으로 넣을 때는 순서 반대로해야한다. 이런 실수를 방지하기 위해서는 x큐 y큐 따로 쓰거나
 * 앞으로 넣을 때는 순서를 바꿔줘야한다. a b를 차례대로 앞으로 넣어도 뺄때는 b, a순서로 나온다.
 */
import java.util.*;
import java.io.*;
public class BOJ_1261_Hard  {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0}; //동서남북
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[m+1][n+1];
		for(int i = 1; i <= m; i++) {
			String input = br.readLine();
			for(int j = 1; j <= n; j++) {
				map[i][j] = input.charAt(j-1) - '0';
			}
		}

		bw.write(bfs(map, m, n)+""); bw.flush();

	}
	static int bfs(int[][] map, int n, int m) {
		int[][] dist = new int[n+1][m+1];
		boolean[][] check = new boolean[n+1][m+1];
		
		Deque<Integer> q = new LinkedList<Integer>();
		dist[1][1] = 1;
		q.addFirst(1); q.addFirst(1);

		
		while(!q.isEmpty()) {
			int curX = q.removeFirst();
			int curY = q.removeFirst();

			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(isIn(n, m, nx, ny) && !check[nx][ny]) {
					if(map[nx][ny] == 1) {
						dist[nx][ny] = dist[curX][curY]+1;
						q.addLast(nx); q.addLast(ny);
					}
					else {
						dist[nx][ny] = dist[curX][curY];
						//이 부분을 주의해야한다. 앞으로 넣는 것은 순서 반대로 해야 뺄 때 순서맞게 나온다.
						q.addFirst(ny); q.addFirst(nx);
					}
					check[nx][ny] = true;

				}
			}
		}
		return dist[n][m]-1;
	}
	static boolean isIn(int n, int m, int nx, int ny) {
		if(nx >= 1 && nx <= n && ny >= 1 && ny <= m) return true;
		else return false;
	}
}




