package dynamic;

/*
 * 2021.07.08
 * BOJ 16194 카드 구매하기2
 * p1 ~ pN의 값이 주어질 때 N을 채우는 합의 최소를 구하는 문제
 * N제한 1~1000
 * dp[n]을 구하기 위해선dp[0] + p(n), dp[1]+p(n-1), dp[2]+p(n-2), ... dp[n-1]+p(1) 중에서 최소를 골라야한다.
 */
import java.util.*;
import java.io.*;
public class BOJ_16194 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] p = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		dp[1] = p[1];
		for(int i = 2; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i; j++) {
				if(dp[i] > dp[j] + p[i-j])
					dp[i] = dp[j] + p[i-j];
			}
		}
		System.out.println(dp[n]);
	}
}
		
