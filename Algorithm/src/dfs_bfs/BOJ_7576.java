package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * 백준 7576 토마토
 * 1. 문제 조건분석을 제대로 해라 정답은 '며칠이 지나야'이다. 
 * 	    따라서 다음 날 부터 1일이다.
 */

public class BOJ_7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int[][] box;
    static int[][] dist; 
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        dist = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Queue<Integer> qX = new LinkedList<Integer>();
        Queue<Integer> qY = new LinkedList<Integer>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 1) {
                    qX.add(i);
                    qY.add(j);
                    dist[i][j] = 1;
                }
            }
        }
        
        while(!qX.isEmpty()) {
            int curX = qX.poll();
            int curY = qY.poll();
            int distance = dist[curX][curY];
            //System.out.println(distance);
            
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(isIn(n, m, nextX, nextY) && box[nextX][nextY] != -1 
                   && (dist[nextX][nextY] == 0 || dist[nextX][nextY] > dist[curX][curY]+1)) {
                    qX.add(nextX);
                    qY.add(nextY);  
                    dist[nextX][nextY] = distance+1;
                }
            }
           
        }
        
        boolean flag = true;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
           
                int distance = dist[i][j];
                //System.out.print(distance+" ");
                if(distance == 0 && box[i][j] != -1) {
                    flag = false;
                    break;
                }
                if(distance > ans)
                    ans = distance;
            }
            //System.out.println();
            if(!flag)
                break;
        }
        
        if(!flag) 
            System.out.println(-1);
        else
            System.out.println(ans-1);
    }
    
    static boolean isIn(int vertical, int horizontal, int x, int y) {
        if(x >= 0 && x < vertical && y >= 0 && y < horizontal) {
            return true;
        }
        else 
            return false;
    }
    
}