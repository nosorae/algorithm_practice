package dfs_bfs;

import java.io.*;
import java.util.*;

/*
 * 백준 11724 연결 요소의 개수
 * 1. 지역변수 초기화 꼭 해줘라
 * 2. 간선개수제한이 N*(N-1)/2 인 이유를 생각해보면,
 * 두 정점 사이에 간선은 하나라고 했고, 한 정점이 다른 N-1개의 정점에 모두 연결되어있다고 할 때
 * 그런 정점이 N개 있다고 하면 N*(N-1)이고 양방향이니까 /2 
 */
class BOJ_11724 {
    static BufferedReader br;
    static int n;
    static int m;
    static boolean[] check;
    static LinkedList<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //정점 수, 간선 수, 그래프 정점배열 초기화
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new LinkedList[n+1];
        check = new boolean[n+1];
        
        //그래프 각 정점의 연결리스트 초기화
        for(int i = 1; i <= n; i++) {
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
        
        int ans = 0; 
        //모든 정점을 시작점으로 고려하고 dfs시행
        //이 과정이 몇번 시행되느냐가 문제의 정답
        for(int i = 1; i <= n; i++) {
            if(!check[i]) {
                ans++;
                dfs(i);
            }
        }
        
        System.out.println(ans);
       
    }
    static void dfs(int cur) {
        check[cur] = true;
        
        for(int next : graph[cur]) {
            if(!check[next])
                dfs(next);
        }
    }
}