package dfs_bfs;

import java.util.*;
import java.io.*;
/*
 * 백준 7562 나이트의 이동
 */

public class BOJ_7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int[][] dist;
    static int size;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public static void main(String[] args) throws IOException {
        
        int testCase = Integer.parseInt(br.readLine());
        
        for(int loop = 0; loop < testCase; loop++) {
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            dist = new int[size][size];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            
            int ans = moveNights(startX, startY, endX, endY);
            
            if(ans != -1) {
                System.out.println(ans);
            }
            
            
        }
    }
    
    static int moveNights(int startX, int startY, int endX, int endY) {
        if(startX == endX && startY == endY)
            return 0;
        
        Queue<Integer> qX = new LinkedList<Integer>();
        Queue<Integer> qY = new LinkedList<Integer>();
        qX.add(startX);
        qY.add(startY);
        dist[startX][startY] = 1;
        
        while(!qX.isEmpty()) {
            int curX = qX.poll();
            int curY = qY.poll();
            
            for(int i = 0; i < 8; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                
                
                if(isIn(nextX, nextY)) {
                    
                    if(endX == nextX && endY == nextY)
                        return dist[curX][curY]; //next의 거리는 cur의 거리+1 이고 거리 1로 시작
                    
                    else if(dist[nextX][nextY] == 0) {
                        qX.add(nextX);
                        qY.add(nextY);
                        dist[nextX][nextY] = dist[curX][curY] + 1;
                    }
                   
                }
            }
            
        }
        
        return -1;
    }
    
    static boolean isIn(int x, int y) {
        if(x >= 0 && x < size && y >= 0 && y < size) 
            return true;
        else 
            return false;
    }
}