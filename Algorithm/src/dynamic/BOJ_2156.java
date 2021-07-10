package dynamic;

/*
 * 2021.07.10
 * BOJ 2156 포도주시식 https://www.acmicpc.net/problem/2156
 * 연속 세잔은 못마시고 각각의 포도주잔에 포도주 양이 음이 아닌 정수로 주어졌을 때 먹은 양의 최대값을 구하는 문제
 * d[i][j]를 i번째 포도잔까지 고려했을 때 j번째 연속까지 마신 포도주 양의 최대값으로 정의한다. 
 * d[i][0] = d[i-1][j] (0 <= j <= 2) 중에 최대이다.
 * d[i][1] = d[i-1][0] + size[i];
 * d[i][2] = d[i-1][1] + size[i]; 
 * 
 */

import java.util.*;
import java.io.*;
public class BOJ_2156  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[10001][3];
		int[] size = new int[10001];
		for(int i = 1; i <= n; i++) {
			size[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][1] = size[1];
		dp[2][0] = dp[1][1];
		dp[2][1] = size[2];
		dp[2][2] = dp[1][1] + size[2];
		for(int i = 3; i <= n; i++) {
			dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
			dp[i][0] = max(dp[i][0], dp[i-1][2]);
			dp[i][1] = dp[i-1][0] + size[i];
			dp[i][2] = dp[i-1][1] + size[i];
		}
//		for(int i = 1; i <= n; i++) {
//			bw.write(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]+"\n");
//		}
		int ans = max(dp[n][0], dp[n][1]);
		ans = max(ans, dp[n][2]);
	
		bw.write(ans+"");
		bw.flush();
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


