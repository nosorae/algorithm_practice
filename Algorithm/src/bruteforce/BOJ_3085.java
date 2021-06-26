package bruteforce;

import java.util.Scanner;
/*
 * BOJ 3085 사탕게임 https://www.acmicpc.net/problem/3085
 * N*N 2차원 배열에서 문자가 다른 4방향 인접 두칸을 바꿔보고 그 때의 같은 색으로 연속된 최대 길이 출력
 * 뭘 바꿔야 최대가 될지 내가 알 길이 없으니 다 해봐야할 것 같고, 최대크기 50밖에 안되니 O(N^2)이어도 브루트포스를 해볼만 하다
 * 바꾸는 것은 양방향이므로 0,0에서 시작한다고 가정했을 때 각자 아래와 오른쪽 인접한 칸만 확인하면 전체확인이 가능하다.
 * 바꾸고 원상복구 하고 안하고도 중요하다. 
 * 바꾸고나서 영향 미치는 것은 세라인 밖에 없기 때문에 약간이라도 성능향상을 위해 세부분만 확인해주었다.
 * 스왑, 세 숫자중 가장 큰 숫자 찾기, 가로 탐색, 세로탐색  함수 4개 만들어서 해결했다.
 * colLine rowLine함수에서 else 문에 localMax를 갱신하는 코드를 넣었더니 마지막은 처리하지 못했었다. 마지막인덱스 처리도 깔끔하게 할 것!
 * 아래 백준 소스는 바꿀 때마다 모든 열을 확인하는 소스이다.
 * 
 */
//입력이 이래 간단하다... 
//char[][] a = new char[n][n];
//for (int i=0; i<n; i++) {
//	a[i] = sc.next().toCharArray();
//}
public class BOJ_3085 {
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int n = sc.nextInt();
		sc.nextLine();
		char[][] candies = new char[n][n];
		

		for(int i = 0; i < n; i++) {
			String input = sc.nextLine();
			for(int j = 0; j < n; j++) {
				candies[i][j] = input.charAt(j);
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(i+1 < n) {
					swap(candies, i, j, i+1, j);
					int temp = findMaxNum(rowLine(candies, i), rowLine(candies, i+1), colLine(candies, j));
					if(max < temp)
						max = temp;
					swap(candies, i, j, i+1, j);
				}
				if(j+1 < n) {
					swap(candies, i, j, i, j+1);
					int temp = findMaxNum(colLine(candies, j), colLine(candies, j+1), rowLine(candies, i));
					if(max < temp)
						max = temp;
					swap(candies, i, j, i, j+1);

				}
			}
		}
		System.out.println(max);

	}
	static void swap(char[][] arr, int x, int y, int nx, int ny) {
		char temp = arr[x][y];
		arr[x][y] = arr[nx][ny];
		arr[nx][ny] = temp;
	}
	//최대 연속을 한 행에서 찾는 함수
	static int rowLine(char[][] arr, int line) {
		int localMax = 1;
		int cur = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[line][i-1] == arr[line][i])
				cur++;
			else 
				cur = 1;

			if(localMax < cur)
				localMax = cur;
		}
		return localMax;
	}
	//최대 연속을 한 열에서 찾는 함수
	static int colLine(char[][] arr, int line) {
		int localMax = 1;
		int cur = 1;
		for(int i = 1; i < arr[0].length; i++) {
			if(arr[i-1][line] == arr[i][line])
				cur++;
			else 
				cur = 1;

			if(localMax < cur)
				localMax = cur;
		}
		return localMax;
	}
	static int findMaxNum(int a, int b, int c) {
		int max = a;
		if(max < b)
			max = b;
		if(max < c)
			max = c;
		return max;
	}

}

//import java.util.*;
//public class Main {
//    static int check(char[][] a) {
//        int n = a.length;
//        int ans = 1;
//        for (int i=0; i<n; i++) {
//            int cnt = 1;
//            for (int j=1; j<n; j++) {
//                if (a[i][j] == a[i][j-1]) {
//                    cnt += 1;
//                } else {
//                    cnt = 1;
//                }
//                if (ans < cnt) ans = cnt;
//            }
//            cnt = 1;
//            for (int j=1; j<n; j++) {
//                if (a[j][i] == a[j-1][i]) {
//                    cnt += 1;
//                } else {
//                    cnt = 1;
//                }
//                if (ans < cnt) ans = cnt;
//            }
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        char[][] a = new char[n][n];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.next().toCharArray();
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                if (j+1 < n) {
//                    char t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
//                    int temp = check(a);
//                    if (ans < temp) ans = temp;
//                    t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
//                }
//                if (i+1 < n) {
//                    char t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
//                    int temp = check(a);
//                    if (ans < temp) ans = temp;
//                    t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}


