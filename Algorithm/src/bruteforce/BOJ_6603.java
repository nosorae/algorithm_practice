package bruteforce;



/*
 * BOJ 6603 로또
 * N과 M 6? 문제랑 같은 방식으로 풀면 된다.
 * 근데 이걸 순열로도 풀 수 있다고 하는데, N개에서 M개 뽑는 방식은 각각 뽑고 안뽑고가 있을 대
 * N개중에서 M개를 뽑고로 선택하면 되는 문제이다. 그래서 앞에 0을 k-6개, 그리고 1을 6개 깔고 순열 순회하면 답을 알 수 있다.
 */
import java.util.*;
import java.io.*;

public class BOJ_6603 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int k = sc.nextInt();
			if(k == 0)
				break;
			int[] candidate = new int[k];
			for(int i = 0; i < k; i++) {
				candidate[i] = sc.nextInt();
			}
			selectSixNum(candidate, "", 0, 0);
			System.out.println();
		}
	}
	static void selectSixNum(int[] candidate, String result, int depth, int start) {
		if(depth == 6) {
			System.out.println(result);
			return;
		}
		for(int i = start; i < candidate.length; i++) {
			selectSixNum(candidate, result+candidate[i]+" ", depth+1, i+1);
		}
	}
}



