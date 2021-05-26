package simulation;


import java.util.*;

/*
 * 백준 14890번 경사로
 * 미제사건
 */

public class BOJ_14890_Unsolved {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		final int l = sc.nextInt();
		int[][] arr = new int[n][n];
		boolean[][] steep = new boolean[n][n];
		int ans = 0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		//가로
		for(int i = 0; i < n; i++) {
			boolean[][] save = new boolean[n][n]; // 매 줄 마다 임시로 경사로를 체크 길이 된다면 steep배열로 이동
			for(int j = 0; j < n; j++) {

				if(j == n-1) {// 끝까지 왔다면 그것은 길 따라서 정답과 경사로 체크 갱신
					for(int x = 0; x < n; x++) {
						if(save[i][x])
							steep[i][x] = true;
					}
					ans++;
//					System.out.println(i+1+"행");
					break;
				}


				int prev = arr[i][j];
				int next = arr[i][j+1];

				if(prev == next) {
					continue;
				}

				else if(prev > next && prev-next == 1) { // 다음 길이 낮은 길이라면 L만큼 연속되어있는지 체크

					if(j > n-1-l)
						break;

					if(l== 1 && !save[i][j+1] && !steep[i][j+1]) {
						save[i][j+1] = true;
						continue;
					}
					else { // 이미 경사로가 있다면 탈락시켜야한다.
						if(l==1)
							break;
					}



					boolean isSteep = true;
					for(int k = j+1; k <= j+l-1; k++) {
						if(arr[i][k] != arr[i][k+1] || steep[i][k] || steep[i][k+1]
								|| save[i][k] || save[i][k]) {
							isSteep = false;
							break;
						}
						save[i][k] = true;
					}
					save[i][j+l] = true;
					if(!isSteep) 
						break;


				}
				else if (prev < next && next-prev == 1) { // 다음 길이 더 높은 길이라면 이전 길이 L만큼 연속되어있는지 체크

					if(j < l-1) 
						break;

					if(l == 1 && !save[i][j] && !steep[i][j]) {
						save[i][j] = true;
						continue;
					} 
					else {
						if(l==1)
							break;
					}


					boolean isSteep = true;
					for(int k = j; k > j-l+1; k--) {
						if(arr[i][k] != arr[i][k-1] || steep[i][k] || steep[i][k-1]
								|| save[i][k] || save[i][k-1]) {
							isSteep = false;
							break;
						}
						save[i][k] = true;
					}
					save[i][j-l+1] = true;
					if(!isSteep)
						break;

				}
				else 
					break;


			}
		}





		steep = new boolean[n][n];
		//세로
		for(int i = 0; i < n; i++) {
			boolean[][] save = new boolean[n][n];
			for(int j = 0; j < n; j++) {


				if(j == n-1) { // 끝까지 왔다면 정답과 경사로 갱신
					for(int x = 0; x < n; x++) {
						if(save[x][i])
							steep[x][i] = true;
					}
					ans++;
//					System.out.println(i+1+"열");
					break;
				}



				int prev = arr[j][i];
				int next = arr[j+1][i];
				if(prev == next) {
					continue;
				}
				else if(prev > next && prev-next == 1) { // 다음 길이 낮은 길이라면 L만큼 연속되어있는지 체크

					if(j > n-1-l)
						break;

					if(l == 1 && !save[j+1][i] && !steep[j+1][i]) {
						save[j+1][i] = true;
						continue;
					} 
					else {
						if(l == 1)
							break;
					}

					boolean isSteep = true;
					for(int k = j+1; k <= j+l-1; k++) {
						if(arr[k][i] != arr[k+1][i] || steep[k][i] || steep[k+1][i]
								|| save[k][i] || save[k+1][i]) {
							isSteep = false;
							break;
						}
						save[k][i] = true;
					}
					save[j+l][i] = true;
					if(!isSteep) 
						break;

				}
				else if (prev < next && next-prev == 1) { // 다음 길이 더 높은 길이라면 이전 길이 L만큼 연속되어있는지 체크

					if(j < l-1) 						
						break;

					if(l == 1 && !save[j][i] && !steep[j][i]) {
						save[j][i] = true;
						continue;
					}
					else {
						if(l == 1)
							break;
					}

					boolean isSteep = true;
					for(int k = j; k > j-l+1; k--) {
						if(arr[k][i] != arr[k-1][i] || steep[k][i] || steep[k-1][i]
								|| save[k][i] || save[k-1][i]) {
							isSteep = false;
							break;
						}
						save[k][i] = true;
					}
					save[j-l+1][i] = true;
					if(!isSteep)
						break;

				}


			}
		}
		
		

//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j <n ;j++) {
//				System.out.print(steep[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(ans);

	}

}

/*
 * 이번 문제 경사가 겹치면 안된다는 조건을 무시하고 풀었다가 삽질을 오래했다.
 * 경사로를 놓는 게 확정이 된 후에 true false를 바꿔줘야하는데, 확정 전에 바꿔줘서 바꿔준다음에 경사로가 확정되지 않으면 다른 경사로를 못 놓는 문제를 야기했다.
 * 마지막 else로 같거나 크고 1차이 작고 1차이가 아니라면 break쳐주는 걸 깜빡해서 삽질했다. 
 * 문제조건이 많다면 정리해서 하나하나 지워라 체크리스트의 교훈!!!
 * 
 */









