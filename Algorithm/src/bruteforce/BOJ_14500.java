package bruteforce;


/*
 * BOJ 14500 테트로미노
 * 입력 배열이 어떻게 나올지 알 수없으니 직접 놓아보는 수밖에 없다. 입력의 크기는 최대 50 즉, 2500*19이므로 매우 할만하다
 * 문제는 어떻게 직접 놓아보느냐이다. 기준을 잡고 좌표로 모양을 만들면된다.
 * 그림에 나온 5가지를 각각 회전 대칭시켜보면 2 + 1 + 8 + 4 + 4 = 19가지가 나온다.
 * 백준강의에서는 아래 세가지 방법을 제시했다. 바로 아래는 1번이고 그 아래는 2번이다.
 * 1. 모든 좌표에 대해 매번 각각 경계검사하고 시도해보는 방법
 * 2. 1번에서 4방향 dfs/bfs할 때처럼 dx, dy를 만드는 방법
 * 3. ??? 
 * 속도는 2번이 (잦은 함수호출 및 3개를 확인하다가 안되면 탈출하니까) 느리지만, 디버깅하기 쉽고 코드가 더 보기좋다.
 * 
 */
import java.util.*;
public class BOJ_14500 {
	static int[][][] nextPos = {
			{{0, 1}, {0, 2}, {0, 3}}, // 일자 누운 것
			{{1, 0}, {2, 0}, {3, 0}}, // 일자 선 것
			
			{{0, 1}, {1, 0}, {1, 1}}, // 정사각형
			
			{{1, 0}, {2, 0}, {2, 1}}, // ㄴ 시작
			{{1, 0}, {0, 1}, {0, 2}}, // ㄴ 1회 회전
			{{0, 1}, {1, 1}, {2, 1}}, // ㄴ 2회 회전
			{{0, 1}, {0, 2}, {-1, 2}}, // ㄴ 3회 회전
			
			{{0, 1}, {-1, 1}, {-2, 1}}, // ㄴ 대칭 시작
			{{1, 0}, {1, 1}, {1, 2}}, // ㄴ 대칭 1회 회전
			{{0, 1}, {1, 0}, {2, 0}}, // ㄴ 대칭 2회 회전
			{{0, 1}, {0, 2}, {1, 2}}, // ㄴ 대칭 3회 회전
			
			{{0, 1}, {1, 1}, {1, 2}}, // ㄹ 시작
			{{-1, 0}, {-1, 1}, {-2, 1}}, // ㄹ 1회 회전
			{{0, 1}, {-1, 1}, {-1, 2}}, // ㄹ 대칭 시작
			{{1, 0}, {1, 1}, {2, 1}}, // ㄹ 대칭 1회 회전
			
			{{0, 1}, {-1, 1}, {0, 2}}, // ㅗ 시작 
			{{1, 0}, {2, 0}, {1, 1}}, // ㅗ 1회 회전
			{{0, 1}, {1, 1}, {0, 2}}, // ㅗ 2회 회전
			{{-1, 1}, {0, 1}, {1, 1}} // ㅗ 3회 회전
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < 19; k++) {
					int sum = arr[i][j];
					for(int t = 0; t < 3; t++) {
						int nx = i + nextPos[k][t][0];
						int ny = j + nextPos[k][t][1];
						if(!isIn(arr, nx, ny)) {
							sum = -4001;
							break;
						}
						sum += arr[nx][ny];
					}
					if(max < sum)
						max = sum;
				}
			}
		}
		
		System.out.println(max);
    }
	static boolean isIn(int[][] arr, int x, int y) {
		if(x >= 0 && x < arr.length && y >= 0 && y < arr[0].length)
			return true;
		else
			return false;
	}
}



//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		
//		int[][] arr = new int[n+1][m+1];
//		for(int i = 1; i<=n;i++) {
//			StringTokenizer st2 = new StringTokenizer(br.readLine());
//			for(int j = 1; j<=m;j++) {
//				arr[i][j] = Integer.parseInt(st2.nextToken());
//			}
//		}
//		int ans = 0;
//		int sum = 0;
//		for(int i = 1; i <= n; i++) { // 세로
//			for(int j = 1; j <= m; j++) { // 가로
//				if(j+3 <= m) { // 가로 일직선
//					sum+= arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
//					ans = max(ans, sum);
//					sum = 0;
//				} 
//				if(i+3 <= n) { // 세로 일직선
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				//---------------------------------------------------------------
//				if(i+1 <= n && j+1 <= m) { // 정사각형
//					sum += arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				//--------------------------------------------------------------
//				if(i+2 <= n && j+1 <= m) { //ㄴ
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j+2 <= m) { // ㄱ 반전
//					sum+= arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <= n && j+1 <= m) { //ㄱ
//					sum += arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i-1 >= 1 && j+2 <= m) { // ㄴ 반전
//					sum += arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i-1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <= n && j-1 >= 1) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j-1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j+2 <= m) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <= n && j+1 <= m) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j+2 <= m) {
//					sum+= arr[i][j] + arr[i][j+1]+ arr[i][j+2] + arr[i+1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				// --------------------- ㄴ ㄱ 끝 ㄹ시작--------------------------------
//				if(i-1 >= 1 && j+2 <= m) {
//					sum += arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <=n && j+1 <= m) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i-2 >= 1 && j+1 <= m) {
//					sum += arr[i][j] + arr[i-1][j] + arr[i-1][j+1] + arr[i-2][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j+2 <= m) {
//					sum += arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				//--------------------------ㄹ 끝 ㅓㅏㅗㅜ시작---------------------------
//				if(i+1 <= n && j+2 <= m) {
//					sum += arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i-1 >= 1 && i+1 <= n && j+1 <= m) {
//					sum += arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j-1>=1 && j+1 <= m) {
//					sum += arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <= n && j+1 <= m) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//			}
//		}
//		
//		System.out.println(ans);
//		
//		br.close();
//		
//	}
//	public static int max(int a, int b) {
//		if(a > b)
//			return a;
//		else
//			return b;
//	}
//}






