package dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_1463 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
	
		for(int i = 2; i <= n; i++) {
			
			arr[i] = arr[i-1] + 1;
			if(i%3 == 0 && arr[i] > arr[i/3] + 1) {
				arr[i] = arr[i/3] + 1;
			}
			if(i%2 == 0 && arr[i] > arr[i/2] + 1) {
				arr[i] = arr[i/2] + 1;
			}
		}
		
		System.out.print(arr[n]);

	}


}


//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Stack;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int n = Integer.parseInt(br.readLine());
//		int[] arr = new int[n+1];
//	
//		for(int i = 2; i <= n; i++) {
//			
//			arr[i] = arr[i-1] + 1;
//			if(i%3 == 0 && arr[i] > arr[i/3] + 1) {
//				arr[i] = arr[i/3] + 1;
//			}
//			if(i%2 == 0 && arr[i] > arr[i/2] + 1) {
//				arr[i] = arr[i/2] + 1;
//			}
//		}
//		
//		System.out.print(arr[n]);
//
//	}
//
//
//}