package dfs_bfs;


/*
 * 2021.07.14
 * BOJ 14226 이모티콘 https://www.acmicpc.net/problem/14226
 * 화면티콘 1개로 시작해서, 화면티콘 복사/ 클립티콘 붙여넣기(추가)/ 화면티콘 삭제 세가지 연산으로 S개에 도달하는 최소거리 구하는 문제
 * 추가 조건은 클립 비어있는 상태에서 붙여넣기 불가 
 * 다 해봐야할 것 같은데 문제는 어떻게 다 해볼 것인가? bfs
 * 그런데 관리해야하는 변수가 클립티콘개수, 화면티콘개수, 거리  세가지라서 
 * 한꺼번에 관리하려면 클래스를 만드는 게 속편하겠다고 판단은 잘못됐다. 왜냐하면 핵심은 화면티콘의 개수기 때문이다.
 * 따라서 화면티콘개수를 정점으로 삼아야한다. 그렇다면 거리는 어떻게 생각해야할까?
 * 화면티콘개수에 집중해서 그게 줄어들고 늘어드는 것만 생각하면 2배로 갈 때 +2 들고 -1은 +1든다.
 * 그런데 만약에 복사 - 삭제 - 붙여넣기 이런식이라면?? 현재 화면 5라면 결과는 9
 * 복사-붙여넣기-삭제 로 순서바꿔도 결과는 같다.
 * 그리고 복사해놓고 붙여넣기를 여러번 할 수도 있다.
 */

import java.util.*;
import java.io.*;
public class BOJ_14226  {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		bw.write(bfs(n)+""); bw.flush();
	}
	static int bfs(int goal) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
			
		
		return 0;
	}
}


