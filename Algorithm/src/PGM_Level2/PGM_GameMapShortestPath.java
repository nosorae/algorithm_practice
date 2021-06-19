package PGM_Level2;

/*
* 2021.06.19
* PGM 게임 맵 최단거리 https://programmers.co.kr/learn/courses/30/lessons/1844
* 평범한 bfs 최단거리 문제지만 벽이 1이 아닌 0으로 주어진다는 게 함정..
*/


import java.util.*;

class PGM_GameMapShortestPath {
  //동서남북
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0}; 
  public int solution(int[][] maps) {
      int row = maps.length;
      int col = maps[0].length;
      
      Queue<Integer> qX = new LinkedList<Integer>();
      Queue<Integer> qY = new LinkedList<Integer>();
      int[][] dist = new int[row][col];
      
      qX.add(0);
      qY.add(0);
      dist[0][0] = 1;
      
      while(!qX.isEmpty()) {
          int curX = qX.poll();
          int curY = qY.poll();
          
          for(int i = 0; i < 4; i++) {
              int nextX = curX + dx[i];
              int nextY = curY + dy[i];
              if(checkBoarder(row, col, nextX, nextY) 
                  && maps[nextX][nextY] == 1 
                  && dist[nextX][nextY] == 0) {
                  
                  qX.add(nextX);
                  qY.add(nextY);
                  dist[nextX][nextY] = dist[curX][curY]+1;
                  
                  //찾으면 바로 끝내는 코드
                  if(nextX == row-1 && nextY == col - 1)
                      return dist[nextX][nextY];
              }
          }
          
      }
      
      //여기까지 왔다는 것은 상대진영을 못찾았다는 말
      return -1;
  }
  static boolean checkBoarder(int row, int col, int nextX, int nextY) {
      if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col)
          return true;
      else
          return false;
  }
}