package bruteforce;

/*
 * BOJ 1759 암호만들기 
 * C개의 문자중에서 중복x 순서x 오름차순으로 L개 뽑는 브루트포스 문제 
 * 각 문자를 뽑고 안뽑고 선택의 문제로 바라봄 
 * 추가 조건이 있다. 최소 모음 한 개 이상 자음 두개 이상인 것이다. 모음에는 a e i o u라고 문제에서 줬네.. 제대로 읽어라
 * 최대 15개에서 뽑고 안뽑고를 결정하고 매번 L번 검사해야하니  2^15*15로 할만하다.
 */
import java.util.*;
import java.io.*;
public class BOJ_1759 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int chs= Integer.parseInt(st.nextToken());
		char[] source = new char[chs];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < chs; i++) {
			source[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(source);
		pickAllCombination(source, len, 0, "");
	}
	static void pickAllCombination(char[] src, int len, int idx, String str) {
		if(str.length() == len) {
			if(check(str))
				System.out.println(str);
			return;
		}
		if(idx >= src.length)
			return;
		
		pickAllCombination(src, len, idx+1, str+src[idx]);
		pickAllCombination(src, len, idx+1, str);
	}
	// 모음하나 자음 두개이상 있는지 체크
	static boolean check(String str) {
		int mo = 0;
		int za = 0;
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if(cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u')
				mo++;
			else
				za++;
		}
		return (mo >= 1 && za >= 2);
	}
}



