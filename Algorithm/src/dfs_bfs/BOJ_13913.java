package dfs_bfs;

import java.util.*;
import java.io.*;
/*
 * 백준 13913 숨바꼭질4 
 * 1. 양의 방향으로 이동하는 next정점은 최대값 경계처리만 해줘도 되고
 *    음의 방향으로 이동하는 next정점은 최소값 경계처리만 해줘도 된다.
 */
public class BOJ_13913 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int start;
    static int end;
    static final int size = 200001;
    static int[] dist = new int[size];
    static int[] prev = new int[size];
    static int[] direc = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        if(start == end) {
            System.out.println(0);
            printTrace(end, start);
            return;
        }
        else {
            int ans = bfs(start, end);
            System.out.println(ans);
            printTrace(end, start);
        }
            
        
        
    }
    
    static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        dist[start] = 1;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < 3; i++) {
                int next = cur + direc[i];
                if(i == 2) 
                    next = cur * direc[i];
                if(next >= 0 && next < size && dist[next] == 0) {
                    prev[next] = cur;
                    
                    if(next == end)
                        return dist[cur];
                    
                    
                    q.add(next);
                    dist[next] = dist[cur] + 1;
                   
                }
            }
        
        }
        return 0;
    }
    static void printTrace(int end, int start) {
        Stack<Integer> stack = new Stack<Integer>();
        int cur = end;
        while(cur != start) {
            stack.push(cur);
            cur = prev[cur];
        }
        stack.push(cur);
        
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
        
    }
}