import java.io.*;
import java.util.*;

/*
 * 백준 13023 ABCDE
 * 시작이 0이냐 1이냐 문제 잘 따져
 * dfs 기본이 다 가보는 건데 for문에서 return문 써버리면 다 들어가지 않는다.(프린트 디버깅하다가 발견)
 */

class Main {
	static LinkedList<Integer>[] graph;
	static boolean[] check;
	static int n; 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		

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
			dfs(i, 1);

		}


		bw.write(0+"");
		bw.flush();

	}
	static void dfs(int cur, int depth) {
		check[cur] = true;
		
		if(depth >= 5) {
			System.out.println(1);
			System.exit(0);
		}
			


		for(int next : graph[cur]) {
			if(!check[next]) {
				dfs(next, depth+1);
			}

		}
		
	}
}