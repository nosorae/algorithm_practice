package bruteforce;

/*
 * BOJ 1748 수 이어쓰기
 * 1부터 주어진 N까지 연속해서 숫자를 쓰면 그 때의 길이를 계산하는 문제
 * for문에서 =을 빼먹어서 삽질했다. =을 붙일까 말까할 때는 특이한 숫자 하나 넣어보면 된다.
 * 내 과거풀이는 len을 따로 변수로 관리했는데 지금은 함수호출해서 좀 더 비효율 적이다..
 */
import java.util.*;
public class BOJ_1478 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long answer = 0;
		
		long cur = 10;
		for(; cur <= N; cur *= 10) {
			answer += ((cur-1) - cur/10 + 1) * numLen(cur/10); 
		}
		cur /= 10;
		answer += (N - cur + 1) * numLen(cur);
		System.out.println(answer);
	}
	static int numLen(long n) {
		String str = n+"";
		return str.length();
	}
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		int ans = 0;
//		int len = 1;
//		for(int i = 1; i <= n; i*=10, len++) {
//			if(i*10 <= n)
//				ans += (i*10 - i)*len;
//			else
//				ans += (n-i+1)*len;
//		}
//		
//		System.out.println(ans);
//	}
//}






