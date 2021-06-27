package bruteforce;

/*
 * BOJ 1476 날짜계산
 * ESM 각각에 해당하는 수로 나머지 연산해서 세가지 모두 만족하는 최소숫자를 찾는 문제
 * 나머지 연산자는 %N일 때 0~N-1의 수를 반복한다. 
 * 문제에서는 1~N을 반복하기 때문에 전체 -1로 생각하고 수행한다음에 답 낼 때만 +1을 해줬다.
 * 내 과거 풀이대로 (i%15)+1 == n1 && (i%28)+1 == n2 && (i%19)+1 == n3
 * 이렇게 해줄 수도 있다.
 */
import java.util.Scanner;

public class BOJ_1476 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt() - 1;
		int S = sc.nextInt() - 1;
		int M = sc.nextInt() - 1;
		for(int i = E; i < (15*28*19); i += 15) {
			if(i % 28 == S && i % 19 == M) {
				System.out.println(i+1);
				break;
			}
		}
    }
}

//import java.util.Scanner;
//public class Main {
//	public static void main(String args[]) {
//		Scanner s = new Scanner(System.in);
//		int n1 = s.nextInt();
//		int n2 = s.nextInt();
//		int n3 = s.nextInt();
//		for(int i = 0; i <=15*28*19; i++) {
//			if((i%15)+1 == n1 && (i%28)+1 == n2 && (i%19)+1 == n3) {
//				System.out.println(i+1);
//				break;
//			}
//		}
//	}
//}


