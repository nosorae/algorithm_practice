package dynamic;


/*
 * 2021.07.10
 * BOJ 1932 정수삼각형 https://www.acmicpc.net/problem/1932
 * d[i][j]을 i행까지 고려했을 때 마지막에 j열의 숫자를 사용할 때의 최대값으로 정의한다.
 * d[i][j]는 max(d[i-1][j-1], dp[i-1][j]) + val[i][j] 이다.
 * 마지막에 답낼 때는 max(d[n][i]) ( 1<= i <= n)을 답으로 내면 된다. 
 */

import java.util.*;
import java.io.*;
public class BOJ_1932  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		//입력
		int n = Integer.parseInt(br.readLine());
		int[][] value = new int[n+1][n+2];
		int[][] dp = new int[n+1][n+2];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new  StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				value[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//초기화와 점화식 실행
		dp[1][1] = value[1][1];
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + value[i][j];
			}
		}
		
		//답내는 부분 
		int ans = dp[n][1];
		for(int i = 2; i <= n; i++) {
			ans = max(ans, dp[n][i]);
		}
		bw.write(ans+""); bw.flush();	
				
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


