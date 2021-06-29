package bruteforce;
/*
 * BOJ 18290 NM과 K (1) 
 * 2차원 배열 각 원소중에서 K개 선택한 모든 조합중에서 선택된 원소들의 합이 가장 클 때 합을 출력
 * 근데 선택된 K개가 인접하면 안된다는 조건이 있다.
 * 매 재귀마다 NM개를 다 고려하려니 NM^K라서 최대 100^4로 시간초과한다. 
 * 그러니 이전 재귀에서 선택한 원소들은 제외하고 재귀해야한다. 즉 중복연산을 줄인다!!
 * max를 static으로 안하고 푸는 방법은 없을까? 재귀에서 return을 이용해서 매번 최대값을 확인해주는 방식말이다.
 * 문제조건을 똑바로 읽어라!!! 원소값의 범위는 -10000부터 10000까지다. 근데 나는 max를 0으로 초기화 했으니 
 * 최대값이 음수인 경우는 답이 0으로밖에 안나왔다. 
 * max min을 구할 때는 초기화값을 잘 신경쓰자!!
 */
import java.util.*;
import java.io.*;
public class BOJ_18290 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	static int m;
	static int k;
	static int[][] arr;
	static boolean[][] check;
	static long max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new boolean[n][m];
		max = -1000001;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pickAllCase(0, 0, 0, 0);
		System.out.println(max);
	}
	
	static void pickAllCase(int startX, int startY, int depth, long sum) {
		if(depth == k) {
			if(max < sum)
				max = sum;
			return;
		}
		for(int x = startX; x < n; x++) {
			for(int y = (startX == x ? startY : 0); y < m; y++) {
				// 방문한 이력이 없어야한다.
				if(!check[x][y]) {
					//인접한 네방향에 방문한 이력이 없어야 한다.
					boolean flag = true;
					for(int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(isIn(nx, ny) && check[nx][ny])
							flag = false;
					}
					if(flag) {
						check[x][y] = true;
						pickAllCase(x, y, depth+1, sum+arr[x][y]);
						check[x][y] = false;
					}
				}
			}
		}
		
	}
	static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m) 
			return true;
		else
			return false;
	}
	
}



