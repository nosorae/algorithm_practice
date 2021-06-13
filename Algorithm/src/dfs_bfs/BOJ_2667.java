package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * 백준 2667 단지번호 붙이기
 */

class BOJ_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; //상하좌우
    static int size;
    static int[][] map; // 지도
    static boolean[][] check; // 방문여부
    static ArrayList<Integer> team = new ArrayList<Integer>();
    static int cnt; // 팀 개수
    
    public static void main(String[] args) throws IOException {
        // 지도 크기 입력과 초기화
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        check = new boolean[size][size];
        
        // 지도 입력 
        for(int i = 0; i < size; i++) {
            String line = br.readLine();
            for(int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        
        // 모든 좌표를 순회하며 해당 좌표값이 1이면서 방문하지 않았다면 dfs
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] == 1 && !check[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    team.add(cnt);
                } 
            }
        }
        
        Collections.sort(team);
        System.out.println(team.size());
        for(int ans : team) {
            System.out.println(ans);
        }
        
    }
    static void dfs(int curX, int curY) {
        check[curX][curY] = true;
        cnt++;
        
        for(int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];
            if(nextX >= 0 && nextX < size && nextY >= 0 && nextY < size) {
                if(map[nextX][nextY] == 1 && !check[nextX][nextY])
                    dfs(nextX, nextY);
            }
        }
        
        
    }
}