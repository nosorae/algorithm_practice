package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * 백준  1260 DFS와 BFS
 * 1. BufferedWriter/Reader 쓸 때 함수에 throws IOException 잊지 말자 
 * 2. static 빼먹지 말자
 * 3. 정점의 스타트가 1인지 0인지 잘 파악해라
 */

class BOJ_1260 {
    static boolean[] check;
    static LinkedList<Integer>[] graph;
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //정점 개수, 간선 개수, 시작정점
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        //초기화
        graph = new LinkedList[n+1]; 
        for(int i = 1 ; i <= n; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        
        //간선 입력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            graph[x].add(y);
            graph[y].add(x);
        }
        
        for(int i = 1 ; i <= n; i++) {
        	Collections.sort(graph[i]);
        }
        
        check = new boolean[n+1];
        dfs(start);
        
        bw.write("\n");
        
        check = new boolean[n+1];
        bfs(start);
        
        bw.flush();

    }
    static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<Integer>();
        check[start] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur+" ");
            for(int next : graph[cur]) {
                if(!check[next]) {
                	check[next] = true;
                	q.add(next);
                }
                    
            }
        }
        
    }
    
    static void dfs(int cur) throws IOException {
        check[cur] = true;
        bw.write(cur+ " ");
        
        for(int next : graph[cur]) {
            if(!check[next])
                dfs(next);
        }
        
    }
}