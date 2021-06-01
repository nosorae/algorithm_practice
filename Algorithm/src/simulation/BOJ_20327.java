package simulation;



import java.util.*;
/*
 * 백준 20327번 배열돌리기6
 * 배열돌리기3과 같이 바뀐결과를 기준으로 놓고 이전의 인덱스를 찾아주면 쉽다.
 * 배열돌리기3과 다른점은 부분배열을 하나의 칸으로 생각하고 배열을 돌려주어야한다는 것이다.
 * 그래서 기준점과 사이즈로 부분배열을 하나의 칸으로 생각하고 배열을 돌려주었다.
 */

public class BOJ_20327 {


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
/*
 * 함수 위로 빼기? 정도 
 */

//import java.util.*;
//public class Main {
//    static int[][] operation1(int[][] a) {
//        int n = a.length;
//        int[][] ans = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                ans[i][j] = a[n-i-1][j];
//            }
//        }
//        return ans;
//    }
//    static int[][] operation5(int[][] a, int l) {
//        int n = a.length;
//        int[][] ans = new int[n][n];
//        int sub_size = (1 << l);
//        int sub_count = n / sub_size;
//        for (int i=0; i<sub_count; i++) {
//            for (int j=0; j<sub_count; j++) {
//                int x1 = i*sub_size;
//                int y1 = j*sub_size;
//                int x2 = (sub_count-i-1)*sub_size;
//                int y2 = j*sub_size;
//                for (int x=0; x<sub_size; x++) {
//                    for (int y=0; y<sub_size; y++) {
//                        ans[x1+x][y1+y] = a[x2+x][y2+y];
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//    static int[][] operation2(int[][] a) {
//        int n = a.length;
//        int[][] ans = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                ans[i][j] = a[i][n-j-1];
//            }
//        }
//        return ans;
//    }
//    static int[][] operation6(int[][] a, int l) {
//        int n = a.length;
//        int[][] ans = new int[n][n];
//        int sub_size = (1 << l);
//        int sub_count = n / sub_size;
//        for (int i=0; i<sub_count; i++) {
//            for (int j=0; j<sub_count; j++) {
//                int x1 = i*sub_size;
//                int y1 = j*sub_size;
//                int x2 = i*sub_size;
//                int y2 = (sub_count-j-1)*sub_size;
//                for (int x=0; x<sub_size; x++) {
//                    for (int y=0; y<sub_size; y++) {
//                        ans[x1+x][y1+y] = a[x2+x][y2+y];
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//    static int[][] operation3(int[][] a) {
//        int n = a.length;
//        int[][] ans = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                ans[i][j] = a[n-j-1][i];
//            }
//        }
//        return ans;
//    }
//    static int[][] operation7(int[][] a, int l) {
//        int n = a.length;
//        int[][] ans = new int[n][n];
//        int sub_size = (1 << l);
//        int sub_count = n / sub_size;
//        for (int i=0; i<sub_count; i++) {
//            for (int j=0; j<sub_count; j++) {
//                int x1 = i*sub_size;
//                int y1 = j*sub_size;
//                int x2 = (sub_count-j-1)*sub_size;
//                int y2 = i*sub_size;
//                for (int x=0; x<sub_size; x++) {
//                    for (int y=0; y<sub_size; y++) {
//                        ans[x1+x][y1+y] = a[x2+x][y2+y];
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//    static int[][] operation4(int[][] a) {
//        int n = a.length;
//        int[][] ans = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                ans[i][j] = a[j][n-i-1];
//            }
//        }
//        return ans;
//    }
//    static int[][] operation8(int[][] a, int l) {
//        int n = a.length;
//        int[][] ans = new int[n][n];
//        int sub_size = (1 << l);
//        int sub_count = n / sub_size;
//        for (int i=0; i<sub_count; i++) {
//            for (int j=0; j<sub_count; j++) {
//                int x1 = i*sub_size;
//                int y1 = j*sub_size;
//                int x2 = j*sub_size;
//                int y2 = (sub_count-i-1)*sub_size;
//                for (int x=0; x<sub_size; x++) {
//                    for (int y=0; y<sub_size; y++) {
//                        ans[x1+x][y1+y] = a[x2+x][y2+y];
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//    static void operation_1_to_4(int[][] a, int k, int sx, int sy, int len) {
//        int[][] b = new int[len][len];
//        for (int i=0; i<len; i++) {
//            for (int j=0; j<len; j++) {
//                b[i][j] = a[sx+i][sy+j];
//            }
//        }
//        if (k == 1) {
//            b = operation1(b);
//        } else if (k == 2) {
//            b = operation2(b);
//        } else if (k == 3) {
//            b = operation3(b);
//        } else if (k == 4) {
//            b = operation4(b);
//        }
//        for (int i=0; i<len; i++) {
//            for (int j=0; j<len; j++) {
//                a[sx+i][sy+j] = b[i][j];
//            }
//        }
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int r = sc.nextInt();
//        int size = (1 << n);
//        int[][] a = new int[size][size];
//        for (int i=0; i<size; i++) {
//            for (int j=0; j<size; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        while (r-- > 0) {
//            int k = sc.nextInt();
//            int l = sc.nextInt();
//            int sub_size = (1 << l);
//            if (1 <= k && k <= 4) {
//                for (int i=0; i<size; i+=sub_size) {
//                    for (int j=0; j<size; j+=sub_size) {
//                        operation_1_to_4(a, k, i, j, sub_size);
//                    }
//                }
//            } else if (5 <= k && k <= 8) {
//                if (k == 5) {
//                    a = operation5(a, l);
//                } else if (k == 6) {
//                    a = operation6(a, l);
//                } else if (k == 7) {
//                    a = operation7(a, l);
//                } else if (k == 8) {
//                    a = operation8(a, l);
//                }
//            }
//        }
//        for (int i=0; i<size; i++) {
//            for (int j=0; j<size; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}





