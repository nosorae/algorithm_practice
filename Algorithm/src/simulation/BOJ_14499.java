package simulation;

import java.util.*;

/*
 * 백준 14499번 주사위 굴리기
 * 3차원 주사위를 어떻게 배열로 표현할까? 일차원 배열 하나로 표현해보자
 * 주사위를 굴리는 행위를 배열돌리기로 해결해보기
 */

public class BOJ_14499 {

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
 * 또 경계처리에서 ||로 해야하는 걸 &&로 해서 시간 잡아먹었다.
 * 나는 주사위 전개도를 사용해서 일차원 배열 두 개를 사용했는데, 일차원 배열 한 개를 사용해서 더 간단하게 구현할 수 있다는 것을 깨달았다.
 * 그것은 모든 면을 인덱스화해서 인덱스가 움직이는 것만 코드로 옮기면 되는 것이다. 함수화할 수도 있을 것 같다. 
 * 삽질을 방지하려면 어느 곳에 문제가 생긴지 파악하고 원인으로 타고 들어가서 손봐야한다.
 */

//import java.util.*;
//public class Main {
//    static int[] dx = {0,0,-1,1};
//    static int[] dy = {1,-1,0,0};
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int l = sc.nextInt();
//        int[][] a = new int[n][m];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        int[] dice = new int[7];
//        while (l-- > 0) {
//            int k = sc.nextInt() - 1;
//            int nx = x+dx[k];
//            int ny = y+dy[k];
//            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
//                // 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 함, 출력도 하면 안됨
//                continue;
//            }
//            if (k == 0) { // right
//                int temp = dice[1];
//                dice[1] = dice[4];
//                dice[4] = dice[6];
//                dice[6] = dice[3];
//                dice[3] = temp;
//            } else if (k == 1) { // left
//                int temp = dice[1];
//                dice[1] = dice[3];
//                dice[3] = dice[6];
//                dice[6] = dice[4];
//                dice[4] = temp;
//            } else if (k == 2) { // up
//                int temp = dice[1];
//                dice[1] = dice[5];
//                dice[5] = dice[6];
//                dice[6] = dice[2];
//                dice[2] = temp;
//            } else { // down
//                int temp = dice[1];
//                dice[1] = dice[2];
//                dice[2] = dice[6];
//                dice[6] = dice[5];
//                dice[5] = temp;
//            }
//            x = nx;
//            y = ny;
//            if (a[x][y] == 0) {
//                // 주사위를 굴렸을 때, 이동한 칸에 써 있는 수가 0이면, 주사위의 바닥면에 써 있는 수가 칸에 복사됨
//                a[x][y] = dice[6];
//            } else {
//                // 0이 아닌 경우에는 칸에 써 있는 수가 주사위의 바닥면으로 복사되며,
//                dice[6] = a[x][y];
//                // 칸에 써 있는 수는 0이 복사됨
//                a[x][y] = 0;
//            }
//            System.out.println(dice[1]);
//        }
//    }
//}







