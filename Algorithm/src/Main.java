
/*
 * 2021.07.10
 * BOJ 11055 가장 큰 증가 부분 수열 https://www.acmicpc.net/problem/11055
 * d[i]를 인덱스 i까지 고려했을 때 합이 가장 큰 증가 부분 수열로 정의한다.
 * d[i]는 d[j] (0 <= j < i)중에  val[j] < val[i] 중에 d[j]가 최대인 d[j] + val[i]이다.
 */

import java.util.*;
import java.io.*;
public class Main  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] value = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			dp[i] = value[i];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(value[j] < value[i] && dp[i] < dp[j]+value[i]) {
					dp[i] = dp[j]+value[i];
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans = max(ans, dp[i]);
		}
		bw.write(ans+""); bw.flush();
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


