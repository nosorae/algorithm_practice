package dynamic;

/*
 * 2021.07.08
 * BOJ 15988 1,2,3더하기 3 https://www.acmicpc.net/problem/15988
 * N번째 수는 N-1번째에서 +1한경우, N-2번째에서 +2한 경우, N-3번째에서 +3한 경우가 있다.
 * 이 문제에서는 n제한이 100000이기 때문에 런타임 에러방지 차에 배열의 크기를 100001로 잡았다. 그렇게 안하면 1입력할 때 런타임 에러가 난다.
 * 1,2,3더하기 1과 다른 점은 입력의 크기가 압도적으로 크다는 것이다. 
 * 그래서 바꿔주는 게 배열의 크기와 타입을 int가 아닌 long으로 하고 나머지 연산도 넣는다는 점이다.
 */
import java.util.*;
import java.io.*;
public class BOJ_15988 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {	
		
		int loop = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001]; //이 문제에서는 n제한이 11이기 때문에 런타임 에러방지 차에 이렇게 했다.
		dp[0] = 1;
		dp[1] = 1; 
		dp[2] = 2; // 그렇게 안하면 1입력할 때 런타임 에러가 난다.
		for(int i = 3; i <= 1000000; i++) {
			dp[i] = (dp[i-1]%1000000009 + dp[i-2]%1000000009 + dp[i-3]%1000000009)%1000000009;
		}
		for(int l = 0; l < loop; l++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n]+"\n");
		}
		bw.flush();
		
	}
}
		
