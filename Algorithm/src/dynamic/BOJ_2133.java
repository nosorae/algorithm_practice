package dynamic;

/*
 * 2021.07.11
 * BOJ 2133 타일 채우기 https://www.acmicpc.net/problem/2133
 * 
 */

import java.util.*;
import java.io.*;
public class BOJ_2133  {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] += dp[i-2]*3;
			for(int j = 4; j <= i; j += 2) {
				dp[i] += dp[i-j]*2;
			}
		}
		bw.write(dp[n]+""); bw.flush();
	}
}


