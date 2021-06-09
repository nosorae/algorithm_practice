package dfs;

import java.io.*;
import java.util.*;

/*
 * 백준 13023 ABCDE
 * 1. 시작이 0이냐 1이냐 문제 잘 따져
 * 2. 재귀함수의 return 값 전달릴레이를 신경써라!
 * 3. dfs에서 모든 경로에 대해 경우의 수를 다해보려면 들어갔다 나오는 정점은 다시 false초기화 해줘야한다.
 * 	    왜냐하면 부모 정점입장에서는 이미 for문이 지나가서 다시 방문할 일 없어서 괜찮고 다른 자식정점에서 방문하려면 false여야하기 때문이다.
 * 	    계속 true로 해놓으면 다른 자식정점에서 더 긴 경로를 찾을 수 있는데 들어가지 못해서 더 긴 경로도 찾지 못하는 문제가 발생한다.
 * 4. 제출할 때는 디버깅에 쓴 프린트문 지워라 괜히 틀리고 시간낭비 하지말고
 */

class BOJ_13023 {
	static LinkedList<Integer>[] graph;
	static boolean[] check;
	static int n; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		//그래프 초기화
		graph = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new LinkedList<Integer>();
		}

		//간선 입력
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x].add(y);
			graph[y].add(x);
		}

		//모든 정점에 대해 dfs

		for(int i = 0;  i < n; i++) {
			check = new boolean[n];
			//System.out.println();
			if(dfs(i, 1)) {
				bw.write(1+"");
				bw.flush();
				return;
			}

		}




		bw.write(0+"");
		bw.flush();


	}
	static boolean dfs(int cur, int depth) {
		check[cur] = true;

		//System.out.println("현재 "+cur+"이고 깊이는 "+depth);
		if(depth >= 5)
			return true;

		for(int next : graph[cur]) {
			if(!check[next]) {
				if(dfs(next, depth+1))
					return true;
				else 
					check[next] = false;
			}

		}
		return false;
	}
}