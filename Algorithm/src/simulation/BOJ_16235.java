package simulation;

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
 * 가을을 따로 처리할 때는 시간초과가 나오고 봄여름가을겨울 한꺼번에 처리하니 통과되었다.
 * 가을을 따로 처리할 때  temp 우선순위큐를 만들어서 모든 원소를 옮겨담는 과정때문에 시간초과가 났던 것 같다.  
 * 정답소스에서는 정렬을 사용해서 어린 나이의 나무부터 양분을 먹이게 풀이하였다. 정렬이 N*logN 인 것과 우선순위 큐의 넣고 빼는 것이 logN인 것을 감안하면 
 * 시간차가 많이 날지 모르겠다 .
 */

public class BOJ_16235 {

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
		 * 3. 나이5배수나무 인접한 8개칸에 나이1나무 생성 (경계처리)
		 * 4. 입력만큼 양분 증가
		 * k년이 지나고 살아있는 나무 갯수가 ans
		 */

		for(int years = 1; years <= k; years++) {
			
			int[][] fall = new int[n+1][n+1];
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
							
							if((tree[i][j].peek()+1)%5 == 0) { //나이가 5배수면 ( 살아남은 나무 나이+1 하는 것 이전이기 때문에 +1해주었다.)
								for(int next = 0; next < 8; next++) { // 인접한 8방향에
									int nx = i+dx[next];
									int ny = j+dy[next];
									
									if(isIn(n, nx, ny)) {//경계처리해서 
										fall[nx][ny]++; // 나이 1인 나무를 심어준다.
										ans++;
									}	
								}
							}
							
							ground[i][j] -= tree[i][j].peek();
							temp.add(tree[i][j].poll()+1);
						}
						
					}
					
					tree[i][j] = temp;
					ground[i][j] += nourish[i][j];  //입력만큼 양분 증가
					
				}
			}

			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(fall[i][j] > 0) {
						for(int t = 0; t < fall[i][j]; t++) {
							tree[i][j].add(1);
						}
					}
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



/*
 * 아래 정답소스에서는 
 * ArrayList<Integer>[][] 이차원 배열로 각 칸의 ArrayList를 sort해서 작은 나이부터 양분을 먹였다.
 */


//import java.util.*;
//public class Main {
//    static final int[] dx = {-1,-1,-1,0,0,1,1,1};
//    static final int[] dy = {-1,0,1,-1,1,-1,0,1};
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int l = sc.nextInt();
//        int[][] a = new int[n][n];
//        int[][] d = new int[n][n];
//        ArrayList<Integer>[][] tree = new ArrayList[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                a[i][j] = sc.nextInt();
//                d[i][j] = 5; // 가장 처음에 양분은 모든 칸에 5만큼 들어있다.
//                tree[i][j] = new ArrayList<>();
//            }
//        }
//        while (m-- > 0) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            int age = sc.nextInt();
//            tree[x-1][y-1].add(age);
//        }
//        while (l-- > 0) {
//            int[][] p = new int[n][n];
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<n; j++) {
//                    ArrayList<Integer> temp = new ArrayList<>();
//                    Collections.sort(tree[i][j]);
//                    int dead = 0;
//                    for (int x : tree[i][j]) {
//                        if (x <= d[i][j]) {
//                            d[i][j] -= x; // 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
//                            temp.add(x+1);
//                            if ((x+1) % 5 == 0) { // 번식하는 나무는 나이가 5의 배수이어야 하며,
//                                for (int k=0; k<8; k++) {
//                                    int nx = i+dx[k];
//                                    int ny = j+dy[k];
//                                    if (0 <= nx && nx < n && 0 <= ny && ny < n) { // 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
//                                        p[nx][ny] += 1; // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
//                                    }
//                            }
//                            }
//                        } else { // 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
//                            dead += x/2; // 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
//                        }
//                    }
//                    tree[i][j] = temp;
//                    d[i][j] += dead;
//                    d[i][j] += a[i][j]; // 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
//                }
//            }
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<n; j++) {
//                    for (int k=0; k<p[i][j]; k++) {
//                        tree[i][j].add(1); // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
//                    }
//                }
//            }
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                ans += (int)tree[i][j].size();
//            }
//        }
//        System.out.println(ans);
//    }
//}















