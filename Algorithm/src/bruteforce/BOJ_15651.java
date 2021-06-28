package bruteforce;

/*
 * BOJ 15649 N과 M (3)
 * N개 수 중에서 M개를 중복o 순서o하게 모두 뽑아 출력
 * 출력을 사전순 오름차순출력이고, 중복된 수열을 출력하면 안됨
 * 출력이 많아서 System.out.print로는 시간초과 나니 BufferedWriter또는 StringBuilder를 사용
 */
import java.util.*;
import java.io.*;
public class BOJ_15651 {
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] ans = new int[n+1];
		placeAll(ans, 0, n, m);
		bw.flush();
        	
	}
	static void placeAll(int[] ans, int depth, int n, int m) throws IOException {
		if(depth == m) {
			for(int i = 0; i < depth; i++)
				bw.write(ans[i] + " ");
			
			bw.write("\n");
			return;
		}
		for(int i = 1; i <= n; i++) {
			ans[depth] = i;
			placeAll(ans, depth+1, n, m);
		}
	}
}



