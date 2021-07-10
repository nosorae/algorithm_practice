package dynamic;

/*
 * 2021.07.08
 * BOJ 1149 RGB거리 
 * 색 3개와 집의 길이가 N으로 주어졌을 때 인접한 집의 색이 같지 않게 칠하는 비용의 최솟값을 구하는 문제
 * d[i][j]를 i번째 집을 j색으로 칠하는 비용의 최솟값으로 정의한다.
 * d[i][0]은 min(d[i-1][1], d[i-1][2]) + cost[0]과 같다.
 * d[i][1]과 d[i][2]도 마찬가지다.
 * d[1][0], d[1][1], d[1][2]를 각각 cost[0] cost[1] cost[2]로 초기화한다.
 * 전체 시간복잡도는 O(N)이다.
 * 각 집마다 RGB 각각을 칠하는 비용이 다르다
 */

import java.util.*;
import java.io.*;
public class BOJ_1149  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n+1][3];
		int[][] dp = new int[n+1][3];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[1][0] = cost[1][0];
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		for(int i = 2; i <= n; i++) {
			dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}

		int ans = min(dp[n][0], dp[n][1]);
		ans  = min(ans, dp[n][2]);
		bw.write(ans+"\n");			
		bw.flush();

	}
	static int min(int a, int b) {
		return a < b ? a : b;
	}

}