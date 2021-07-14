package dynamic;

/*
 * 2021.07.11
 * BOJ 13398 연속합2 https://www.acmicpc.net/problem/13398
 * 연속합 문제에서 중간에 수 하나를 제거할 수도 있는 문제.
 * 이것도 가장 긴 바이토닉 부분수열을 구하는 것과 비슷한 방법으로 답을 구할 수 있다.
 * 어쨌든 하나를 제거해봐야하는데 다 시도해보기엔 입력이 10만이라 O(N^2)은 불가능하다. 
 * 그래서 연속합을 양쪽으로 구한다. 왼쪽에서 시작하는 거 하나 오른쪽에서 시작하는 거 하나
 * 그래서 i(1<=i<=n-2)까지 하나씩 빼보고, 안빼는 경우까지 합쳐서 그중에서 최대를 구하면된다.
 * left[i]를 왼쪽에서 오른쪽 방향으로 0~i까지 고려했을 때, 최대 연속합이라고 정의한다.
 * left[i]는 left[i-1]+val[i]와 val[i]를 비교했을 때 큰 쪽을 선택한 값이다.
 * right[i]를 오른쪽에서 왼쪽방향으로 n-1~i까지 고려했을 대, 최대 연속합이라고 정의한다.
 * right[i]는 right[i+1]+val[i]와 val[i]를 비교했을 때 큰 쪽을 선택한 값이다.
 */

import java.util.*;
import java.io.*;
public class BOJ_13398  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] left = new int[n];
		int[] right = new int[n];
		int[] val = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}
		
		left[0] = val[0];
		for(int i = 1; i < n; i++) {
			left[i] = max(val[i], left[i-1]+val[i]);
		}
		
		right[n-1] = val[n-1];
		for(int i = n-2; i >= 0; i--) {
			right[i] = max(val[i], right[i+1]+val[i]);
		}
		
		//최대값 구할 때 음수가 있으면 주의 하나의 원소값의 최소가 -1000이고, 그게 최대 10만개이니  -1억으로 초기화
		int ans = -100000000;
		// 제거하지 않는 경우
		for(int i = 0; i < n; i++) {
			//left와 right는 방향만 다르지원소들의 최대값은 같다.
			ans = max(ans, left[i]);
		}
		
		// 원소하나 제거하는 경우
		for(int i = 1; i < n-1; i++) {
			ans = max(ans, left[i-1]+right[i+1]);
		}
		
		bw.write(ans+""); bw.flush();
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


