package dynamic;

/*
 * 2021.07.11
 * BOJ 11722 가장 긴 감수하는 부분 수열 https://www.acmicpc.net/problem/11722
 * d[i]를 인덱스 i까지 고려했을 때  가장 긴 감소하는 부분 수열로 정의한다.
 * d[i]는 d[j] (0 <= j < i)중에  val[j] > val[i] 중에 d[j]가 최대인 d[j]+1이다.
 */   

import java.util.*;
import java.io.*;
public class BOJ_11722  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] value = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(value[j] > value[i] && dp[j] + 1 > dp[i] ) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans = max(ans, dp[i]);
			//bw.write(dp[i]+" ");
		}
		//bw.write("\n");
		bw.write(ans+""); bw.flush();
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


