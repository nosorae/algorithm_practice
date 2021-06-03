package simulation;






import java.util.*;
/*
 * 백준 14890 경사로 
 * 구현문제는 조건분석이 중요하니 
 * 경사로 조건에 해당하는 번호를 매기고 해당 조건에 해당하는 코드부분에 번호주석을 달겠다.
 * 1. 경사로는 낮은 곳에 놓고,
 * 2. 경사로 놓는 곳은평평해야함, 
 * 3. 이미 놓은 곳에 더 놓거나 겹쳐서도 안됨, 
 * 4. 그리고 경사로가 배열을 벗어나도 안됨 
 * 
 * 기능을 분할하면 좋은 점은 많은 조건 속에서 어느 부분을 고치러 갈지 알기 쉽기때문이다.
 * 맨 아래 정답소스 보면  2번 검사 하는데 양옆을 비교하는 게 아니라 맨 처음과 비교하며 for문 안에 경사로 놓였는지 여부를 체크하기 때문에  나처럼 1에대한 예외처리를 할 필요가 없다.
 * 
 */

public class BOJ_14890_Hard {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int len = sc.nextInt();
		int[][] arr = new int[n][n];
		int[] road;
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//가로
		for(int row = 0; row < n; row++) {
			road = arr[row];
			if(isRoad(road, len)) {
				ans++;
				//System.out.print(row+"행  ");
			}
				
		}
		
		//세로
		for(int col = 0; col < n; col++) {
			road = new int[n];
			for(int row = 0; row < n; row++) {
				road[row] = arr[row][col];
			}
			if(isRoad(road, len)) {
				ans++;
				//System.out.print(col+"열  ");
			}
				
		}
		
		System.out.println(ans);
		
    }
	static boolean isRoad(int[] arr, int len) {
		
		boolean[] isSteep = new boolean[arr.length];
		
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1]) { //1 경사로는 낮은 곳에 놓는다.
				
				
				if(arr[i] - arr[i+1] > 1) // 높이차는 1차이
					return false;
				if(i + len > arr.length-1) //4 경사로는 
					return false;
				
				//여기 왔다는 것은 배열 밖으로 벗어나지 않는다는 말
				for(int j = 1; j < len; j++) { //2, 3 즉 평평검사와 중복검사 / 1인경우 이곳을 들어가지 못한다.
					if(arr[i+j] != arr[i+j+1] || isSteep[i+j] || isSteep[i+j+1])
						return false;
				}
				if(len == 1 && isSteep[i+1])
					return false;
				//여기 왔다는 것은 경사로를 놓을 수 있다는 말
				for(int j = 1; j <= len; j++) { //3 중복검사를 위해 체크
					isSteep[i+j] = true;
				}
				
			}
			else if(arr[i] < arr[i+1]) { //1 
				
				if(arr[i+1] - arr[i] > 1)
					return false;
				if(i-(len-1) < 0) //4  왼쪽에 경사로 놓을 때는 현재 인덱스 포함해서 놓기때문에 len-1
					return false;
				
				for(int j = 0; j < len-1; j++) { // 1인 경우 이곳을 들어가지 않아서 경사로가 놓였는지 검사를 못한다. 
					if(arr[i-j] != arr[i-j-1] || isSteep[i-j] || isSteep[i-j-1])
						return false;
				}
				if(len == 1 && isSteep[i])
					return false;
				
				for(int j = 0; j < len; j++) 
					isSteep[i-j] = true;
			}
		}
		
		
		
		return true;
	}
}

/*
 * 1차원 배열 각각 독립적으로 생각해줘야한다는 사실을 깨닫지 못하다가 삽질함
 * 틀린경우를 다 제거하고 아니면 정답이다라는 플로우
 * 왼쪽에 경사로 놓을 때는 현재 인덱스 포함해서 놓기때문에 len-1
 */
