import java.io.*;
import java.util.*;


/*
 * 백준 1707 이분 그래프
 * 
 */
class Main {
  
    static BufferedReader br;
	static int loop; // 전체 루프횟수
	static int vNum; // 정점 숫자
	static int eNum; // 간선 숫자
	static LinkedList<Integer>[] graph; // 그래프 
	static boolean[] check; // 정점 방문 여부 
	
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        loop = Integer.parseInt(br.readLine());
        
        for(int loopCnt = 0; loopCnt < loop; loopCnt++) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
           
            //정점 수, 간선 수 입력
            int vNum = Integer.parseInt(st.nextToken());
            int eNum = Integer.parseInt(st.nextToken());
            
            //그래프 초기화
            graph = new LinkedList[vNum+1];
            for(int i = 1; i <= vNum; i++) {
                graph[i] = new LinkedList<Integer>();
            }
            
            // 정점 방문 여부 체크하는 배열 초기화
            check = new boolean[vNum+1];
            
            int divCnt = 0; //몇 분할인지 카운트 
            
            //방문 안해본 모든 정점을 시작으로 dfs시도 
            //dfs시도 횟수가 곧 분할 갯수
            // 따라서 2분할은 딱 두번만 dfs를 시도해야한다.
            for(int i = 1 ; i <= vNum; i++) {
                if(!check[i]) {
                    divCnt++; //dfs 시도할 때마다 분할카운트를 1 더해준다.
                    if(divCnt >= 3) // 세개이면 더 검사할 것 없이 break
                        break;
                    
                    dfs(i);
                }
            }
            
           if(divCnt == 2) {
               System.out.println("YES");
           }
           else {
               System.out.println("NO");
           }
            
        }
       
    }
    static void dfs(int cur) {
        check[cur] = true;
        
        for(int next : graph[cur]) {
            if(!check[next]) {
                dfs(next);
            }
        }
    }
}