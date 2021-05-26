
import java.util.*;

//dfs로도 풀어볼 것!!!

/*
 * 백준 15685번 드래곤 커브
 * 90도 회전을 시작점에서 방향의 배열만으로 표현할 수 있다!! 
 */

public class Main {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int n = sc.nextInt();
		boolean[][] arr = new boolean[100][100]; //점이 찍혔는지 안찍혔는지만 보면된다.
		for(int i = 0; i < n; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			curve(arr, x, y, d, g); // 점을 찍어준다.
		}
		for(int j = 0; j < 98; j++) {
			for(int k = 0; k < 98; k++) {
				if(arr[j][k] && arr[j][k+1] && arr[j+1][k] && arr[j+1][k+1])
					ans++;
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j])
					System.out.print("1 ");
				else 
					System.out.print("0 ");
			}
			System.out.println();
		}
		
		System.out.println(ans);

    }
	
	static void curve(boolean[][] arr, int x, int y, int d, int g) {
		
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(d);
		for(int i = 0; i <= g; i++) {
			//기존 리스트를 뒤집고 각각 반시계방향으로 회전시킨 방향을 기존 리스트 뒤에 추가
			Stack<Integer> stack =  new Stack<Integer>();
			for(int direction : list)
				stack.push(direction);
			int size = stack.size();
			for(int j = 0; j < size; j++)
				list.add((stack.pop()+1)%4);
		}
		
		arr[x][y] = true;
		for(int i : list) {
			x = x+dx[i];
			y = y+dy[i];
			arr[x][y] = true;
		}
	}
	
}