//import java.util.*;
//
///*
// * 백준 14890번 경사로
// * 오답나왔을 때의 코드 하나의 함수에서 하려니 로직이 복잡해보인다.
// */
//
//public class BOJ_14890_Unsolved {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		final int n = sc.nextInt();
//		final int l = sc.nextInt();
//		int[][] arr = new int[n][n];
//		boolean[][] steep = new boolean[n][n];
//		int ans = 0;
//
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
//
//		//가로
//		for(int i = 0; i < n; i++) {
//			boolean[][] save = new boolean[n][n]; // 매 줄 마다 임시로 경사로를 체크 길이 된다면 steep배열로 이동
//			for(int j = 0; j < n; j++) {
//
//				if(j == n-1) {// 끝까지 왔다면 그것은 길 따라서 정답과 경사로 체크 갱신
//					for(int x = 0; x < n; x++) {
//						if(save[i][x])
//							steep[i][x] = true;
//					}
//					ans++;
////					System.out.println(i+1+"행");
//					break;
//				}
//
//
//				int prev = arr[i][j];
//				int next = arr[i][j+1];
//
//				if(prev == next) {
//					continue;
//				}
//
//				else if(prev > next && prev-next == 1) { // 다음 길이 낮은 길이라면 L만큼 연속되어있는지 체크
//
//					if(j > n-1-l)
//						break;
//
//					if(l== 1 && !save[i][j+1] && !steep[i][j+1]) {
//						save[i][j+1] = true;
//						continue;
//					}
//					else { // 이미 경사로가 있다면 탈락시켜야한다.
//						if(l==1)
//							break;
//					}
//
//
//
//					boolean isSteep = true;
//					for(int k = j+1; k <= j+l-1; k++) {
//						if(arr[i][k] != arr[i][k+1] || steep[i][k] || steep[i][k+1]
//								|| save[i][k] || save[i][k]) {
//							isSteep = false;
//							break;
//						}
//						save[i][k] = true;
//					}
//					save[i][j+l] = true;
//					if(!isSteep) 
//						break;
//
//
//				}
//				else if (prev < next && next-prev == 1) { // 다음 길이 더 높은 길이라면 이전 길이 L만큼 연속되어있는지 체크
//
//					if(j < l-1) 
//						break;
//
//					if(l == 1 && !save[i][j] && !steep[i][j]) {
//						save[i][j] = true;
//						continue;
//					} 
//					else {
//						if(l==1)
//							break;
//					}
//
//
//					boolean isSteep = true;
//					for(int k = j; k > j-l+1; k--) {
//						if(arr[i][k] != arr[i][k-1] || steep[i][k] || steep[i][k-1]
//								|| save[i][k] || save[i][k-1]) {
//							isSteep = false;
//							break;
//						}
//						save[i][k] = true;
//					}
//					save[i][j-l+1] = true;
//					if(!isSteep)
//						break;
//
//				}
//				else 
//					break;
//
//
//			}
//		}
//
//
//
//
//
//		steep = new boolean[n][n];
//		//세로
//		for(int i = 0; i < n; i++) {
//			boolean[][] save = new boolean[n][n];
//			for(int j = 0; j < n; j++) {
//
//
//				if(j == n-1) { // 끝까지 왔다면 정답과 경사로 갱신
//					for(int x = 0; x < n; x++) {
//						if(save[x][i])
//							steep[x][i] = true;
//					}
//					ans++;
////					System.out.println(i+1+"열");
//					break;
//				}
//
//
//
//				int prev = arr[j][i];
//				int next = arr[j+1][i];
//				if(prev == next) {
//					continue;
//				}
//				else if(prev > next && prev-next == 1) { // 다음 길이 낮은 길이라면 L만큼 연속되어있는지 체크
//
//					if(j > n-1-l)
//						break;
//
//					if(l == 1 && !save[j+1][i] && !steep[j+1][i]) {
//						save[j+1][i] = true;
//						continue;
//					} 
//					else {
//						if(l == 1)
//							break;
//					}
//
//					boolean isSteep = true;
//					for(int k = j+1; k <= j+l-1; k++) {
//						if(arr[k][i] != arr[k+1][i] || steep[k][i] || steep[k+1][i]
//								|| save[k][i] || save[k+1][i]) {
//							isSteep = false;
//							break;
//						}
//						save[k][i] = true;
//					}
//					save[j+l][i] = true;
//					if(!isSteep) 
//						break;
//
//				}
//				else if (prev < next && next-prev == 1) { // 다음 길이 더 높은 길이라면 이전 길이 L만큼 연속되어있는지 체크
//
//					if(j < l-1) 						
//						break;
//
//					if(l == 1 && !save[j][i] && !steep[j][i]) {
//						save[j][i] = true;
//						continue;
//					}
//					else {
//						if(l == 1)
//							break;
//					}
//
//					boolean isSteep = true;
//					for(int k = j; k > j-l+1; k--) {
//						if(arr[k][i] != arr[k-1][i] || steep[k][i] || steep[k-1][i]
//								|| save[k][i] || save[k-1][i]) {
//							isSteep = false;
//							break;
//						}
//						save[k][i] = true;
//					}
//					save[j-l+1][i] = true;
//					if(!isSteep)
//						break;
//
//				}
//
//
//			}
//		}
//		
//		
//
//
//		System.out.println(ans);
//
//	}
//
//}

