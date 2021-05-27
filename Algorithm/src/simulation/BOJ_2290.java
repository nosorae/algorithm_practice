package simulation;

import java.util.*;

//정답소스코드도 분석해볼 것!

/*
 * 백준 2290번 LCD Test
 * s가 주어짐 그러면 가로 s+2  세로 2*s+3 길이로 숫자를 그리라고하는데 예시 출력을 보며
 * s의 변화에 따라 출력이 어떻게 변하는지 이해해야한다.
 * 그리고 숫자를 표현하는 요소를 인덱스화해서 배열로 표현하고 행마다 숫자를 읽으며 출력한다.
 */

public class BOJ_2290 {

	static int[][] arr = {
			{1, 1, 1, 0, 1, 1, 1}, //0
			{0, 0, 1, 0, 0, 1, 0}, //1 
			{1, 0, 1, 1, 1, 0, 1}, //2
			{1, 0, 1, 1, 0, 1, 1}, //3
			{0, 1, 1, 1, 0, 1, 0}, //4
			{1, 1, 0, 1, 0, 1, 1}, //5 
			{1, 1, 0, 1, 1, 1, 1}, //6
			{1, 0, 1, 0, 0, 1, 0}, //7
			{1, 1, 1, 1, 1, 1, 1}, //8
			{1, 1, 1, 1, 0, 1, 1}  //9
	};
	static int s;
	static String num;
	static int len;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.nextInt();
		num = sc.next();
		len = num.length();
		
		//가로1
		printHorizontal(arr, 0);
		//세로1
		printVertical(arr, 1); 
		//가로2
		printHorizontal(arr, 3);
		//세로2 
		printVertical(arr, 4);
		//가로3
		printHorizontal(arr, 6);
		


	}

	static void printBar(int isPrint, char c) {
		if(isPrint == 1)
			System.out.print(c);
		else
			System.out.print(" ");
	}
	
	static void printHorizontal(int[][] arr, int idx) {
		for(int i = 0; i < len; i++) {
			System.out.print(" ");

			for(int j = 0; j < s; j++) {
				printBar(arr[num.charAt(i)-'0'][idx], '-');
			}
			System.out.print("  "); // 마지막 추가까지 두번 띄어쓰기
		}
		System.out.println();
	}
	static void printVertical(int[][] arr, int idx) {
		for(int k = 0; k < s; k++) {
			for(int i = 0; i < len; i++) {
				printBar(arr[num.charAt(i)-'0'][idx], '|');
				for(int j = 0; j < s; j++)
					System.out.print(" ");
				printBar(arr[num.charAt(i)-'0'][idx+1], '|');
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
}

/*
 * character를 숫자로 받을 때 -'0' 해주는 거 잊지마! 
 */

//import java.util.*;
//public class Main {
//    static final int[][] c = {
//        {1,1,1,0,1,1,1},
//        {0,0,1,0,0,1,0},
//        {1,0,1,1,1,0,1},
//        {1,0,1,1,0,1,1},
//        {0,1,1,1,0,1,0},
//        {1,1,0,1,0,1,1},
//        {1,1,0,1,1,1,1},
//        {1,0,1,0,0,1,0},
//        {1,1,1,1,1,1,1},
//        {1,1,1,1,0,1,1}
//    };
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int s = sc.nextInt();
//        String n = sc.next();
//        int m = n.length();
//        for (int i=0; i<5; i++) {
//            if (i == 0 || i == 2 || i == 4) {
//                for (int j=0; j<m; j++) {
//                    int now = n.charAt(j)-'0';
//                    if (j != 0) {
//                        System.out.print(" ");
//                    }
//                    System.out.print(" ");
//                    if ((i == 0 && c[now][0] == 1) || (i == 2 && c[now][3] == 1) || (i == 4 && c[now][6] == 1)) {
//                        for (int k=0; k<s; k++) {
//                            System.out.print("-");
//                        }
//                    } else {
//                        for (int k=0; k<s; k++) {
//                            System.out.print(" ");
//                        }
//                    }
//                    System.out.print(" ");
//                }
//                System.out.println();
//            } else {
//                for (int l=0; l<s; l++) {
//                    for (int j=0; j<m; j++) {
//                        int now = n.charAt(j) - '0';
//                        if (j != 0) {
//                            System.out.print(" ");
//                        }
//                        if ((i == 1 && c[now][1] == 1) || (i == 3 && c[now][4] == 1)) {
//                            System.out.print("|");
//                        } else {
//                            System.out.print(" ");
//                        }
//                        for (int k=0; k<s; k++) {
//                            System.out.print(" ");
//                        }
//                        if ((i == 1 && c[now][2] == 1) || (i == 3 && c[now][5] == 1)) {
//                            System.out.print("|");
//                        } else {
//                            System.out.print(" ");
//                        }
//                    }
//                    System.out.println();
//                }
//            }
//        }
//
//    }
//}




