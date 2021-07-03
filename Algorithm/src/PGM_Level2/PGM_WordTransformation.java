package PGM_Level2;

// 2021.07.02
// PGM 단어 변환 https://programmers.co.kr/learn/courses/30/lessons/43163
//두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 
//최소 거리를 찾는문제, 단어들이 정점이고 한글자만 차이나면 연결 됐다고 생각하면 bfs문제가 된다.
//변환 불가인 경우 0리턴
import java.util.*;
class PGM_WordTransformation {
 static int[] dist;
 static String[] print;
 public int solution(String begin, String target, String[] words) {
     print = words;
     int len = words.length;
     LinkedList<Integer>[] graph = new LinkedList[len];
     for(int i = 0; i < len; i++) {
         graph[i] = new LinkedList<Integer>();
     }
     
     // 그래프 초기화
     for(int i = 0; i < len; i++) {
         for(int j = 0; j < len; j++) {
             if(i == j) continue;
             if(isLinked(words[i], words[j]))
                 graph[i].add(j);
         }
     }
     
     //시작 끝 인덱스 찾기 
     int start = -1;
     int end = -1;
     for(int i = 0; i < len; i++) {
         if(isLinked(words[i], begin))
             start = i;
         if(words[i].equals(target))
             end = i;
     }
     if(start == -1 || end == -1) //없으면 바로 0 반환
         return 0;
     
     
     
     
     
     System.out.println(start+" "+end);
     
     bfs(graph, start, end);
     int answer = dist[end];
     return answer;
 }
 static boolean isLinked(String s1, String s2) {
     int cnt = 0;
     for(int i = 0; i < s1.length(); i++) {
         if(s1.charAt(i) != s2.charAt(i))
             cnt++;
     }
     if(cnt == 1)
         return true;
     else
         return false;
 }
 
 static void bfs(LinkedList<Integer>[] graph, int start, int end) {
     Queue<Integer> q = new LinkedList<Integer>();
     dist = new int[graph.length];
     
     dist[start] = 1;
     q.add(start);
     while(!q.isEmpty()) {   
         int cur = q.poll();
         for(int next : graph[cur]) {
             if(dist[next] == 0) {
                 dist[next] = dist[cur] + 1;
                 q.add(next);
             }
         }
     }
 }
}