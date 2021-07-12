
/*
 * 2021.07.11
 * BOJ 13398 연속합2 https://www.acmicpc.net/problem/13398
 * 연속합 문제에서 중간에 수 하나를 제거할 수도 있는 문제.
 * 이것도 가장 긴 바이토닉 부분수열을 구하는 것과 비슷한 방법으로 답을 구할 수 있다.
 * 어쨌든 하나를 제거해봐야하는데 다 시도해보기엔 입력이 10만이라 O(N^2)은 불가능하다. 
 * 그래서 연속합을 양쪽으로 구한다. 왼쪽에서 시작하는 거 하나 오른쪽에서 시작하는 거 하나
 * 그래서 i(1<=i<=n-2)까지 하나씩 빼보고, 안빼는 경우까지 합쳐서 그중에서 최대를 구하면된다.
 */

import java.util.*;
import java.io.*;
public class Main  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] left = new int[n];
		int[] right = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			left[i] = Integer.parseInt(st.nextToken());
			right[i] = left[i];
		}
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


