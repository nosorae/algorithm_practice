package PGM_Level2;

/*
 * 2021.06.26
 * PGM 카카오프렌츠 컬러링북 
 * 연결요소찾기 문제인데, 각 연결요소의 정점개수도 찾아줘야하고, 
 * 연결조건이 조금 까다롭다. 상하좌우는 기본이고, 색이 같아야 연결된 것이다.
 * 나왔던 색이 또 나와도 된다.
 * solution함에서에 모든 정점을 check해서 방문x면 bfs시도하고, bfs함수로 개수를 리턴해서 
 * 정점최대 개수도 갱신하겠다.
 * m이 행의 수, n이 열의 수인 것에 주의
 * 27분
 */
import java.util.*;

class PGM_KakaoFriendsColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!check[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    int temp = bfs(picture, check, i, j);
                    if(maxSizeOfOneArea < temp)
                        maxSizeOfOneArea = temp;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static int bfs(int[][] picture, boolean[][] check, int startX, int startY) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0}; // 동서남북
        int cntV = 0; //정점 수 세는 변수
        // 큐에 넣고 방문 체크하고 정점 개수 세기
        Queue<Integer> qX = new LinkedList<Integer>();
        Queue<Integer> qY = new LinkedList<Integer>();
        qX.add(startX);
        qY.add(startY);
        check[startX][startY] = true;
        cntV++;
        
        while(!qX.isEmpty()) {
            int curX = qX.poll();
            int curY = qY.poll();
            for(int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];
                //범위 확인 && 방문여부 확인 && 색이 같은지 즉, 연결됐는지 확인 
                //picture가 0인지 확인할 필요가 없다. 
                //왜냐하면 solution에서 이미 0이 아닌 상태로 들어왔기 때문이다.
                if(isIn(picture.length, picture[0].length, nX, nY) 
                   && !check[nX][nY] && picture[curX][curY] == picture[nX][nY]) {
                    qX.add(nX);
                    qY.add(nY);
                    check[nX][nY] = true;
                    cntV++;
                }
            }
        }
        return cntV;
    }
    
    static boolean isIn(int n, int m, int x, int y) {
        if(x >= 0 && x < n && y >= 0 && y < m) 
            return true;
        else
            return false;
    }
}