/*
 * 이번 문제 경사가 겹치면 안된다는 조건을 무시하고 풀었다가 삽질을 오래했다.
 * 경사로를 놓는 게 확정이 된 후에 true false를 바꿔줘야하는데, 확정 전에 바꿔줘서 바꿔준다음에 경사로가 확정되지 않으면 다른 경사로를 못 놓는 문제를 야기했다.
 * 마지막 else로 같거나 크고 1차이 작고 1차이가 아니라면 break쳐주는 걸 깜빡해서 삽질했다. 
 * 문제조건이 많다면 정리해서 하나하나 지워라 체크리스트의 교훈!!!
 * 
 */


//import java.util.*;
//public class Main {
//    static boolean go(int[] a, int l) {
//        // 한 줄 검사
//        int n = a.length;
//        boolean[] c = new boolean[n];
//        for (int i=1; i<n; i++) {
//            if (a[i-1] != a[i]) {
//                // 인접한 칸의 높이가 다르면, 경사로를 놓아야 한다.
//                int diff = a[i]-a[i-1];
//                if (diff < 0) diff = -diff;
//                if (diff != 1) {
//                    // 낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
//                    return false;
//                }
//                if (a[i-1] < a[i]) {
//                    for (int j=1; j<=l; j++) {
//                        if (i-j < 0) {
//                            // 경사로를 놓다가 범위를 벗어나는 경우
//                            return false;
//                        }
//                        if (a[i-1] != a[i-j]) {
//                            // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
//
//                            return false;
//                        }
//                        if (c[i-j]) {
//                            // 경사로를 놓은 곳에 또 경사로를 놓는 경우
//                            return false;
//                        }
//                        c[i-j] = true;
//                    }
//                } else {
//                    // a[i-1] > a[i]
//                    for (int j=0; j<l; j++) {
//                        if (i+j >= n) {
//                            // 경사로를 놓다가 범위를 벗어나는 경우
//                            return false;
//                        }
//                        if (a[i] != a[i+j]) {
//                            // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
//
//                            return false;
//                        }
//                        if (c[i+j]) {
//                            // 경사로를 놓은 곳에 또 경사로를 놓는 경우
//                            return false;
//                        }
//                        c[i+j] = true;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int l = sc.nextInt();
//        int[][] a = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            // 행 검사
//            int[] d = new int[n];
//            for (int j=0; j<n; j++) {
//                d[j] = a[i][j];
//            }
//            if (go(d, l)) ans += 1;
//        }
//        for (int j=0; j<n; j++) {
//            // 열 검사
//            int[] d = new int[n];
//            for (int i=0; i<n; i++) {
//                d[i] = a[i][j];
//            }
//            if (go(d, l)) ans += 1;
//        }
//        System.out.println(ans);
//    }
//}










