package simulation;

import java.util.*;



/*
 * 백준 15685번 드래곤 커브
 * 시계방향 회전해서 끝점에 붙이는 것을 반복해서 나오는 그림을 시작점에서 방향의 배열만으로 표현할 수 있다!! 
 * 세대를 거듭할 때마다 각 요소에 영향주는 이전 요소를 찾다보니 규칙성을 발견!
 */

public class BOJ_15685 {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int n = sc.nextInt();
		boolean[][] arr = new boolean[101][101]; //점이 찍혔는지 안찍혔는지만 보면된다.
		for(int i = 0; i < n; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			curve(arr, x, y, d, g); // 점을 찍어준다.
		}
		for(int j = 0; j < 100; j++) {
			for(int k = 0; k < 100; k++) {
				if(arr[j][k] && arr[j][k+1] && arr[j+1][k] && arr[j+1][k+1])
					ans++;
			}
		}
		
//		for(int i = 0; i < 30; i++) {
//			for(int j = 0; j < 30; j++) {
//				if(arr[i][j])
//					System.out.print("1 ");
//				else 
//					System.out.print("0 ");
//			}
//			System.out.println();
//		}
		
		System.out.println(ans);

    }
	
	static void curve(boolean[][] arr, int x, int y, int d, int g) {
		//0 동 // 1 북 // 2 서 // 3 남 
		int[] dy = { 0, -1, 0, 1 }; //행
		int[] dx = { 1, 0, -1, 0 }; //열 
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(d); //이게 0세대 
		for(int i = 0; i < g; i++) { // 0세대부터 g세대까지 
			//기존 리스트를 뒤집고 각각 반시계방향으로 회전시킨 방향을 기존 리스트 뒤에 추가
			Stack<Integer> stack =  new Stack<Integer>();
			
			for(int direction : list)
				stack.push(direction); //순서가 자동으로 reverse됨 
			
			int size = stack.size();
			for(int j = 0; j < size; j++) {
				list.add((stack.peek()+1)%4); //반시계
				stack.pop();
			}
		}
		
		arr[y][x] = true;
		for(int i : list) {
//			System.out.print(x+"열  "+y+"행  --"+i+"--> ");
			y = y+dy[i];
			x = x+dx[i];
//			System.out.println(x+"열  "+y+"행");
			arr[y][x] = true;
		}
		
//		System.out.println("--------------------");
	}
	
}

/*
 * 0세대 처리해놓고 반복문에서 또 처리하니까 g+1세대까지 계산하는 문제가 발생 -> 꼭지점 프린트(주석)해서 해결 인지 및 해결
 * 좌표가 나오는 문제에서 좌표의 개념을 잘 파악해야한다. 배열의 좌표를 주는지 수학에서의 x, y좌표를 주는지 
 * 저 두개 이름에 속지말고 잘 파악해서 문제에 적용하자
 * 
 * ArrayList<Integer> temp = new ArrayList<>(ans); 이렇게 기존의 리스트로 새로운 리스트 객체 하나 더 만들 수 있다.
 *  ans.addAll(temp); 로 한번에 더할 수 있다.
 * 
 */


//import java.util.*;
//public class Main {
//    static boolean[][] c = new boolean[101][101];
//    static int[] dx = {0,-1,0,1};
//    static int[] dy = {1,0,-1,0};
//    static ArrayList<Integer> curve(int x, int y, int dir, int gen) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        ans.add(dir);
//        for (int g=1; g<=gen; g++) {
//            ArrayList<Integer> temp = new ArrayList<>(ans);
//            Collections.reverse(temp);
//            for (int i=0; i<temp.size(); i++) {
//                temp.set(i, (temp.get(i)+1)%4);
//            }
//            ans.addAll(temp);
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-- > 0) {
//            int y = sc.nextInt();
//            int x = sc.nextInt();
//            int dir = sc.nextInt();
//            int gen = sc.nextInt();
//            ArrayList<Integer> dirs = curve(x,y,dir,gen);
//            c[x][y] = true;
//            for (int d : dirs) {
//                x += dx[d];
//                y += dy[d];
//                c[x][y] = true;
//            }
//        }
//        int ans = 0;
//        for (int i=0; i<=99; i++) {
//            for (int j=0; j<=99; j++) {
//                if (c[i][j] && c[i][j+1] && c[i+1][j] && c[i+1][j+1]) {
//                    ans += 1;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}




