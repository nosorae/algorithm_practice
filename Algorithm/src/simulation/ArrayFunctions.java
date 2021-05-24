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

}
