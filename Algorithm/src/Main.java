


import java.util.*;
/*
 * 백준 16235 나무 재테크
 * 인덱스 1부터 시작
 * 초기 양분 5 크기 N
 * 1. 어린부터 나이만큼 양분 감소 -> 나이1증가 // 못먹으면 죽음
 * 2. 죽은나무나이/2 만큰 양분 증가 
 * 3. 나이5배수나무 인접한 8개칸에 나이1나무 생성 (경계처리)
 * 4. 입력만큼 양분 증가
 * k년이 지나고 살아있는 나무 갯수가 ans
 * 
 */

public class Main {

	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;



		PriorityQueue<Integer>[][] tree = new PriorityQueue[n+1][n+1];

		int[][] ground = new int[n+1][n+1];
		int[][] nourish = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				tree[i][j] = new PriorityQueue<Integer>();
				ground[i][j] = 5;
				nourish[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			tree[x][y].add(age);
			ans++; // 나무 추가 밑 감소엔 빠지지 않고 등장할 예정
		}

		/*
		 * 1. 어린나무부터 나이만큼 양분 감소 -> 나이1증가 // 못먹으면 죽음
		 * 2. 죽은나무나이/2 만큰 양분 증가 
		 * 1, 2번 묶어서 처리하고 3, 4번 묶어서 처리
		 * 3. 나이5배수나무 인접한 8개칸에 나이1나무 생성 (경계처리)
		 * 4. 입력만큼 양분 증가
		 * k년이 지나고 살아있는 나무 갯수가 ans
		 */

		for(int years = 1; years <= k; years++) {
			
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					PriorityQueue<Integer> temp = new PriorityQueue<Integer>();
					while(!tree[i][j].isEmpty()) {
						
						
						if(ground[i][j] - tree[i][j].peek() < 0) {

							while(!tree[i][j].isEmpty()) {
								
								//죽으면 다 빼서 나이/2 만큼 양분 증가
								ground[i][j] += (tree[i][j].poll()/2);
								ans--;
							}
							break;
						}
						else {
							ground[i][j] -= tree[i][j].peek();
							temp.add(tree[i][j].poll()+1);
						}
					}

					tree[i][j] = temp;
				}
			}

			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					PriorityQueue<Integer> temp = new PriorityQueue<Integer>();
					
					while(!tree[i][j].isEmpty()) {
						
						if(tree[i][j].peek()%5 == 0) { //나이가 5배수면
							for(int next = 0; next < 8; next++) { // 인접한 8방향에
								int nx = i+dx[next];
								int ny = j+dy[next];
								
								if(isIn(n, nx, ny)) {//경계처리해서 
									tree[nx][ny].add(1); // 나이 1인 나무를 심허준다.
									ans++;
								}	
							}
						}
						
						int t = tree[i][j].poll();
						temp.add(t);
					}
					
					tree[i][j] = temp;
					
					
					ground[i][j] += nourish[i][j];  //입력만큼 양분 증가
				}
			}
		} //k for루프 끝
		
		System.out.println(ans);



	}


	static boolean isIn(int n, int nx, int ny) {
		if(nx >=1 && nx <= n && ny >=1 && ny <= n) 
			return true;
		else
			return false;
	}
}

















