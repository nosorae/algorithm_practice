
/*
 * BOJ 1248 맞춰봐
 * 목표는 규현이가 쓴 숫자가 무엇인지 맞추는 것이다. 배열 입력에 따라 답이 뭐가 될지 모르니 다 해봐야겠다.
 * 그리고 후보는 -10~10으로 21개인데  21^10은 너무 많다. 
 * 그러니 다 해보되 백트래킹을 써야한다.
 * 일단 arr[i][i]를 보면 부호정도는 알 수 있다. 10^10으로 줄어든다. 10,000,000,000..
 * arr[i][i]를 보고 양수면 1~10 음수면 -10~-1 그리고 0이면 0으로 넣고 다음 숫자를 시도하면된다. 
 */
import java.util.*;
import java.io.*;

public class Main {
	static char[][] arr;
	public static void main(String[] args) throws Exception {
		
		for(int i = 0; i < 2*2*2*2*2*2; i++) {
			String s = Integer.toBinaryString(i);
			if(s.length() < 6) {
				while(s.length() != 6) {
					s = "0"+s;
				}
			}
			System.out.println(s);
		}
		
	}
}



