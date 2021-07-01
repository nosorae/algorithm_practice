package bruteforce;
/*
 * BOJ 2529 부등호
 * 0-9까지 중복x 순서x로 k+1개 뽑아서 입력으로 주어진 k개의 부등호 관계 만족하는지 찾으면 된다. 
 * 입력이 어떻게 들어올지 모르니 다 해봐야하긴 하는데, 앞에서 이미 만족을 못하다면 더 해볼 필요 없기때문에 백트래킹을 하든지
 * 아니면 애초에 각 부등호에 맞게 다음 재귀 인자를 넣어주던지 하면 된다. 
 * 문제가 원하는 답을 똑바로 파악해라 문제에서는 다 출력하는 게 아니라 min max를 원하다구
 * 그리고 0으로 시작하는 숫자를 parse
 */
import java.util.*;
import java.io.*;

public class BOJ_2528 {
	static boolean[] check = new boolean[10];
	static long max = 0L;
	static long min = 9876543211L;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		char[] sign = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			sign[i] = st.nextToken().charAt(0); 
		}
		for(int i = 0; i <= 9; i++) {
			check[i] = true;
			placeAll(sign, k, i+"");
			check[i] = false;
		}
		System.out.println(max);
		if(numLen(min) <= k)
			System.out.println("0"+min);
		else			
			System.out.println(min);
	}
	static int numLen(long n) {
		return (n+"").length();
	}
	static void placeAll(char[] sign, int k, String ans) {
		
		int depth = ans.length()-1;
		if(depth+1 == k+1) {
			// 0으로 시작하는 숫자 예외처리?
			long cur = Long.parseLong(ans);
			if(min > cur)
				min = cur;
			if(max < cur)
				max = cur;
			return;
		}
		

		int num = ans.charAt(depth) - '0';
		if(sign[depth] == '>') {
			for(int i = 0; i < num; i++) {
				if(!check[i]) {
					check[i] = true;
					placeAll(sign, k, ans+i);
					check[i] = false;
				}
			}
		}
		else {
			for(int i = num+1; i <= 9; i++) {
				if(!check[i]) {
					check[i] = true;
					placeAll(sign, k, ans+i);
					check[i] = false;
				}
			}
		}


	}


}



