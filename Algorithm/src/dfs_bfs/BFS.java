package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 이전 정점번호를 담은 prev배열이 주어졌을 때 역추적해서 출력해주는 함수
	// prev배열의 모든 정점이 모두 이전 정점번호를 저장하고 있어야만 한다.
	// 마지막 시작점 이전 정점번호는 -1로 설정해두어야한다.
	static void traceBack(int[] prev, int end) throws IOException {
		Stack<Integer> stack = new Stack<Integer>();
		int cur = end;
		while(cur != -1) {
			stack.add(cur);
			cur = prev[cur];
		}
		
		while(!stack.isEmpty()) {
			bw.write(stack.pop()+"");
		}
	}

}
