package simulation;


import java.util.*;

//dfs로도 풀어볼 것!!!

/*
 * 백준 14503번 로봇청소기
 * N*M크기 배열, r, c좌표 
 * 청소 -> 현재방향 기준 왼쪽부터 탐색하다 청소 안 한 공간 있으면  이동 
 * or 탐색하다가 네 방향 다 청소하거나 벽이면 방향 그대로 후진
 * 근데 후진하려고 보니 뒤에도 벽이라 못가면 작동 중지
 * 즉 벽과 청소한 곳으로는 이동 불가 조건 
 * 벽 1 청소전 0 청소후 2
 * 북 0 , 동 1, 남 2, 서 3
 */

public class BOJ_14503 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 }; 
	static int ans = 0;
	static int n = 0;
	static int m = 0;
	static int[][] arr;
	static LinkedList<String> list = new LinkedList<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();
		
		arr = new int[n][m]; 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			ans++;
			arr[x][y] = 2;
			
			if(arr[x+1][y] != 0 && arr[x-1][y] != 0 && arr[x][y-1] != 0 && arr[x][y+1] != 0) {
				if(arr[x+dx[(d+2)%4]][y+dy[(d+2)%4]] == 1)
					break;
				else { // 방향 그대로 후진  참고로 이때 후진하는 곳의 숫자는 2다. 따라서 2에 2를 덮어씌울 뿐이다.
					x = x+dx[(d+2)%4];
					y = y+dy[(d+2)%4];
					ans--; // 이건 청소하는 게 아니라 그냥 후진이기 때문에 중복카운트되면 안되기 때문에 
					continue;
				}
			}
			
			
			
			//여기 왔다는 것은 0인 방향이 하나라도 있다는 뜻
			
			for(int i = 0; i < 4; i++) {
				d = (d+3)%4; //왼쪽부터 하나씩 확인
				if(arr[x+dx[d]][y+dy[d]] == 0) {
					x = x+dx[d];
					y = y+dy[d];
					break;
				}
			}
				
		}


		System.out.println(ans);





	}
	
}

/*
 * (i-1)%4를 하면 0 1 2 3이 나올 것 같지만 그렇지않다. i가 0 1 2 3 순서이면 -1 0 1 2가 나온다. 
 * 시작점을 바꿔주기 위해 4를 더하면 (i+3)%4가 되고 i가 0 1 2 3순서일 때  3 0 1 2가 나온다.
 * 즉 모듈러스 연산하는데 음수가 나온다면 오른쪽 피연산자를 한 번 돌려서 양수로 만들어서 의도한 값을 얻을 수 있다.
 * 
 * 그래프 길찾기 문제같다고 다 dfs가 편한 게 아닐 수 있다는 것을 깨달음 이런 조건이 많아지면 dfs는 구현 난이도가 확 올라감을 깨닮음
 * 여기서는 뒤로 가는(==자신을 호출한 부모메서드로 돌아가기)부분이 까다롭기 때문에 dfs구현이 힘들었던 것 같다. 담에 해보자..
 * 
 * 정답 코드가 if else 크게 감싸서 break, continue 남발한 내 코드보다 보기 좋다. 주석으로 조건을 써 보기 더 좋다. 네번 돌리는 for문 안쓰고 
 */


//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[n][m];
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int dir = sc.nextInt();
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        int cnt = 0;
//        int[] dx = {-1,0,1,0};
//        int[] dy = {0,1,0,-1};
//        // a[x][y] == 0 (청소하지 않은 공간)
//        // a[x][y] == 1 (벽)
//        // a[x][y] == 2 (청소한 공간)
//        while (true) {
//            if (a[x][y] == 0) {
//                // 1. 현재 위치를 청소한다.
//                a[x][y] = 2;
//            }
//            // 2-3, 2-4. 네 방향 모두 청소가 이미 되어있거나 벽인 경우
//            if (a[x+1][y] != 0 && a[x-1][y] != 0 && a[x][y-1] != 0 && a[x][y+1] != 0) {
//                if (a[x-dx[dir]][y-dy[dir]] == 1) {
//                    // 2-4. 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
//                    break;
//                } else {
//                    // 2-3. 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//                    x -= dx[dir];
//                    y -= dy[dir];
//                }
//            } else {
//                // 2-1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 
//                // 2-2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다. 
//                dir = (dir + 3) % 4;
//                if (a[x+dx[dir]][y+dy[dir]] == 0) {
//                    // 2-1. 한 칸을 전진하고 1번부터 진행한다.
//                    x += dx[dir];
//                    y += dy[dir];
//                }
//            }
//        }
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                if (a[i][j] == 2) {
//                    cnt += 1;
//                }
//            }
//        }
//        System.out.println(cnt);
//    }
//}




