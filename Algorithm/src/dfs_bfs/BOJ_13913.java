package dfs_bfs;

import java.util.*;
import java.io.*;
/*
 * 백준 13913 숨바꼭질4 
 * 1. 양의 방향으로 이동하는 next정점은 최대값 경계처리만 해줘도 되고
 *    음의 방향으로 이동하는 next정점은 최소값 경계처리만 해줘도 된다.
 * 2. 아래 개선한 코드도 있다.
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


/*
 * 2021.07.14
 * BOJ 13913 숨바꼭질4 https://www.acmicpc.net/problem/13913
 * 기존 숨바꼭질 문제에서 start에서 end에 가기까지의 경로도 출력해야하는 문제
 * prev배열에 이전 정점번호를 기록한 것을 뒤집으면 경로도 구할 수 있다.
 * 기존 숨바꼭질 풀 때 next를 찾을 때 바로 최단거리만 return하고 끝났는데 이번에는 end의 prev도 채워줘야한다.
 * 안그러면 oneCycle함수에 들어가지 않아서 prev[end]의 값이 0이라서 무한반복문을 돈다.
 * 그리고 같으면 바로 return하도록 했는데 같은 경우도 숫자하나는 출력해야하므로 prev[start]=-1을 그 이전에 써준다.
 */

//import java.util.*;
//import java.io.*;
//public class Main  {
//	static int[] prev = new int[200001];
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	public static void main(String[] args) throws IOException {
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
//		
//		bw.write(bfs(n, k, 200000)+"\n");
//		traceBack(k);
//		
//		bw.flush();
//	}
//	static int bfs(int start, int end, int len) {
//		int[] dist = new int[len+1];
//		Queue<Integer> q = new LinkedList<Integer>();
//		
//		prev[start] = -1;
//		if(start == end) 
//			return 0;
//		
//		dist[start] = 1;
//		q.add(start);
//		while(!q.isEmpty()) {
//			int cur = q.poll();
//			//찾자마자 바로 리턴해서 조금이라도 빠르게 답을 내려고했다. 이게 역추적에서 문제였다. 
//			//마지막 것도 prev에 넣어주어야했다.
//			if(cur+1 == end || cur-1 == end || cur*2 == end) {
//				prev[end] = cur;
//				return dist[cur];
//			}
//			oneCycle(dist, q, cur, cur*2, len);
//			oneCycle(dist, q, cur, cur+1, len);
//			oneCycle(dist, q, cur, cur-1, len);
//		}
//		//못찾은 경우인데 여기서는 1단위로 움직이기 때문에 이곳에 도달할 일은 없다.
//		return 0; 
//	}
//	
//	static void oneCycle(int[] dist, Queue<Integer> q, int cur, int next, int len) {
//		if(next >= 0 && next < len && dist[next] == 0) {
//			dist[next] = dist[cur]+1;
//			prev[next] = cur;
//			q.add(next);
//		}
//	}
//	
//	static void traceBack(int end) throws IOException {
//		Stack<Integer> stack = new Stack<Integer>();
//		int cur = end;
//		while(cur != -1) {
//			stack.add(cur);
//			cur = prev[cur];
//		}
//		
//		while(!stack.isEmpty()) {
//			bw.write(stack.pop()+" ");
//		}
//	}
//}

