package simulation;

//알고리즘 문제들을  풀면서 두 번 이상 만난 함수는 여기에 저장
public class ArrayFunctions {
	// 사전순으로 이전 순열을 구한다.
	static boolean prev_permutation(int[] perm) {
		int len = perm.length;
		int idx = len - 1;
		// 내림차순을 만나면 바로 멈춘다. ~로 시작하는 첫순열이라는 말에서 ~의 바로 뒤의 인덱스를 찾아주는 작업
		while(idx > 0 && perm[idx-1] <= perm[idx])
			idx--;
		if(idx == 0)
			return false;
		
		// lastIdx원소 바로 이전 원소를 lastIdx원소와 바꿔준다.
		int lastIdx = idx - 1;
		idx = len - 1;
		while(perm[lastIdx] <= perm[idx])
			idx--;
		
		swap(perm, lastIdx, idx);
		reverse(perm, lastIdx+1, len-1);
		
		return true;
	}
	
	// 사전순으로 다음 순열을 구한다.
	static boolean next_permutation(int[] prev) {
		//뒤에서부터 내림차순일 때까지 하나씩 줄여본다.
		int idx = prev.length - 1;
		while(idx > 0 && prev[idx - 1] >= prev[idx]) 
			idx--;
		
		//모든 수가 내림차순이라면 마지막 순열이다.
		if(idx == 0)
			return false;
		// lastIdx까지가 왼쪽에서 오름차순 이 이후로는 내림차순이다. 즉 0~lastIdx 이후로는 마지막 순열
		int lastIdx = idx - 1;
		// lastIdx이후로는 내림차순이기 때문에 끝에서 부터 하나씩 내리다가 lastIdx원소보다 큰 원소 찾으면 
		// lastIdx에 올 다음 원소를 찾을 수 있다.
		idx = prev.length - 1;
		while(prev[lastIdx] >= prev[idx]) idx--;
		
		// lastIdx원소와 lastIdx에 올 다음 원소를 바꿔준다.
		swap(prev, lastIdx, idx);
		// 그 결과는 새로운 lastIdx원소로 시작하는 마지막 순열이다.
		// 이를 새로운 lastIdx원소로 시작하는 첫 순열로 바꿔줘야한다.
		reverse(prev, lastIdx + 1, prev.length - 1);
		
		return true;
	}
	static void swap(int[] prev, int a, int b) {
		int temp = prev[a];
		prev[a] = prev[b];
		prev[b] = temp;
	}
	// 일차원 배열에서 left~right 원소들을 뒤집는다.
	static void reverse(int[] prev, int left, int right) {
		while(left < right) {
			swap(prev, left, right);
			left++;
			right--;
		}
	}

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
