package dynamic;
/*
 * 2021.07.08
 * BOJ 10844 쉬운 계단 수
 * 0으로 시작하지 않는, 0~9수가 나열됐을 때, 길이가 N인 계단 수는 몇개 있는지 답하는 문제
 * 반복문에서 1과 9는 예외가 생긴다. 이를 예쁘게 처리하기 위해서 그냥 반복문 안에 if문을 쓰는 법이 있다.
 * 문제의 답이 커질 것 같아서 10억 모듈러스를 주었다면 당연히 long 사용을 고려해봐야하는 것 아닌가?? 정신차리자
 */

//어떤 정수 a를 b로 나눴을때 몫 q 나머지 r은 유일합니다. 즉 유일하게 a=bq+r로 표현됩니다.
//이제 두 정수를 더하고 b라는 특정 정수로 나눈 나머지를 더하는 것 두정수를 b로 나누고 더하는것이 동일함을 보이면 됩니다.
//a=bq+r 
//c=Bq+R이라고 할때
//a+c= (b+B)q+r+R입니다.
//(a+c) %q= (r+ R)%q
//(a%q+c%q)%q= (r+R)%q이므로 동일합니다. 

import java.util.*;
import java.io.*;
public class BOJ_10844_HARD {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+2][10];
		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1; //dp[1][0]은 0임에 주의하자 (0으로 시작하는 수는 없다는 것이 문제의 조건)
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j-1 >= 0) 
					dp[i][j] += dp[i-1][j-1];
				if(j+1 <= 9)
					dp[i][j] += dp[i-1][j+1];
				dp[i][j] %= 1000000000;
			}
		}
		long answer = 0;
		for(int i = 0; i <= 9; i++) {
			answer += dp[n][i];
		}
		answer %= 1000000000;
		System.out.print(answer);
	}
}

