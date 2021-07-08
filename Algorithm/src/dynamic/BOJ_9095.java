package dynamic;

/*
 * 2021.07.08
 * BOJ 9095 1,2,3더하기 https://www.acmicpc.net/problem/9095
 * N번째 수는 N-1번째에서 +1한경우, N-2번째에서 +2한 경우, N-3번째에서 +3한 경우가 있다.
 * 이 문제에서는 n제한이 11이기 때문에 런타임 에러방지 차에 이렇게 했다. 그렇게 안하면 1입력할 때 런타임 에러가 난다.
 */
import java.util.*;
import java.io.*;
public class BOJ_9095 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		for(int l = 0; l < loop; l++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[12]; //이 문제에서는 n제한이 11이기 때문에 런타임 에러방지 차에 이렇게 했다.
			dp[0] = 1;
			dp[1] = 1; 
			dp[2] = 2; // 그렇게 안하면 1입력할 때 런타임 에러가 난다.
			for(int i = 3; i <= n; i++) {
				dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]);
			}
			System.out.println(dp[n]);
		}
		
	}
}
		
