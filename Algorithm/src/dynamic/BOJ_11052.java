package dynamic;

/*
 * 2021.07.08
 * BOJ 11052 카드 구매하기
 * p1 ~ pN의 값이 주어질 때 N을 채우는 합의 최대를 구하는 문제
 * N제한 1~1000
 * dp[n]을 구하기 위해선dp[0] + p(n), dp[1]+p(n-1), dp[2]+p(n-2), ... dp[n-1]+p(1)   중에서 최대를 골라야한다.
 * 이것도 내 과거 풀이가 더 간결하다. 이유는 max변수를 쓰는 대신 dp[n]을 최대 구하는데 썼기 때문이다.
 */
import java.util.*;
import java.io.*;
public class BOJ_11052 {
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
			int max = 0;
			//dp[0] + p(n), dp[1]+p(n-1), dp[2]+p(n-2), ... dp[n-1]+p(1) 에서 최대
			for(int j = 0; j < i; j++) {
				if(max < dp[j] + p[i-j])
					max = dp[j] + p[i-j];
			}
			dp[i] = max;
		}
		System.out.println(dp[n]);
	}
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.StringTokenizer;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int num = Integer.parseInt(br.readLine());
//		int[] p = new int[num+1];
//		int[] answer = new int[num+1];
//		
//		String str = br.readLine();
//		StringTokenizer st = new StringTokenizer(str);
//		for(int i = 1; i <= num; i++) {
//			p[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		answer[1] = p[1];
//		for(int i = 2; i <= num; i++) {
//			for(int j = 1; j <= i; j++) {
//				if(answer[i] < answer[i - j] + p[j])
//					answer[i] = answer[i-j] + p[j];
//			}
//			
//		}
//		
//		System.out.println(answer[num]);
//		
//		
//
//	}
//}



		
