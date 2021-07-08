package dynamic;

/* 2021.07.08
 * BOJ 15990 1,2,3 더하기 https://www.acmicpc.net/problem/15990
 * N이 주어지면 1,2,3만 연속되지 않고  사용해서 N을 만드는 방법의 수를 구하는 문제
 * n을 만드는 방법의 수는 dp[n-1] + dp[n-2] + dp[n-3]에서  dp[n-1-1]
 * answer = dp[n] - dp[n-2] - dp[n-4] - dp[n-6] 가 안되는 이유는 작은 문제들도 연속된 숫자를 포함할 수 있기 때문
 * 문제에서 같은 숫자가 연속하면 안된다는 조건이 있고 이를 알려면 숫자가 무엇으로 끝났는지 알아야한다.
 * 따라서 각 점화식정의를 dp[i][j]로해서 주어진 정수는 i고 j로 끝나는 경우의 개수라고 정의하면된다.
 * 그러면 점화식은 dp[i][1] = dp[i-1][2]+dp[i-1][3] ... dp[i][3] = dp[i-3][1]+dp[i-3][2] 이다.
 * 문제의 정답이 커진다고 힌트를 주면 long을 먼저 고려해보라구
 * 아무리 10억으로 나머지연산해도 int범위는 20억정도니까 10억에 가까운 수 세개 더하면 오버플로 발생할 수 있다구 
 * 첫번째 코드도 통과되긴 했지만 아래코드가 공식적으로 더 정확하다.
 */
import java.util.*;
import java.io.*;
public class BOJ_15990_HARD {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] dp = new int[100001][4];
		dp[1][1] = 1; dp[2][2] = 1; dp[3][1] = 1; 
		dp[3][2] = 1; dp[3][3] = 1;
		
		for(int i = 4; i <= 100000; i++) {
			dp[i][1] = dp[i-1][2]%1000000009 + dp[i-1][3]%1000000009;
			dp[i][2] = dp[i-2][1]%1000000009 + dp[i-2][3]%1000000009;
			dp[i][3] = dp[i-3][1]%1000000009 + dp[i-3][2]%1000000009;
			
		}
		
		int loop = Integer.parseInt(br.readLine());
		for(int l = 0; l < loop; l++) {
			int n = Integer.parseInt(br.readLine());
			bw.write((dp[n][1]%1000000009+dp[n][2]%1000000009+dp[n][3]%1000000009)+"\n");
		}
		bw.flush();
	}
}


//import java.util.*;
//import java.io.*;
//public class Main {
//	public static void main(String[] args) throws IOException {	
//		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		long[][] dp = new long[100001][4];
//		dp[1][1] = 1; dp[2][2] = 1; dp[3][1] = 1; 
//		dp[3][2] = 1; dp[3][3] = 1;
//		
//		for(int i = 4; i <= 100000; i++) {
//			dp[i][1] = (dp[i-1][2]%1000000009 + dp[i-1][3]%1000000009)%1000000009;
//			dp[i][2] = (dp[i-2][1]%1000000009 + dp[i-2][3]%1000000009)%1000000009;
//			dp[i][3] = (dp[i-3][1]%1000000009 + dp[i-3][2]%1000000009)%1000000009;
//			
//		}
//		
//		int loop = Integer.parseInt(br.readLine());
//		for(int l = 0; l < loop; l++) {
//			int n = Integer.parseInt(br.readLine());
//			bw.write((dp[n][1]%1000000009+dp[n][2]%1000000009+dp[n][3]%1000000009)%1000000009+"\n");
//		}
//		bw.flush();
//	}
//}
		
