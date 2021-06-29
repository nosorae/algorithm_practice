package bruteforce;

/*
 * BOJ 9095 1,2,3 더하기
 * 다이나믹프로그래밍으로 풀어봤지만
 * 이문제, 제한이 10까지밖에 안되므로 3^10으로 해볼만 하다. 그러므로 브루트포스로도 경험해본다.
 */
import java.util.*;
import java.io.*;
public class BOJ_9095 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int loop = 0; loop < t; loop++) {
			int n = Integer.parseInt(br.readLine());
			int ans = placeAll(n, 0);
			System.out.println(ans);
		}
	}
	static int placeAll(int n, int sum) {
		if(sum == n) 
			return 1;
		if(sum > n)
			return 0;
		int localAns = 0;
		for(int i = 1; i <= 3; i++) {
			localAns+= placeAll(n, sum+i);
		}
		return localAns;
	}
}



