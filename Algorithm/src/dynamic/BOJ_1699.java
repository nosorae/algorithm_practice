package dynamic;


/*
 * 2021.07.08
 * BOJ 1699 제곱수의 합
 * 어떤 정수를 그보다 작은 수들의 제곱수들의 합으로 표현할 수 있는데, 항의 최소값을 찾는 문제.
 * d[i]를 i의 제곱수의 합들 중에 최소항의 개수로 정의한다.
 * d[i] d[i-1^2], d[i-2^2], d[i-3^2] ... d[0] 중에 최소 값을 고르고 +1한 값이 된다.
 * d[1] = 1로 초기화한다.
 * d[i]하나를 구하는데 필요한 최대시간은 루트 10만 대략 300쯤 된다. 따라서 10만에 300곱해도 3천만으로 할만하다.
 */

import java.util.*;
import java.io.*;
public class BOJ_1699  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1]+1;
			for(int j = 2; j*j <= i; j++) {
				dp[i] = min(dp[i-j*j]+1, dp[i]);
			}
		}
		bw.write(dp[n]+""); bw.flush();
		
	}
	static int min(int a, int b) {
		return a < b ? a : b;
	}
}