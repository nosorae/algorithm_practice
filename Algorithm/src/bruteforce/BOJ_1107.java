package bruteforce;

import java.util.*;
/*
 * BOJ 1107 리모컨 
 * 버튼 : 0~9, +/-, 고장난 버튼 주어짐 
 * 채널 범위 : 0~무한대, 라고 했지만 100만 이상 갈거면 0에서 50만 가고 말기에 사실상 0~100만이다. 
 * 어떤 버튼이 고장난지 모르니 다 눌러보고 마지막에 단순이동과 비교해서 답을 낸다.
 * 100만 * 10 * 6 대략 6천만
 * 
 * 
 */
import java.util.*;
public class BOJ_1107 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
	
		int ans = abs(n, 100);
		HashSet<Integer> broken = new HashSet<Integer>();
		for(int i = 0; i < m; i++) {
			broken.add(sc.nextInt());
		}
		
		for(int i = 0; i < 1000000; i++) {
			//누를 수 있고, 길이가 짧다면
			if(pressNumber(broken, i) && ans > (abs(n, i) + numLen(i))) {
				ans = abs(n, i) + numLen(i);
			}
		}
		
		System.out.println(ans);
	}
	static boolean  pressNumber(HashSet<Integer> broken, int n) {
		do {
			if(broken.contains(n%10))
				return false;
			n /= 10;
		} while(n != 0);
		
		return true;
	}
	static int abs(int a, int b) {
		if(a > b)
			return a - b;
		else 
			return b - a;
	}
	static int numLen(int n) {
		String str = n+"";
		return str.length();
	}
}


//import java.util.Scanner;
//public class Main {
//	public static void main(String args[]) {
//		Scanner s = new Scanner(System.in);
//		int n  = s.nextInt();
//		int x = s.nextInt();
//		int[] arr = new int[x];
//		for(int i = 0; i < x; i++) {
//			arr[i] = s.nextInt();
//		}
//		boolean flag = false;
//		int min = Math.abs(n-100);
//		
//		for(int i = 0; i < 1000000; i++) {
//			int num = i;
//			int count = 0;
//			if(i == 0) 
//				count = 1;
//			while(num != 0) {
//				count++;
//				if(Include(arr, num%10)) {
//					flag = true;
//					break;
//				}
//				num/=10;
//			}
//			if(flag) {
//				flag = false;
//				continue;
//			}
//			if(i == 0 && Include(arr, i))
//				continue;
//
//			if(min > Math.abs(n-i)+count) {
//				min = Math.abs(n-i)+count;
//				//System.out.println(i+" "+count+" "+min);
//			}
//				
//		}
//		System.out.println(min);
//	}
//	
//	public static boolean Include(int[] arr, int x) {
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i] == x)
//				return true;
//		}
//		return false;
//	}	
//}


