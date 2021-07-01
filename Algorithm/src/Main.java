
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		int[] ans = new int[n];
		String input = br.readLine();
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				arr[i][j] = input.charAt(idx++);
			}
		}
		findAnswer(ans, 0);
		
	}
	static boolean findAnswer(int[] ans, int idx) {
		if(idx > 1 && !check(ans, idx)) 
			return false;
		
		if(idx == ans.length) {
			for(int i = 0; i < idx; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return true;
		}
		
		
		if(arr[idx][idx] == '0') {
			ans[idx] = 0;
			return findAnswer(ans, idx+1);
		}
		else {
			boolean flag = false;
			for(int i = 1; i <= 10; i++) {
				if(arr[idx][idx] == '-') {
					ans[idx] = -i;
					flag = findAnswer(ans, idx+1);
				}
				else {
					ans[idx] = i;
					flag = findAnswer(ans, idx+1);
				}
				if(flag)
					return true;
			}
		}
		return false;
	}
	
	static boolean check(int[] ans, int idx) {
		for(int i = 0; i < idx; i++) {
			int sum = 0;
			for(int j = i; j < idx; j++) {
				sum += ans[j];
				if(arr[i][j] == '+' && sum <= 0)
					return false;
				else if(arr[i][j] == '-' && sum >= 0)
					return false;
				else if(arr[i][j] == '0' && sum != 0)
					return false;
			}
		}
		return true;
	}
}



