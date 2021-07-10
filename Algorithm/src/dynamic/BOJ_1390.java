package dynamic;
/*
 * 2021.07.09
 * BOJ 1390 동물원 https://www.acmicpc.net/problem/1309
 * N이 주어졌을 때 2*N개의 칸으로 이루어진 직사각형에 사자들을 가로세로로 인접하지 않게 배치하는 경우의 수를 구하는 문제
 * d[i][j]를 2*i 직사각형에 사자를 가로세로로 인접하지 않게 배치하는데 마지막 i번째에서 j방법으로 놓는 경우의수로 정의한다.
 * 여기서 j는 0또는 1또는 2이고 각각 x x, o x, x o 이렇게 사자를 배치하는 방법이다. 그럼 점화식은 다음과 같다.
 * dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
 * dp[i][1] = dp[i-1][0] + dp[i-1][2]
 * dp[i][2] = dp[i-1][0] + dp[i-1][1]
 * dp[1][0], dp[1][1], dp[1][2] 각각을 1로 초기화한다.
 * 자주쓰이는 변수는 하드코딩하지말고 static final변수로 관리하는 습관을 들이자 (아래 내 예전코드 참고)
 */
import java.util.*;
import java.io.*;
public class BOJ_1390  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		for(int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
		}
		
		bw.write((dp[n][0]+dp[n][1]+dp[n][2])%9901 + "");
		bw.flush();
	}

}



//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int num = Integer.parseInt(br.readLine());
//		int[][] answer = new int[num+1][3];
//		int mod = 9901;
//		
//		answer[1][0] = 1;
//		answer[1][1] = 1;
//		answer[1][2] = 1;
//		for(int i = 2; i <=num; i++) {
//			answer[i][0] = (answer[i-1][0]+answer[i-1][1]+answer[i-1][2])%mod;
//			answer[i][1] = (answer[i-1][0]+answer[i-1][1])%mod;
//			answer[i][2] = (answer[i-1][0]+answer[i-1][2])%mod;
//			
//		}
//		
//		System.out.println((answer[num][0]+answer[num][1]+answer[num][2])%mod);
//		
//		
//		
//	}
//
//}


