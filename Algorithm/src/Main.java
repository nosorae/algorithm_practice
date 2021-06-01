
import java.util.*;
/*
 * 백준 20327번 배열돌리기6
 */

public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		n = 1 << n;

		int[][] arr = new int[n][n]; 

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < r; i++) {
			int k = sc.nextInt();
			int l = sc.nextInt();
			
			switch(k) {
			case 1: 
				operation1(arr, 1<<l);
				break;
			case 2:
				operation2(arr, 1<<l);
				break;
			case 3:
				arr = operation3(arr, 1<<l);
				break;
			case 4:
				arr = operation4(arr, 1<<l);
				break;
			case 5:
				operation5(arr, 1<<l);
				break;
			case 6:
				operation6(arr, 1<<l);
				break;
			case 7:
				arr = operation7(arr, 1<<l);
				break;
			case 8:
				arr =operation8(arr, 1<<l);
			}
			
			
			
		}
		
		printMatrix(arr);
		
		



	}
	static void printMatrix(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void swap(int[][] arr, int x, int y, int nx, int ny) {
		int temp = arr[x][y];
		arr[x][y] = arr[nx][ny];
		arr[nx][ny] = temp;
	}
	
	static void operation1(int[][] arr, int size) {
		for(int i = 0; i < arr.length; i+=size) {
			for(int j = 0; j < arr[i].length; j+=size) {
				reverse_vertical(arr, i, j, size);
			}
		}
	}
	static void reverse_vertical(int[][] arr, int x, int y, int size) {
		int row = x+size;
		int col = y+size;
		for(int i = x; i < x + size/2; i++) {
			for(int j = y; j < col; j++) {
				swap(arr, i, j, row-1-(i-x), j);
			}
		}
	}
	static void operation2(int[][] arr, int size) {
		for(int i = 0; i < arr.length; i+=size) {
			for(int j = 0; j < arr[i].length; j+=size) {
				reverse_horizontal(arr, i, j, size);
			}
		}

	}
	
	static void reverse_horizontal(int[][] arr, int x, int y, int size) {
		int row = x+size;
		int col = y+size;
		for(int i = x; i < row; i++) {
			for(int j = y; j < y+size/2; j++) {
				swap(arr, i, j, i, col-1-(j-y));
			}
		}
	}
	static int[][] operation3(int[][] arr, int size) {
		int[][] result = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i+=size) {
			for(int j = 0; j < arr[i].length; j+=size) {
				rotate_right(arr, result, i, j, size);
			}
		}
		return result;
	}
	static void rotate_right(int[][] arr, int[][] result, int x, int y, int size) {
		int row = x+size;
		int col = y+size;
		for(int i = x; i < row; i++) {
			for(int j = y; j < col; j++) {
				result[i][j] =  arr[row-1-(j-y)][y+(i-x)];
			}
		}
		
	}
	
	static int[][] operation4(int[][] arr, int size) {
		int[][] result = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i+=size) {
			for(int j = 0; j < arr[i].length; j+=size) {
				rotate_left(arr, result, i, j, size);
			}
		}
		return result;
	}
	static void rotate_left(int[][] arr, int[][] result, int x, int y, int size) {
		int row = x+size;
		int col = y+size;
		for(int i = x; i < row; i++) {
			for(int j = y; j < col; j++) {
				result[i][j] =  arr[x+(j-y)][col-1-(i-x)];
			}
		}
	}
	
	static void swapSubArray(int[][] arr, int x, int y, int nx, int ny, int size) {
		for(int i = x; i < x+size; i++){
			for(int j = y; j < y+size; j++) {
				swap(arr, i, j, nx+(i-x), ny+(j-y));
			}
		}
	}
	static void copySubArray(int[][] arr, int[][] result, int x, int y, int nx, int ny, int size) {
		for(int i = nx; i < nx+size; i++) {
			for(int j = ny; j < ny+size; j++) {
				result[i][j] = arr[x+(i-nx)][y+(j-ny)];
			}
		}
	}
	
	static void operation5(int[][] arr, int size) {
		for(int i = 0; i < arr.length/2; i+=size) {
			for(int j = 0; j < arr[i].length; j+=size) {
				swapSubArray(arr, i, j, arr.length - i - size, j, size);
			}
		}

	}
	static void operation6(int[][] arr, int size) {
		for(int i = 0; i < arr.length; i+=size) {
			for(int j = 0; j < arr[i].length/2; j+= size) {
				swapSubArray(arr, i, j, i, arr[i].length - j - size, size);
			}
		}

	}
	static int[][] operation7(int[][] arr, int size) {
		int[][] result = new int[arr.length][arr[0].length];
		for(int i = 0; i < result.length; i+=size) {
			for(int j = 0; j < result[i].length; j+= size) {
				copySubArray(arr, result, arr.length-size-j, i, i, j, size);
			}
		}
		return result;

	}
	static int[][] operation8(int[][] arr, int size) {
		
		int[][] result = new int[arr.length][arr[0].length];
		
		for(int i = 0; i < result.length; i+=size) {
			for(int j = 0; j < result[i].length; j+= size) {
				copySubArray(arr, result, j, arr[0].length-size-i, i, j, size);
			}
		}
		return result;

	}


}




