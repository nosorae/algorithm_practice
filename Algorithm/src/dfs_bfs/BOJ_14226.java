package dfs_bfs;



/*
 * 2021.07.11
 * BOJ 14226 이모티콘 https://www.acmicpc.net/problem/14226
 * 정점을 화면티콘과 클립티콘의 조합으로 정의한다.
 * 그래서 정점 거리 저장을 이차원배열에 한다.
 * 그래서 그 이차원 배열의 인덱스로 현재와 다음의 화면티콘과 클립티콘을 표현한다.
 */
import java.util.*;
import java.io.*;
public class BOJ_14226  {
	static final int Max = 2000;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		bw.write(bfs(n)+""); bw.flush();
	}
	static int bfs(int goal) {
		int answer = 0;
		int[][] dist = new int[Max][Max];
		Queue<Integer> q = new LinkedList<Integer>();
		
		dist[1][0] = 1;
		q.add(1); q.add(0);
		while(!q.isEmpty()) {
			int display = q.poll();
			int clip = q.poll();
			
			if(display == goal) {
				answer = dist[display][clip];
				break;
			}

			//복사
			if(dist[display][display] == 0) {
				dist[display][display] = dist[display][clip] + 1;
				q.add(display); q.add(display);
			}
			
			//붙여넣기
			if(display+clip < Max && dist[display+clip][clip] == 0) {
				dist[display+clip][clip] = dist[display][clip] + 1;
				q.add(display+clip); q.add(clip);
			}
			
			//삭제
			if(display-1 >= 0 && dist[display-1][clip] == 0) {
				dist[display-1][clip] = dist[display][clip] + 1;
				q.add(display-1); q.add(clip);
			}
			
		}
		return answer-1;
	}
}





