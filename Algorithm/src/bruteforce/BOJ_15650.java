package bruteforce;


/*
 * BOJ 15650 N과 M (2)
 * N개 수 중에서 중복x 뽑은 것 각각의 순서가 오름차순 하게 모두 뽑아 출력
 * check 배열이 필요없는 이유!? 오름차순이니 +1수부터 채우게 되고 자연스럽게 중복이 일어나지 않는다.
 */
import java.util.*;
public class BOJ_15650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] ans = new int[n+1];
		placeAll(ans, 0, 1, n, m);
        	
	}
	static void placeAll(int[] ans, int depth, int start,  int n, int m) {
		if(depth == m) {
			for(int i = 0; i < depth; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
			return;
		}
		for(int i = start; i <= n; i++) {
			ans[depth] = i;
			placeAll(ans, depth+1, i+1, n, m);
			
		}
	}
}



