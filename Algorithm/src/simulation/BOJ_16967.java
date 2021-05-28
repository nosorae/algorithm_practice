package simulation;

import java.util.*;
/*
 * 백준 16967번 배열 복원하기
 * 인덱스만 잘 찾아주면 쉬운 문제
 */

public class BOJ_16967 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int[][] arrA = new int[h][w];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[][] arrB = new int[h+x][w+y];
		
		//입력
		for(int i = 0; i < arrB.length; i++) {
			for(int j = 0; j < arrB[i].length; j++) {
				arrB[i][j] = sc.nextInt();
			}
		}
		
		//복사
		for(int i = 0; i < arrA.length; i++) {
			for(int j  = 0; j <arrA[i].length; j++) {
				arrA[i][j] = arrB[i][j];
			}
		}
		
		//겹치는 부분 빼주기
		for(int i = x; i < arrA.length; i++) {
			for(int j = y; j < arrA[i].length; j++) {
				arrA[i][j] = arrB[i][j] - arrA[i-x][j-y];
			}
		}
		
		//출력
		for(int i = 0; i < arrA.length; i++) {
			for(int j = 0; j < arrA[i].length; j++) {
				System.out.print(arrA[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}

/*
 * 내 풀이보다 메모리를 적게썼다. 
 * 실제 배열은 크지만 for문 쓸 때 index를 적게 잡아서 공간효율성을 올리는 아이디어를 채택하자
 */

//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int h = sc.nextInt();
//        int w = sc.nextInt();
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int[][] a = new int[h+x][w+y];
//        for (int i=0; i<h+x; i++) {
//            for (int j=0; j<w+y; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        for (int i=0; i<h; i++) {
//            for (int j=0; j<w; j++) {
//                a[i+x][j+y] -= a[i][j];
//            }
//        }
//        for (int i=0; i<h; i++) {
//            for (int j=0; j<w; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}




