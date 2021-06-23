package PGM_Level3;

/*
 * 2021.06.23
 * PGM 네트워크 https://programmers.co.kr/learn/courses/30/lessons/43162
 * 자잘한 오타실수나 import빼먹는 실수 하지마 정신차려!
 */

import java.util.*;

class PGM_Network {
    static boolean[] check;
    static LinkedList<Integer>[] graph;
    static int cnt = 0;
    public int solution(int n, int[][] computers) {
        graph = new LinkedList[n];
        check = new boolean[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!check[i]) {
                cnt++;
                dfs(i);
            }
        }
        
        return cnt;
    }
    static void dfs(int cur) {
        check[cur] = true;
        for(int next : graph[cur]) {
            if(!check[next])
                dfs(next);
        }
    }
}