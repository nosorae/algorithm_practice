package bruteforce;

/*
 * 2021.07.08
 * BOJ 14391 일단 한자리로 더하는 것보다 여러자리로 만드는 게 크게만들 것 같은데 반례는 0이 들어간 경우 생긴다.
 * 그래서 범위도 1<= N, M <= 4로 작으니 브루트포스로 해결하려고 한다.
 * 비트마스크로 모든 경우의 수를 다 해보는데 비트마스크는 1차원이므로  
 * 1차원 배열의 인덱스를 2차원 배열화해서 문제를 풀어준다.
 * 각 케이스마다 완성된 종이조각에 대한 숫자 파싱이 필요하다.
 * 지금의 나는 check배열을 만들어서 함수로 넘겨주고
 * 과거의 나는 함수 안만들고 i*m+j로 2차원 인덱스를 1차원화 해서 비트마스크로 구했다.
 */
import java.util.*;
import java.io.*;
public class BOJ_14391 {
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] paper = new int[n][m];
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < m; j++) {
				paper[i][j] = input.charAt(j) - '0';
			}
		}
		
		int max = 0;
		
		for(int i = 0; i < 1<<(n*m); i++) {
			boolean[][] check = new boolean[n][m]; // true면 해당 칸은 가로다
			for(int j = 0; j < n*m; j++) {
				if((i & (1 << j)) != 0) {
					check[j/m][j%m] = true;
				}
			}
			int localAnswer = sumAllValue(paper, check);
			if(max < localAnswer) {
				max = localAnswer;
			}
			
				
		}
		
		System.out.println(max);
		
		
	}
	static int sumAllValue(int[][] paper, boolean[][] check) {
		int result = 0;
		//가로
		for(int i = 0; i < n; i++) {
			int cur = 0;
			for(int j = 0; j < m; j++) {
				if(check[i][j]) {
					cur *= 10;
					cur += paper[i][j];
				}
				else {
					result += cur;
					cur = 0;
				}
			}
			result += cur;
		}
		//세로 
		for(int i = 0; i < m; i++) {
			int cur = 0;
			for(int j = 0; j < n; j++) {
				if(!check[j][i]) {
					cur *= 10;
					cur += paper[j][i];
				}
				else {
					result += cur;
					cur =0;
				}
			}
			result += cur;
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
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		int[][] arr = new int[n][m];
//		for(int i = 0; i < n; i++) {
//			String str = br.readLine();
//			for(int j = 0; j < m; j++) {
//				arr[i][j] = str.charAt(j)-'0';
//			}
//		}
//		int max = 0;
//		int sum = 0;
//		for(int s = 0; s < (1<<n*m); s++) {
//			sum = 0;
//			//가로
//			for(int i = 0; i < n; i++) { // i가 행
//				int temp = 0;
//				for(int j = 0; j < m; j++) { // j가 열
//					int idx = i*m+j;
//					if((s & (1<<idx)) == 0){
//						temp = temp*10 + arr[i][j];
//					}	
//					else {
//						sum += temp;
//						temp = 0;
//					}
//				}
//				sum += temp; // 마지막 m-1에서 0이 뜨면 줄바꿈에서 한 번 더 더해줘야하니까 
//			}
//			//System.out.println("before : " + sum);
//			//세로
//			for(int i = 0; i < m; i++) { // i가 열
//				int temp = 0;
//				for(int j = 0; j < n; j++) { // j가 행
//					int idx = i+j*m;
//					if((s & (1<<idx)) != 0){
//						temp = temp*10 + arr[j][i];
//					}	
//					else {
//						sum += temp;
//						temp = 0;
//					}
//				}
//				sum += temp; // 마지막 m-1에서 0이 뜨면 줄바꿈에서 한 번 더 더해줘야하니까 
//				
//			}
//			//System.out.println("after : " + sum);
//			//최대값 갱신
//			if(max < sum) {
//				max = sum;
//			}
//		}
//		
//		System.out.println(max);
//	}
//
//}

