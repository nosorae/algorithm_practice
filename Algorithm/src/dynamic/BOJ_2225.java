package dynamic;

/*
 * 2021.07.08
 * BOJ 2225 합분해 https://www.acmicpc.net/problem/2225
 * 0부터 N까지의 수 K개를 더해서 합이 N이 되는 경우의 수를 구하는 문제
 * d[i][j]를 0부터 i까지 수 중에 j개를 더해서 그 합이 i가 되는 경우의 수로 정의한다.
 * d[i][j]는 d[i-u][j-1] (0 <= u <= i) 의 합이다.
 * d[0][i] (0 <= i <= K)을 1로 설정한다.
 * 이 문제도 답에 나머지 연산을 하라는 거 보니 답이 아주 커질 수 있으니 long을 써준다.
 */

import java.util.*;
import java.io.*;
public class BOJ_2225  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[][] dp = new long[n+1][k+1];
		for(int i = 1; i <= k; i++) {
			dp[0][i] = 1; 
		}
		for(int i = 1; i <= n; i++) {
			dp[i][1] = 1;
		}
		for(int i = 2; i <= k; i++) { // 열 
			for(int j = 1; j <= n; j++) { // 행
				for(int u = 0; u <= j; u++) { // 전 열의 0~j의 모든 dp원소의 합 
					dp[j][i] += dp[u][i-1]%1000000000;
				}
				dp[j][i] %= 1000000000;
			}
		}
		bw.write(dp[n][k]+""); bw.flush();
	}
	
}