package bruteforce;
/*
 * BOJ 10971 외판원 순회2
 * 다 방문한다. + 순서에 따라 최소값이 발생한다.
 * 두가지 점을 근거로 모든 순열을 활용해서 다 해보고 답을 구해본다는 마인드이다. 당연히 재귀로도 구할 수 있다.
 * 더 효율적으로 하기위해서  맨 앞 숫자를 고정시키고 구현할 수도 있다. 
 * 예를 들어 1 2 3 4 5/ 5 1 2 3 4/ 4 5 1 2 3/ 3 4 5 1 2/ 2 3 4 5 1
 * 위 5개는 이 문제에서는 모두 동일한 취급을 받으니까 그냥 하나만 하면되고 그 방법으로 한 숫자를 고정시키고 나머지를 순열 순회하는 방법이 있다.
 */
import java.util.*;
import java.io.*;

public class BOJ_10971 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				dist[i][j] = sc.nextInt();
			}
		}
		int[] permutation = new int[n];
		for(int i = 0; i < n; i++) {
			permutation[i] = i;
		}
		
		int min = Integer.MAX_VALUE;
		do {
			int cur = get_dist_sum(dist, permutation);
			if(min > cur)
				min = cur;
		} while(next_permutation(permutation));
		
		System.out.println(min);
		
	}
	static int get_dist_sum(int[][] dist, int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			if(dist[arr[i]][arr[i+1]] == 0)
				return Integer.MAX_VALUE;
			sum += dist[arr[i]][arr[i+1]];
		}
		if(dist[arr[arr.length-1]][arr[0]] == 0)
			return Integer.MAX_VALUE;
		sum += dist[arr[arr.length-1]][arr[0]];
		return sum;
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
}



