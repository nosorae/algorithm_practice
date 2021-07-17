



import java.util.*;
import java.io.*;
class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int answer;
	static int n;
	static int s;
	static int[] arr;
	public static void main(String args[]) throws Exception	{
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = 0;
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= n; i++) {
			placeAll(i, 0, 0, 0);
		}

		bw.write(answer+""); bw.flush();

	}

	static void placeAll(int len, int sum, int depth, int start) throws IOException {

		if(depth == len && sum == s) {
			answer++;
			return;
		}

		for(int i = start; i < n; i++) {
			placeAll(len, sum+arr[i], depth+1, i+1);
		}
		
	}

}