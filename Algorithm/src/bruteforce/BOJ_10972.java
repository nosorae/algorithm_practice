package bruteforce;

/*
 * BOJ 10972 다음 순열  https://www.acmicpc.net/problem/10972
 * reverse함수에서 left를 왼쪽으로(--) 옮기는 실수가 있었다. right는 왼쪽으로(--) 옮기고 left는 오른쪽으로 옮겨야 둘이 만나지!!
 */
import java.util.*;
import java.io.*;

public class BOJ_10972 {
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] permutation = new int[n];
		for(int i = 0; i < n; i++) {
			permutation[i] = sc.nextInt();
		}
		
		if(next_permutation(permutation))
			print_array(permutation);
		else
			System.out.println(-1);
	}
	static void print_array(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
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
	static void reverse(int[] prev, int left, int right) {
		while(left < right) {
			swap(prev, left, right);
			left++; // 둘 다 마이너스로 해서 문제가 있었다.
			right--;
		}
	}
}



