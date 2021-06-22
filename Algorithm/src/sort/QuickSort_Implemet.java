package sort;

public class QuickSort_Implemet {

	public static void main(String[] args) {
		int[] arr = {7, 5, 3, 9, 8, 1};
		System.out.println("Quick Sort");
		sort(arr, 0, arr.length-1);

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		String str = "";
		
	}

	static void sort(int[] arr, int left,int right) {
		int pl = left;
		int pr = right;
		int pivot = arr[(pl+pr)/2];


		do {
			// >= <= 아님!! 그래야 인덱스 제한 안넘어가고 멈춘다.
			while(arr[pl]<pivot) pl++; //큰놈나올때까지 오른쪽으로 
			while(arr[pr]>pivot) pr--; //작은놈나올때까지  왼쪽으로 
			//탈출했다는건 크거나, 같거나 한겨
			if(pl<=pr) { 			// pl과 pr이 만나면 
				int temp = arr[pl];	// 위치를 바꿔준다 . 
				arr[pl] = arr[pr];
				arr[pr] = temp;
				pl++;
				pr--;
			}
		}while(pl<=pr);	//전체적인 pl < pr이 될 때까지 

		if(left < pr) sort(arr, left, pr);
		if(right> pl) sort(arr, pl, right);
	}

}



//	static void quickSort(int[] arr, int left, int right) {
//
//		int pivot = partition(arr, left, right);
//
//		if(pivot > 0)
//			quickSort(arr, left, pivot-1);
//
//		if(pivot < arr.length-1)
//			quickSort(arr, pivot+1, right);
//
//	}
//
//	/*
//	 * pivot의 값을 기점으로 왼쪽은 작은 숫자만 오른쪽은 큰 숫자만 위치하게 만들고 
//	 * 새로운 pivot인 right를 반환한다?
//	 */
//	static int partition(int[] arr, int left, int right) {
//
//		int pivot = (right + left)/2;
//		do {
//			while(left < arr.length-1 && arr[left] <= arr[pivot]) left++;
//			while(right > 0 && arr[right] >= arr[pivot]) right--;
//
//			if(left <= right) {
//				swqp(arr, left, right);
//			}
//
//
//		} while(left <= right);
//
//		swqp(arr, pivot, right);
//
//		return right;
//
//
//	}
//	static void swqp(int[] arr, int a, int b) {
//		int temp = arr[a];
//		arr[a] = arr[b];
//		arr[b] = temp;
//	}
//}
