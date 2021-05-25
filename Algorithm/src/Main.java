
import java.util.*;

/*
 * 백준 14499번 주사위 굴리기
 * 3차원 주사위를 어떻게 배열로 표현할까?
 * 주사위를 굴리는 행위를 배열돌리기로 해결해보기
 */

public class Main {

	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[n][m];
		int[] horizontal = new int[3];
		int[] vertical = new int[4];
		
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//첫 위치 따로 처리
		if(arr[x][y] == 0) {
			arr[x][y] = vertical[3];
		} else {
			vertical[3] = arr[x][y];
			arr[x][y] = 0;
		}
		
		
		
		for(int i = 0; i < k; i++) {
			int order = sc.nextInt();
			
			//경계처리
			int nx = x + dx[order];
			int ny = y + dy[order];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) 
				continue;
			
			x = nx; y = ny;
			
			
			
			//주사위 굴리기
			if(order == 1) { //동
				int temp = horizontal[2];
				horizontal[2] = horizontal[1];
				horizontal[1] = horizontal[0];
				horizontal[0] = vertical[3];
				vertical[3] = temp;
				vertical[1] = horizontal[1];
			} else if(order == 2) { //서
				int temp = horizontal[0];
				horizontal[0] = horizontal[1];
				horizontal[1] = horizontal[2];
				horizontal[2] = vertical[3];
				vertical[3] = temp;
				vertical[1] = horizontal[1];
			} else if (order == 3) { //북
				push_left(vertical);
				horizontal[1] = vertical[1];
			} else { //남
				push_right(vertical);
				horizontal[1] = vertical[1];
				
			}
			
			//지도와 주사위 밑면 처리
			if(arr[x][y] == 0) {
				arr[x][y] = vertical[3];
			} else {
				vertical[3] = arr[x][y];
				arr[x][y] = 0;
			}
			
			//상단 숫자 출력
			System.out.println(vertical[1]);
		}
		
		
		
		
		
		
		
		
	}
	
	
	static void push_left(int[] arr) {
		int temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp; 
		
	}
	static void push_right(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}

}

/*
 * 방향에 유의하지 않고 삽질을 하게되었다.
 * 삽질을 방지하려면 어느 곳에 문제가 생긴지 파악하고 원인으로 타고 들어가서 손봐야한다.
 */








