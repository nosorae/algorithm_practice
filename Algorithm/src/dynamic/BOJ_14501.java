package dynamic;


/*
 * 2021.07.08
 * BOJ 14501 퇴사 https://www.acmicpc.net/problem/14501
 * 상담일별로 페이와 상담기간이 주어질 때 n+1일 까지의 페이합의 최대를 구하는 문제
 * d[i]를 i일까지 고려했을 때 페이합의 최대로 정의한다.
 * d[i]는 p[i]+i가 n+1보다 작거나 같고, 이전 d[k] (0 <= k < i)들 중에 상담이 끝났으면서 기존의 페이의 합이 가장 큰 날짜를 선택한다.
 * 저번에 브루트포스로도 풀었으니 참고 (선택하고 안하고로 재귀함수의 파라미터를 조절하며 재귀해서 해결)
 */

import java.util.*;
import java.io.*;
public class BOJ_14501  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		int[] pay = new int[n];
		int[] dp = new int[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		if(time[0] <= n)
			dp[0] = pay[0];
		for(int i = 1; i < n; i++) {
			if(i + time[i] > n)
				continue;
			dp[i] = pay[i];
			for(int j = 0; j < i; j++) {
				if(j+time[j] <= i && dp[i] < pay[i] + dp[j])
					dp[i] = pay[i] + dp[j];
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