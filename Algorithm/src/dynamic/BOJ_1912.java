package dynamic;

/*
 * 2021.07.08
 * BOJ 1912 연속합 https://www.acmicpc.net/problem/1912
 * 배열에 정수가 주어지면  연속하는 한개 이상의 수들의 합중에서 최대 값을 구하는 문제
 * 입력이 10만이기때문에 d[i]하나를 구하는 시간 복잡도는 O(1)이 되어야한다. 그래야 전체 시간복잡도가 O(N)이다.
 * 그리고 values의 원소값의 범위는 -1000부터 시작하므로 최대값 구할 때 음수도 고려해야한다.
 * d[i]는 i번째 수까지 고려했을 때 연속합의 최대값으로 정의한다.
 * d[i]는 d[i-1]+val[i] 또는  val[i] 중에 큰 수이다.
 * 모든 d[i]는 val[i]로 초기화한다.
 */

import java.util.*;
import java.io.*;
public class BOJ_1912  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] values = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = values[0];
		for(int i = 1; i < n; i++) {
			dp[i] = max(dp[i-1]+values[i], values[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			if(max < dp[i])
				max = dp[i];
		}
		bw.write(max+""); bw.flush();
		
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}