package dynamic;

/*
 * 2021.07.08
 * BOJ 11053 가장 긴 증가하는 부분수열 https://www.acmicpc.net/problem/11053
 * 점화식의 정의를 i 앞의 수 중에서 그리고 지금 자신(i)보다 작은 수 중에서 그 작은 수까지의 가장 긴 수열을 가지고 있는 수 + 1 로 정의한다.
 * 그럼 점화식은 dp[i] = if(A[i] > A[i-j]) max(dp[j]) ( 1 <= i < n, 0 <= j < i )
 * 초기화는 dp의 모든 원소는 1로 초기화하면 된다. 숫자 하나는 무조건 가장 긴 증가하는 부분수열에 해당하기 때문이다. 따라서 최소값을 1로 표현하면 된다.
 * 그리고 마지막에는 dp의 원소값중에 max를 찾아주면 된다.
 * 시간복잡도는 O(N^2)이다.
 */

import java.util.*;
import java.io.*;
public class BOJ_11053 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] values = new int[n];
		int[] dp = new int[n];
		StringTokenizer st =  new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) dp[i] = 1;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(values[j] < values[i] && dp[j] + 1 > dp[i])
					dp[i] = dp[j] + 1;
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(max < dp[i])
				max = dp[i];
		}
		bw.write(max+""); bw.flush();
	}
}