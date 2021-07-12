package dynamic;

/*
 * 2021.07.11
 * BOJ 11054 가장 긴 바이토닉 부분 수열 https://www.acmicpc.net/problem/11054
 * 어떤 수 기점까지 오름차순이다가 그 수 기점으로 내림차순되는 부분 수열을 바이토닉 부분 수열이라하는데 최대길이를 찾는 문제
 * d[i]를 0부터 i까지 방향으로 고려했을 때 가장 긴 증가하는 부분수열로 정의하고
 * d2[i]를 n-1부터 i까지 방향으로  고려했을 때 가장 긴 증가하는 부분수열로 정의한다. 
 * 그리고 d[i]+d2[i] ( 0 <= i < n ) 중에서 최대를 구하고 거기에 -1해서 답을 낸다.
 * 나머지 점화식은 이전에 풀었던 문제(가장 긴 증가, 감소하는 부분수열)와 동일하다.
 */   

import java.util.*;
import java.io.*;
public class BOJ_11054_HARD  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] up = new int[n];
		int[] down = new int[n];
		int[] val = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			val[i] = Integer.parseInt(st.nextToken());
			up[i] = down[i] = 1;
		}
		//0부터 오른쪽으로 가장 긴 증가하는 부분수열
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(val[j] < val[i] && up[i] < up[j]+1) {
					up[i] = up[j]+1;
				}
			}
		}
		//n-1부터 왼쪽으로 가장 긴 증가하는 부분수열 
		for(int i = n-1; i >= 0; i--) {
			for(int j = n-1; j > i; j--) {
				if(val[i] > val[j] && down[i] < down[j]+1) {
					down[i] = down[j]+1;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(ans < up[i]+down[i]) 
				ans = up[i]+down[i];
		}
		bw.write((ans-1)+""); bw.flush();
	}
}


