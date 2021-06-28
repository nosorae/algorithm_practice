package bruteforce;

/*
 * BOJ 15649 N과 M (1)
 * N개 수 중에서 중복x 순서o 하게 모두 뽑아 출력
 */
import java.util.*;
public class BOJ_15649 {
	static boolean[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		check = new boolean[n+1];
		int[] ans = new int[n+1];
		placeAll(ans, 0, n, m);
        	
        
		
	}
	static void placeAll(int[] ans, int depth, int n, int m) {
		if(depth == m) {
			for(int i = 0; i < depth; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(check[i]) continue;
			
			check[i] = true;
			ans[depth] = i;
			placeAll(ans, depth+1, n, m);
			check[i] = false;
		}
		
	}
}



