package dfs_bfs;


import java.io.*;
import java.util.*;


/*
 * 백준
 * 1. dfs bfs 기본을 잊고 푸니까 삽질을 좀 했다.
 * 	   무슨 말이냐면, dfs bfs의 기본은 모든 정점을 방문해보는 것이 기본인데 내가
 * 	 return dfs 이렇게 불러서 false가 오면 더이상 탐색 안해도 되는 거 맞긴한데, true가 와도 더 이상 다른 정점을 확인하지 않아서 오답이 나왔다. 
 */
class BOJ_1727 {

	static BufferedReader br;
	static int loop; // 전체 루프횟수
	static int vNum; // 정점 숫자
	static int eNum; // 간선 숫자
	static LinkedList<Integer>[] graph; // 그래프 
	static int[] check; // 정점 방문 여부 

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		loop = Integer.parseInt(br.readLine());

		for(int loopCnt = 0; loopCnt < loop; loopCnt++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());

			//정점 수, 간선 수 입력
			int vNum = Integer.parseInt(st.nextToken());
			int eNum = Integer.parseInt(st.nextToken());

			//그래프 초기화, 팀 구분 배열 초기화
			graph = new LinkedList[vNum+1];
			check = new int[vNum+1];
			for(int i = 1; i <= vNum; i++) {
				graph[i] = new LinkedList<Integer>();
				check[i] = -1;
			}
			
			for(int i = 1; i <= eNum; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x].add(y);
				graph[y].add(x);
			}


			boolean isYes = true;
			for(int i = 1; i <= vNum; i++) {
				if(check[i] == -1 && !dfs(i, 0)) {
					//System.out.println("false 도달 "+loop+"회에서"+i);
					isYes = false;
				}
			}
			
			
			if(isYes) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}





		}
	}
	static boolean dfs(int cur, int team) {

		check[cur] = team;

		for(int next : graph[cur]) {
			
			if(cur != next && check[cur] == check[next]) // 루프가 아니고 연결되어있는데, 같은 팀이라면 그것은 이분그래프가 아니다.
				return false;
			
			if(check[next] == -1 && !dfs(next, (team+1)%2)) { //false가 나오면 바로 return하는 코드
				return false;
			}
			
		}

		return true;

	}
}

/*
 * 1과 2를 반복하고 싶다면 3-x를 3-1나 3-2로 시작하면 반복할 수 있다. 
 * 나는 모듈러스밖에 생각안하고 있었는데 무조건 0부터 시작해야하는 단점?이 존재했다.
 */

//
//import java.util.*;
//
//public class Main {
//    public static boolean dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
//        color[x] = c;
//        for (int y : a[x]) {
//            if (color[y] == 0) {
//                if (dfs(a, color, y, 3-c) == false) {
//                    return false;
//                }
//            } else if (color[y] == color[x]) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
//            for (int i=1; i<=n; i++) {
//                a[i] = new ArrayList<Integer>();
//            }
//            for (int i=0; i<m; i++) {
//                int u = sc.nextInt();
//                int v = sc.nextInt();
//                a[u].add(v);
//                a[v].add(u);
//            }
//            int[] color = new int[n+1];
//            boolean ok = true;
//            for (int i=1; i<=n; i++) {
//                if (color[i] == 0) {
//                    if (dfs(a, color, i, 1) == false) {
//                        ok = false;
//                    }
//                }
//            }
//            if (ok) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }
//
//    }
//}