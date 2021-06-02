package simulation;


import java.util.*;
/*
 * 백준 20055번 컨베이어 벨트 위의 로봇
 * 순서에 유의한다. 구현문제는 문제를 잘 해석하고 조건을 다 반영해서 구현했는지가 중요 
 * 컨베이어벨트를 옆에서 보고 있다고 인식하는 것과, 
 * 컨베이어벨트와 별개로 로봇이 따로 움직인다는 점, 
 * 그리고 로봇의 위치가 N을 초과할 일이 없다는 것을 깨달으면 쉬운문제
 */

public class BOJ_20055 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] durab = new int[2*n+1]; // 내구도
		boolean[] isOn = new boolean[2*n+1]; // 로봇여부
		int zero = 0;  // 내구도 0 갯수
		int ans = 0; // 몇 단계인가

		for(int i = 1; i <= 2*n ; i++) {
			durab[i] = sc.nextInt();
		}

		while(true) {
			ans++;

			
			//컨베이어 벨트의 이동
			isOn[n] = false;
			rotate_padding(durab);
			rotate_padding(isOn);
			isOn[n] = false;
			
//			for(int i = 1; i <= 2*n; i++) {
//				System.out.print(durab[i]+" ");
//			}
//			System.out.println();
//			for(int i = 1; i <= 2*n; i++) {
//				if(isOn[i])
//					System.out.print("1 ");
//				else
//					System.out.print("0 ");
//			}
//			System.out.println();

			
			//로봇의 이동
			for(int i = 2*n; i > 1; i--) {
				if(i-1 != n && isOn[i-1] && !isOn[i] && durab[i] >= 1) {
					isOn[i] = isOn[i-1];
					isOn[i-1] = false; // 이동 전의 위치에는 이제 로봇이 없는 것이다!!!!
					durab[i]--;
					if(durab[i] == 0)
						zero++;
				}

			}

			//로봇 올리기
			if(durab[1] >= 1 && !isOn[1]) {
				durab[1]--;
				isOn[1] = true;
				if(durab[1] == 0)
					zero++;
			}


//			for(int i = 1; i <= 2*n; i++) {
//				System.out.print(durab[i]+" ");
//			}
//			System.out.println();
//			for(int i = 1; i <= 2*n; i++) {
//				if(isOn[i])
//					System.out.print("1 ");
//				else
//					System.out.print("0 ");
//			}
//			System.out.println();
//			System.out.println();


			if(zero >= k)
				break;



		}

		System.out.println(ans);





	}
	//인덱스가 1부터 시작하는 1차원배열 한 칸 오른쪽 회전
	static void rotate_padding(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 1; i--) {
			arr[i] = arr[i-1];
		}
		arr[1] = temp;
	}
	static void rotate_padding(boolean[] arr) {
		boolean temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 1; i--) {
			arr[i] = arr[i-1];
		}
		arr[1] = temp;
	}


}

/*
 * 프린트로 디버깅해서 겨우 풀었다. 
 * 이동했으면 온전하게 모든 원소를 한 칸씩 이동시키는 게 아니라면 이동 전에 있는 칸에는 로봇이 없다고 표시해야한다.
 */


//
//import java.util.*;
//class Main {
//    static void rotate(int[] a) {
//        int temp = a[a.length-1];
//        for (int i=a.length-1; i>0; i--) {
//            a[i] = a[i-1];
//        }
//        a[0] = temp;
//    }
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] a = new int[2*n];
//        for (int i=0; i<2*n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int[] box = new int[2*n];
//        int zero = 0;
//        for (int t=1;; t++) {
//            rotate(a);
//            rotate(box);
//            if (box[n-1] == 1) {
//                box[n-1] = 0;
//            }
//            for (int i=n-2; i>=0; i--) {
//                if (box[i] == 1) {
//                    if (box[i+1] == 0 && a[i+1] > 0) {
//                        box[i+1] = 1;
//                        box[i] = 0;
//                        a[i+1] -= 1;
//                        if (a[i+1] == 0) {
//                            zero += 1;
//                        }
//                    }
//                }
//            }
//            if (box[n-1] == 1) {
//                box[n-1] = 0;
//            }
//            if (a[0] > 0) {
//                box[0] = 1;
//                a[0] -= 1;
//                if (a[0] == 0) {
//                    zero += 1;
//                }
//            }
//            if (zero >= k) {
//                System.out.println(t);
//                break;
//            }
//        }
//    }
//}


