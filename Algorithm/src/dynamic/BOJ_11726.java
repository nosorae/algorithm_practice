package dynamic;

/*
 * 2021.07.08
 * BOJ 11726 2*n 타일링 https://www.acmicpc.net/problem/11726
 * 2*n크기의 직사각형을 2*1 1*2 타일로 채우는 방법의 수를 구하는 문제
 * 2*N크기의 직사각형은 2*N-2에서 1*2두개 쌓아두는 방법 + 2*N-1에서 2*1 하나 두는 방법으로 표현할 수 있다. 
 */
import java.util.*;
import java.io.*;
public class BOJ_11726 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		System.out.println(dp[n]);
	}
}
		
