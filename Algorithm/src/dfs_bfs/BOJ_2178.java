package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * 백준 2178번 미로 탐색
 * 1. 인덱스가 1부터 시작하는데 경계검사는 0~(n-1)로해서 n,m의 답은 계속 0이 나오는 문제가 있었다.
 * 2. 그리고 행과 열의 길이가 다르게 주어지는 문제인데, 이중for문 2차원 배열 입력에서 m이 아닌 n까지 입력받도록 오타를 냈다. 정신 차려..
 */

public class BOJ_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0}; // 동서남북
    static int n; // 세로
    static int m; // 가로
    static int[][] map; //지도
    static int[][] check; // 방문여부이자 거리
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n+1][m+1];
        check = new int[n+1][m+1];
        
        for(int i = 1; i <= n; i++) {
            String line = br.readLine();
            for(int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        
        bfs(1, 1);
        
        System.out.println(check[n][m]);
//        for(int i = 1; i <= n; i++) {
//        	for(int j = 1; j <= m; j++) {
//        		System.out.print(check[i][j]+" ");
//        	}
//        	System.out.println();
//        }
    }
    
    static void bfs(int startX, int startY) {
        Queue<Integer> qX = new LinkedList<Integer>();
        Queue<Integer> qY = new LinkedList<Integer>();
        qX.add(startX);
        qY.add(startY);
        int distance = 1;
        check[startX][startY] = distance;
        

        while(!qX.isEmpty()) {
            int curX = qX.poll();
            int curY = qY.poll();
            distance = check[curX][curY];
            distance++;
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(isIn(n, m, nextX, nextY) && map[nextX][nextY] == 1 
                   && check[nextX][nextY] == 0)  {
                    qX.add(nextX);
                    qY.add(nextY);
                    check[nextX][nextY] = distance;
                }
            }
        }
    }
    
    static boolean isIn(int vertical, int horizontal, int x, int y) {
        if(x >= 1  && x <= vertical && y >= 1 && y <= horizontal) 
            return true;
        else 
            return false;
    }
}