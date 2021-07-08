package dynamic;

/*
 * 2021.07.08
 * BOJ 14002 가장 긴 증가하는 부분수열2  https://www.acmicpc.net/problem/14002
 * 가장 긴 증가하는 부분수열1과 다른점은 경로를 출력해야한다는 것이다. 그래서 모든 인덱스의 dp값이 결정될 때 이전 인덱스를 기록해서 
 * 이전 인덱스 기록을 반대로 뒤집어서 출력하면 정상적으로 경로를 확인할 수 있다.
 * 점화식의 정의를 i 앞의 수 중에서 그리고 지금 자신(i)보다 작은 수 중에서 그 작은 수까지의 가장 긴 수열을 가지고 있는 수 + 1 로 정의한다.
 * 그럼 점화식은 dp[i] = if(A[i] > A[i-j]) max(dp[j]) ( 1 <= i < n, 0 <= j < i )
 * 초기화는 dp의 모든 원소는 1로 초기화하면 된다. 숫자 하나는 무조건 가장 긴 증가하는 부분수열에 해당하기 때문이다. 따라서 최소값을 1로 표현하면 된다.
 * 그리고 마지막에는 dp의 원소값중에 max를 찾아주면 된다.
 * 시간복잡도는 O(N^2)이다.
 */


import java.util.*;
import java.io.*;
public class BOJ_14002  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {	
		
		int n = Integer.parseInt(br.readLine());
		int[] values = new int[n];
		int[] dp = new int[n];
		int[] prev = new int[n];
		// 입력 및 초기화
		StringTokenizer st =  new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			prev[i] = -1;
		}
		
		// 다이나믹 프로그래밍
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(values[j] < values[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					prev[i] = j;
				}
					
			}
		}
		//답을 내는 과정 
		int max = 0;
		int maxIdx = 0;
		for(int i = 0; i < n; i++) {
			if(max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}
		bw.write(max+"\n");
		// 경로 출력 함수
		traceBack(values, prev, maxIdx);
		bw.flush();
	}
	static void traceBack(int[] val, int[] prev, int start) throws IOException {
		int idx = start;
		Stack<Integer> stack = new Stack<>();
		while(prev[idx] != -1) {
			stack.add(val[idx]);
			idx = prev[idx];
		}
		stack.add(val[idx]);
		while(!stack.isEmpty()) {
			bw.write(stack.pop()+" ");
		}
	}
}