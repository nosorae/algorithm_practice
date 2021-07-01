package Unsolved;

/*
 * BOJ 15661 링크와 스타트
 * N명있을 때 팀 짤 건데 팀에 한명이상만 있으면 만족, 참석을 안하는 경우도 있다.
 * 팀 사이의 능력치 차이가 최소가되게 답을 내는 문제
 * 능력치는 i와 j가 팀이면 arr[i][j]+arr[j][i] 가 된다.
 * 입력이 어떻게 올지 모르니까 다 해봐야하고,
 * 1팀, 2팀 두가지 경우가 있기때문에 3^20약 34억..에다가 매번 이중 for문으로 최대 20^2이므로 다 하면 시간초과가 벌써 보인다.
 * 그러므로 성능향상을 꾀해야한다.
 * 일단 3^20을  2^20으로 바꿀 수 있다. 
 * 왜냐하면 한팀으로 속하거나 참여안하거나만 결정하면 나머지 한팀에 속하는 사람은 결정되기 때문이다.
 * 이 생각은 틀린 것 같다. 
 * 그래도 100만*400은 4억으로 여전히 크다.
 * 일단 스타트와 링크는 둘 중하나라도 n/2을 넘어야하기때문에 
 * 모르겠다 언젠간 정복하자
 * 
 */
import java.util.*;
import java.io.*;

public class BOJ_15661 {
	static int min = 40001;
	static int[][] ability;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		HashSet<Integer> team1 = new HashSet<Integer>();
		makeAllTeam(team1, n, 0); 
		
		System.out.println(min);

	}
	static void makeAllTeam(HashSet<Integer> t1, int n, int idx) {
		
		
		if(t1.size() == n/2) {
			//System.out.println(t1.toString());
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					if(t1.contains(i) && t1.contains(j)) {
						sum1 += ability[i][j];
						sum1 += ability[j][i];
					}
					else if(!t1.contains(i) && !t1.contains(j)) {
						sum2 += ability[i][j];
						sum2 += ability[j][i];
					}
				}
			}
			if(min > abs(sum1, sum2))
				min = abs(sum1, sum2);
			return;
		}
		if(idx >= n) return;
		if(t1.size() > n/2) return;
		if(n/2 - t1.size() > n-(idx+1)) return;		
		
		t1.add(idx); // 1팀에 넣어보고
		makeAllTeam(t1, n, idx+1);
		
		t1.remove(idx); // 2팀에도 넣어봄
		makeAllTeam(t1, n, idx+1);
	}
	static int abs(int a, int b) {
		int dist = a - b;
		if(dist < 0)
			dist = -dist;
		return dist;
	}
}



