package simulation;


import java.util.*;

/*
 * 백준 15662번 톱니바퀴 
 * 저번 경사로 문제에서 문제의 조건파악이 매우 중요하다는 것을 깨닫고 문제 풀기 전에 조건 뽑는 연습 시작
 * 8개 톱니가진 톱니바퀴가 T개  (톱니마다 N극 or S극)
 * 톱니바퀴의 회전기준은 한칸이고 시계 반시계 두가지가 있다.
 * 회전시키기 전에 모든 톱니바퀴에 대해, 회전시킬 톱니바퀴와 방향을 결정해야함
 * 맞닿은 극이 다르다면 반대로 회전 시키고, 맞닿은 극이 같다면  회전 x 연쇄적으로 회전 x
 * 
 * 톱니바퀴를 일차원 배열로 표현하고, 회전을 한칸 밀기 한칸 당기기로 표현, 회전시키기 전에 모든 방향을 미리 구해놓아야함에 유의
 */

public class BOJ_15662 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] arr = new int[t][8];
		
		
		sc.nextLine();
		for(int i = 0; i < t; i++) {
			String input = sc.nextLine();
			for(int j = 0; j < 8; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		int k = sc.nextInt();
	
		
		
		for(int i = 0; i < k; i++) {
			
			int num = sc.nextInt()-1;
			int direc = sc.nextInt(); // 1 시계 0 무회전 -1 반시계
			int[] order = new int[t];
			order[num] = direc;
			
			
			//회전하기 전에  톱니바퀴별 방향정보를 구하자
			for(int j = num; j > 0; j--) {
				if(arr[j][6] == arr[j-1][2]) {
					break;
				}
				else {
					order[j-1] = -order[j];
				}
			}
			for(int j = num; j < t-1; j++) {
				if(arr[j][2] == arr[j+1][6])
					break;
				else 
					order[j+1] = -order[j];
			}
			
			for(int j = 0; j < t; j++) {
				if(order[j] == 1) 
					push_right(arr[j]);
				else if(order[j] == -1)
					push_left(arr[j]);
			}
		}
		
		int ans = 0;
		for(int i = 0; i < t; i++) {
			if(arr[i][0] == 1)
				ans++;
		}
		
		System.out.println(ans);
		
		
		
		
	}
	static int reverseNum(int n) {
		return n==1 ? -1 : (n==-1 ? 1 : 0);
	}
	
	//1차원 배열 왼쪽으로 한 칸 당기기
	static void push_left(int[] arr) {
		int temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp; 
		
	}
	//1차원 배열 오른쪽을 한 칸 밀기
	static void push_right(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}

}

/*
 * a[i] = sc.next().toCharArray(); (a는 2차원배열인데 저렇게 입력받는 센스를 본받자)
 * 
 */


//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        char[][] a = new char[n][8];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.next().toCharArray();
//        }
//        int k = sc.nextInt();
//        while (k-- > 0) {
//            int no = sc.nextInt()-1;
//            int dir = sc.nextInt();
//            // 각각의 톱니는 동시에 회전해야 하기 때문에
//            // 먼저, 각 톱니가 어떤 방향으로 회전해야 하는지 구하자
//            int[] d = new int[n];
//            d[no] = dir;
//            // 왼쪽 톱니를 연쇄적으로 구하고
//            for (int i=no-1; i>=0; i--) {
//                if (a[i][2] != a[i+1][6]) {
//                    d[i] = -d[i+1];
//                } else {
//                    // 한 톱니가 회전하지 않으면
//                    // 그 톱니의 왼쪽에 있는 톱니도 회전하지 않는다.
//                    break;
//                }
//            }
//            // 오른쪽 톱니를 연쇄적으로 구하고
//            for (int i=no+1; i<n; i++) {
//                if (a[i-1][2] != a[i][6]) {
//                    d[i] = -d[i-1];
//                } else {
//                    // 한 톱니가 회전하지 않으면
//                    // 그 톱니의 오른쪽에 있는 톱니도 회전하지 않는다.
//                    break;
//                }
//            }
//            for (int i=0; i<n; i++) {
//                if (d[i] == 0) continue;
//                if (d[i] == 1) {
//                    // 시계 방향 회전
//                    char temp = a[i][7];
//                    for (int j=7; j>=1; j--) {
//                        a[i][j] = a[i][j-1];
//                    }
//                    a[i][0] = temp;
//                } else if (d[i] == -1) {
//                    // 반시계 방향 회전
//                    char temp = a[i][0];
//                    for (int j=0; j<7; j++) {
//                        a[i][j] = a[i][j+1];
//                    }
//                    a[i][7] = temp;
//                }
//            }
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            if (a[i][0] == '1') {
//                ans += 1;
//            }
//        }
//        System.out.println(ans);
//    }
//
//}
//






