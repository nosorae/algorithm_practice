package dfs_bfs;
/*
 * 2021.07.11
 * BOJ 1697 숨바꼭질 https://www.acmicpc.net/problem/1697
 * 일차원 좌표상에서 시작점과 목적지가 있을 때 +1 -1 *2 세가지 연산만 이용해서 목적지에 도착하는 거리이다.
 * 문제는 시작지점이 0인 것으로 암시적으로 나타나있지만, 
 * 시작지점의 거리를 1로 초기화했다.(이러면 방문여부를 dist만으로 체크해서 중복 방문을 방지할 수 있다.) 
 * 대신 도착할 때의 거리에서 -1해서 답을 내야한다.
 * bfs/dfs는 항상 한번 방문했던 곳에 도착하지 않는 장치가 필요하다. 
 * start와 end가 같을 때 예외처리를 해줘야한다.
 */

import java.util.*;
import java.io.*;
public class Main  {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bw.write(bfs(n, k, 200000)+""); bw.flush();
	}
	static int bfs(int start, int end, int len) {
		int[] dist = new int[len+1];
		Queue<Integer> q = new LinkedList<Integer>();
		if(start == end) 
			return 0;
		dist[start] = 1;
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			//찾자마자 바로 리턴해서 조금이라도 빠르게 답을 내려고했다.
			if(cur+1 == end || cur-1 == end || cur*2 == end) {
				return dist[cur];
			}
			oneCycle(dist, q, cur, cur*2, len);
			oneCycle(dist, q, cur, cur+1, len);
			oneCycle(dist, q, cur, cur-1, len);
		}
		//못찾은 경우인데 여기서는 1단위로 움직이기 때문에 이곳에 도달할 일은 없다.
		return 0; 
	}
	
	static void oneCycle(int[] dist, Queue<Integer> q, int cur, int next, int len) {
		if(next >= 0 && next < len && dist[next] == 0) {
			dist[next] = dist[cur]+1;
			q.add(next);
		}
	}
}

