package dynamic;
/*
 * 2021.07.08
 * BOJ 2193 이친수 https://www.acmicpc.net/problem/2193
 * 길이가 주어질 때, 0으로 시작 못하고 1이 연속해서 나오지 않는 이진수의 개수를 구하는 문제
 * 점화식을 길이가 i일때 0으로 끝나는 개수와 1로 끝나는 개수를 따로 생각해주면 된다. 
 */


import java.util.*;
import java.io.*;
public class BOJ_2193 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][2];
		dp[1][1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		bw.write((dp[n][0]+dp[n][1])+"");
		bw.flush();
	}
}