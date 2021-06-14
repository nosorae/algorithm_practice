package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * 백준 7576 토마토
 * 1. 문제 조건분석을 제대로 해라 정답은 '며칠이 지나야'이다. 
 * 	    따라서 다음 날 부터 1일이다.
 * 2. 단계별로 시행되기 때문에 내가 푼 방식대로 무엇이 더 작은지 검사할 필요가 없다.
 * 	    그처 여러 시작점을 큐에 넣고 bfs를 실행하면된다.
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


//import java.util.*;
//
//class Pair {
//    int x;
//    int y;
//    Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//public class Main {
//    public static final int[] dx = {0, 0, 1, -1};
//    public static final int[] dy = {1, -1, 0, 0};
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int[][] a = new int[n][m];
//        int[][] dist = new int[n][m];
//        Queue<Pair> q = new LinkedList<Pair>();
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                a[i][j] = sc.nextInt();
//                dist[i][j] = -1;
//                if (a[i][j] == 1) {
//                    q.add(new Pair(i, j));
//                    dist[i][j] = 0;
//                }
//            }
//        }
//        while (!q.isEmpty()) {
//            Pair p = q.remove();
//            int x = p.x;
//            int y = p.y;
//            for (int k=0; k<4; k++) {
//                int nx = x+dx[k];
//                int ny = y+dy[k];
//                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
//                    if (a[nx][ny] == 0 && dist[nx][ny] == -1) {
//                        q.add(new Pair(nx, ny));
//                        dist[nx][ny] = dist[x][y] + 1;
//                    }
//                }
//            }
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                if (ans < dist[i][j]) {
//                    ans = dist[i][j];
//                }
//            }
//        }
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                if (a[i][j] == 0 && dist[i][j] == -1) {
//                    ans = -1;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}