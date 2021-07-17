package bruteforce;



/*
 * BOJ 6603 로또
 * N과 M 6? 문제랑 같은 방식으로 풀면 된다.
 * 근데 이걸 순열로도 풀 수 있다고 하는데, N개에서 M개 뽑는 방식은 각각 뽑고 안뽑고가 있을 대
 * N개중에서 M개를 뽑고로 선택하면 되는 문제이다. 그래서 앞에 0을 k-6개, 그리고 1을 6개 깔고 순열 순회하면 답을 알 수 있다.
 * 아래 한 번 더 풀이한 코드도 있다. 전의 내가 이름을 더 잘 지은 것 같다. 분발해야지
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





//import java.util.*;
//import java.io.*;
//class Main {
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	public static void main(String args[]) throws Exception	{
//
//		String input = "";
//		while(!(input = br.readLine()).equals("0")) {
//			StringTokenizer st = new StringTokenizer(input);
//			int n = Integer.parseInt(st.nextToken());
//			int[] arr = new int[n];
//			int[] result = new int[6];
//			for(int i = 0; i < n; i++) {
//				arr[i] = Integer.parseInt(st.nextToken());
//			}
//	
//			placeAll(arr, result, 0, 0);
//			bw.write("\n");
//		}
//		bw.flush();
//		
//	}
//	
//	static void placeAll(int[] arr, int[] result, int depth, int start) throws IOException {
//		if(depth == 6) {
//			printLotto(result);
//			return;
//		}
//		for(int i = start; i < arr.length; i++) {
//			result[depth] = arr[i];
//			placeAll(arr, result, depth+1, i+1);
//			
//		}
//	}
//	
//	static void printLotto(int[] result) throws IOException {
//		for(int i = 0; i < result.length; i++) {
//			bw.write(result[i]+" ");
//		}
//		bw.write("\n");
//		
//	}
//}


