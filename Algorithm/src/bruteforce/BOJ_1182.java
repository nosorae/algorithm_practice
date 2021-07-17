package bruteforce;

/*
 * BOJ 부분수열의 합 1182 https://www.acmicpc.net/source/21358795
 * 조회를 binaryString으로 바꿀 필요없이, 그냥  v1 & (1<<i) 이렇게 i를 0부터 원하는 길이까지 조회하는 게 더 빠르다.
 */
import java.util.*;
import java.io.*;

public class BOJ_1182 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int[] input = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(findAllSum(input, goal));
	} 
	static int findAllSum(int[] arr, int goal) {
		int result = 0;
		// 부분수열의 크기가 양수라고 했으니 1부터 시작해야한다.
		for(int i = 1; i < 1 << arr.length; i++) {
			String s = Integer.toBinaryString(i);
			int sum = 0;
			for(int j = s.length()-1; j >= 0; j--) {
				if(s.charAt(j) == '1') {
					sum += arr[s.length()-1 - j];
				}
			}
			if(sum == goal)
				result++;
		}
		return result;
	}
}



//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		int sum = 0;
//		int ans = 0;
//		for(int i = 1; i <(1<<n); i++) {
//			sum = 0;
//			for(int j = 0; j < n; j++) {
//				if((i &(1<<j)) != 0) {
//					sum += arr[j];
//				}
//			}
//			if(sum == m) {
//				//System.out.println(i);
//				ans++;
//			}
//		}
//		System.out.println(ans);
//	}
//
//}






//import java.util.*;
//import java.io.*;
//class Main {
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static int answer;
//	static int n;
//	static int s;
//	static int[] arr;
//	public static void main(String args[]) throws Exception	{
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		answer = 0;
//		n = Integer.parseInt(st.nextToken());
//		s = Integer.parseInt(st.nextToken());
//		arr = new int[n];
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//
//		for(int i = 1; i <= n; i++) {
//			placeAll(i, 0, 0, 0);
//		}
//
//		bw.write(answer+""); bw.flush();
//
//	}
//
//	static void placeAll(int len, int sum, int depth, int start) throws IOException {
//
//		if(depth == len && sum == s) {
//			answer++;
//			return;
//		}
//
//		for(int i = start; i < n; i++) {
//			placeAll(len, sum+arr[i], depth+1, i+1);
//		}
//		
//	}
//
//}

