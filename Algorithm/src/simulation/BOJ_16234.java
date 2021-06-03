package simulation;

import java.util.*;
/*
 * 백준 16234 인구이동
 * 내 방법이 시간제한에 괜찮은걸까??
 * 
 */

public class BOJ_16234 {

	static int[] dx = { 0, 0, 1, -1 }; // 동서남북
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] open;
	static int[][] arr;
	static int[] alianceSum;
	static int[] alianceCnt;
	static int min;
	static int max;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		min = sc.nextInt();
		max = sc.nextInt();
		arr = new int[n][n];
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int ans = 0;
		while(true) {
			
			
			if(!isExistOpen()) {
				System.out.println(ans);
				break;
			}
			else {
				ans++;
				
				int alianceNum = 0;
				open = new int[n][n]; 
				alianceSum = new int[n*n+1];
				alianceCnt = new int[n*n+1];
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						if(open[i][j] == 0) {
							alianceNum++;
							dfs(i, j, alianceNum);
							changePopul(i, j, alianceNum, alianceSum[alianceNum]/alianceCnt[alianceNum]);
						}
					}
				}
			}
		}
	}
	
	static void dfs(int x, int y, int alianceNum) {
		open[x][y] = alianceNum;
		alianceSum[alianceNum] += arr[x][y];
		alianceCnt[alianceNum]++;

		for(int i = 0;  i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(isIn(nx, ny) && open[nx][ny] == 0) {

				int diff = arr[x][y] - arr[nx][ny];
				if(diff < 0) 
					diff = -diff;

				if(diff >= min && diff <= max)
					dfs(nx, ny, alianceNum);

			}

		}
	}

	static void changePopul(int x, int y, int alianceNum, int newPopul) {
		arr[x][y] = newPopul;
		open[x][y] = -1;

		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(isIn(nx, ny) && open[nx][ny] == alianceNum)
				changePopul(nx, ny, alianceNum, newPopul);
		}
	}

	static boolean isExistOpen() {
		for(int x = 0; x < arr.length; x++) {
			for(int y = 0; y < arr.length; y++) {
				for(int i = 0; i < 4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(isIn(nx, ny)) {
						int diff = arr[x][y] - arr[nx][ny];
						if(diff < 0) 
							diff = -diff;
						if(diff >= min && diff <= max)
							return true;
					}
				}
			}
		}
		return false;
	}

	static boolean isIn(int nx, int ny) {
		if(nx >=0 && nx < arr.length && ny >=0 && ny < arr[0].length) 
			return true;
		else
			return false;
	}
}

















