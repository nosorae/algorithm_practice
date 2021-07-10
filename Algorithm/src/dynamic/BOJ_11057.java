package dynamic;

/*
 * 2021.07.09
 * BOJ 11057 오르막수 https://www.acmicpc.net/problem/11057
 * 주어진 N길이만큼의 오르막수를 만드는 개수를 구하는 문제
 * d[i][j]를 j로 끝나는 i길이의 오르막수 개수로 정의한다.
 * d[i][j]는 d[i-1][k] (0<=k<=j)의 합이다.
 * 시간복잡도는 사실상 O(N)이다?(for문두개는 N^2은 크기가 9로 무시할 수 있다.) 입력의 크기가 최대 
 */

import java.util.*;
import java.io.*;
public class BOJ_11057  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= 9; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k]%10007;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i <= 9; i++) {
			ans += dp[n][i];
		}
		bw.write((ans%10007)+""); bw.flush();
	}

}


