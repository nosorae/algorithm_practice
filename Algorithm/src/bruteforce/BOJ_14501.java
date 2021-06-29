package bruteforce;

/*
 * BOJ 14501 퇴사
 * 걸리는 시간 배열, 그에 따른 페이배열을 입력받고
 * N+1일에 받을 수 있는 페이의 최대값을 구하는 문제
 * 입력이 뭐가 올지 모르니까 다해봐야하는데, 매 재귀마다 일을 하고 안하고만 있을 뿐이다.
 * 그러므로 시간복잡도는  2^15이다. 
 * 인자에 꼭 들어가야하는 변수는 날짜를 나타내는 day와 답을 구하기 위한 페이의 합 sum이다.
 */
import java.util.*;
import java.io.*;
public class BOJ_14501 {
	static int max;
	public static void main(String[] args) throws Exception {
		max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] days = new int[n+1];
		int[] pays = new int[n+1];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			pays[i] = Integer.parseInt(st.nextToken());
		}
		pickAllCombination(days, pays, n, 1, 0);
		System.out.println(max);
	}
	static void pickAllCombination(int[] days, int[] pays, int n, int day, int sum) {
		if(day == n+1) {
			if(max < sum) 
				max = sum;
			return;
		}
		if(day > n+1)
			return;
		// 선택한 경우
		pickAllCombination(days, pays, n, day+days[day], sum + pays[day]);
		// 선택 안한 경우
		pickAllCombination(days, pays, n, day+1, sum);
		
	}
}



