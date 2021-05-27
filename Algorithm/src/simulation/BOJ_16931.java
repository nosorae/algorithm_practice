package simulation;

import java.util.*;
/*
 * 백준 16931번 겉넓이 구하기
 * 윗밑면은 어차피 겉넓이라는 점을 이용해서 3차원 배열을 만들지 않고서도 4방향의 길이만 가지고도 
 * 테두리 한칸씩 잡고 1~n까지 돌리는 아이디어 사용
 * 
 */

public class BOJ_16931 {
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n+2][m+2];
		int ans = n*m*2;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				for(int k = 0; k < 4; k++) {
					if(arr[i][j] > arr[i+dx[k]][j+dy[k]])
						ans +=( arr[i][j] - arr[i+dx[k]][j+dy[k]] );
				}
			}
		}
		
		System.out.print(ans);
	}
	
}

/*
 * 
 */
//import java.util.*;
//public class Main {
//    final static int[] dx = {0,0,1,-1};
//    final static int[] dy = {1,-1,0,0};
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[102][102];
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        int ans = 2*n*m;
//        for (int x=1; x<=n; x++) {
//            for (int y=1; y<=m; y++) {
//                for (int k=0; k<4; k++) {
//                    int nx = x+dx[k];
//                    int ny = y+dy[k];
//                    if (a[x][y]-a[nx][ny] >= 0) {
//                        ans += a[x][y]-a[nx][ny];
//                    }
//                    }
//            }
//        }
//        System.out.println(ans);
//    }
//}






