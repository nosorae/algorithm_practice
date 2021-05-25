
import java.util.*;

/*
 * 백준 16926번 배열돌리기1,16927번 배열돌리기2 
 * 어려운 문제를 쉬운 문제로 변형해서 풀이하는 아이디어 
 * 즉 2차원배열의 테두리별 이동문제를 1차원배열의 원형 이동문제로 전환해서 해결
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		int[][] arr = new int[n][m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		border(arr, r);

		printArray2(arr);

	}

	static void border(int[][] arr, int r) {
		int n = arr.length;
		int m = arr[0].length;
		int groupNum = min(n, m)/2;

		//초기화
		LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < groupNum; i++) {
			list.add(new LinkedList<Integer>());
		}

		//1차원 배열화
		for(int k = 0; k < groupNum; k++) {
			for(int i = k; i < m-1-k; i++) {
				list.get(k).add(arr[k][i]);
			}
			for(int i = k; i < n-1-k; i++) {
				list.get(k).add(arr[i][m-1-k]);
			}
			for(int i = m-1-k; i > k; i--) {
				list.get(k).add(arr[n-1-k][i]);
			}
			for(int i = n-1-k; i > k; i--) {
				list.get(k).add(arr[i][k]);
			}
		}

		//이동 값을 생각하면서, 다시 2차원 배열화

		for(int k = 0; k < groupNum; k++) {
			int idx = r%list.get(k).size();
			//이 idx가 새로운 시작점이고, 0~시작점직전 까지의 숫자들을 차례대로 빼서 뒤로 넣어준다.
			for(int i = 0; i < idx; i++) {
				list.get(k).add(list.get(k).remove(0));
			}



			for(int i = k; i < m-1-k; i++) {
				arr[k][i] = list.get(k).remove(0);
			}
			for(int i = k; i < n-1-k; i++) {
				arr[i][m-1-k] = list.get(k).remove(0);

			}
			for(int i = m-1-k; i > k; i--) {
				arr[n-1-k][i] = list.get(k).remove(0);

			}
			for(int i = n-1-k; i > k; i--) {
				arr[i][k] = list.get(k).remove(0);
			}
		}

	}





	static int min(int a, int b) {
		return (a < b) ? a : b;
	}

	public static void printArray2(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}








