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

}
