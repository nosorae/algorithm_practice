package bruteforce;

/*
 * BOJ 11723 집합
 * 비트마스크 연습차 해보는 집합 문제
 * 숫자 제한이 1~20이라서 비트마스크로 가능한 것이다. 32개 넘으면 해쉬셋을 쓰자
 */
import java.util.*;
import java.io.*;

public class BOJ_11723 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		int set = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
			case "add":
				set = add(set, Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				set = remove(set, Integer.parseInt(st.nextToken()));
				break;
			case "check":
				if(check(set, Integer.parseInt(st.nextToken())))
					bw.write(1+"\n");
				else
					bw.write(0+"\n");
				break;
			case "toggle":
				set = toggle(set, Integer.parseInt(st.nextToken()));
				break;
			case "all":
				set = (1 << 21) - 1;
				break;
			case "empty":
				set = 0;
			}
		}
		br.close();
		bw.flush(); bw.close(); 
		



	}
	static int add(int n, int x) {
		return (n | (1 << x));
		
	}
	static int remove(int n, int x) {
		if(check(n, x))
			return (n - (1 << x));
		else
			return n;
	}
	static boolean check(int n, int x) {
		if((n & (1 << x)) != 0)
			return true;
		else
			return false;
	}
	static int toggle(int n, int x) {
		n = (n ^ (1 << x));
		return n;
	} 
}



