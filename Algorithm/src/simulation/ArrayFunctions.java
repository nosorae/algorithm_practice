package simulation;

//알고리즘 문제들을  풀면서 두 번 이상 만난 함수는 여기에 저장
public class ArrayFunctions {



	//2차원 배열을 출력
	public static void printArray2(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}


	//1차원 배열 왼쪽으로 한 칸 당기기
	static void push_left(int[] arr) {
		int temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp; 

	}
	//1차원 배열 오른쪽을 한 칸 밀기
	static void push_right(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}

	//칸끼리 바꾸기
	static void swap(int[][] arr, int x, int y, int nx, int ny) {
		int temp = arr[x][y];
		arr[x][y] = arr[nx][ny];
		arr[nx][ny] = temp;
	}

	//한 정사각형 부분배열을 한 칸이라고 생각하고 바꾸기
	static void swapSubArray(int[][] arr, int x, int y, int nx, int ny, int size) {
		for(int i = x; i < x+size; i++){
			for(int j = y; j < y+size; j++) {
				swap(arr, i, j, nx+(i-x), ny+(j-y));
			}
		}
	}

	//한 정사각형 부분배열을 한 칸이라고 생각하고 이동시키기
	static void copySubArray(int[][] arr, int[][] result, int x, int y, int nx, int ny, int size) {
		for(int i = nx; i < nx+size; i++) {
			for(int j = ny; j < ny+size; j++) {
				result[i][j] = arr[x+(i-nx)][y+(j-ny)];
			}
		}
	}


	//인덱스가 1부터 시작하는 1차원배열 한 칸 오른쪽 회전
	static void rotate_padding(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 1; i--) {
			arr[i] = arr[i-1];
		}
		arr[1] = temp;
	}
	
	//주어진 인덱스가 주어진 배열안에 있는지 경계검사하는 함수
	static boolean isIn(int[][] arr, int nx, int ny) {
		if(nx >=0 && nx < arr.length && ny >=0 && ny < arr[0].length) 
			return true;
		else
			return false;
	}

}
