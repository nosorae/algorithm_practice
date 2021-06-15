package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * 백준 1697 숨바꼭질
 * 1. 각 위치를 정점이라고 생각하고 -1 +1 *2 인 위치를 연결된 정점이라고 생각하면 bfs 최단거리문제가 된다. 
 * 2. 두 위치가 같은 경우 나처럼 시작점 distance를 1로 두고 시작하고 check배열을 안두면 찾을 수 없다..
 * 3. bfs탐색시 시작점에대한 예외처리 필요성을 깨달음!!
 */

public class BOJ_1697 {
    
    final static int size = 100001;
    static int[] direc = {-1, 1, 2};
    
    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);
        int[] distance = new int[size]; 
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        
        int ans = bfs(distance, start, end);
        
        if(start == end)
        	ans = 0;
        
        System.out.println(ans);
        
    }
    
    static int bfs(int[] distance, int start, int end) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        distance[start] = 1;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < 3; i++) {
            	
                int next = cur + direc[i];
                if(i == 2)
                    next = cur * direc[i];
                
                if(isIn(next) && distance[next] == 0) {
                    if(next == end)
                        return distance[cur];
                    else {
                        q.add(next);
                        distance[next] = distance[cur] + 1;
                    }
                }
            }
        }
        
         return -1;
        
    }
    static boolean isIn(int cur) {
        if(cur >= 0 && cur < size)
            return true;
        else
            return false;
    }
  
}