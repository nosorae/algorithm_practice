package PGM_Level1;


import java.util.*;
/*
 * 2021.06.20 
 * PGM 체육복 https://programmers.co.kr/learn/courses/30/lessons/42862
 * 일단 왼쪽부터 차곡차곡 빌려준다고 생각하면 최선이 될 것이다. 근데 이건 순서대로 주었을 경우만 해당하는 거 아닌가??
 * 처음에는 배열로 0 1 2만 이용해서 왼쪽먼저 조회하는 것까지 했는데 왜 틀렸는지 코드가 날라가서 모르겠다.
 * 이후 다른 사람 코드보고 중복이 없다는 점을 생각해 Set으로 접근하는데 서로 차집합에서 살짝 문제가 있었다.
 * 두 집합이 서로 차집합을 해줘야 하는 상황에서 a-b한상태에서 b-a를 하면 a는 원하는 결과가 나오지만
 * b-a에서 a는 이미 기존 b와 겹치는 원소가 없어졌기 때문에 b에서는 교집합 원소를 제거할 수 없는 문제가 발생한다.
 * 
 */







class PGM_GymSuit_Hard {
	public int solution(int n, int[] lost, int[] reserve) {
		
		int answer = 0;
		
		HashSet<Integer> lostSet = new HashSet<Integer>();
		HashSet<Integer> reserveSet = new HashSet<Integer>();
		
		for(int l : lost) {
			lostSet.add(l);
		}
		for(int r : reserve) {
			reserveSet.add(r);
           
		}
		
		lostSet.removeAll(reserveSet);
        
        for(int l : lost) {
            reserveSet.remove(l);
        }
        
		
		
		Iterator lostIt = lostSet.iterator();
		
		for(int cur : reserveSet) {
            System.out.println(cur);
			if(lostSet.contains(cur-1)) {
				lostSet.remove(cur-1);
			}
			else if(lostSet.contains(cur+1)) {
				lostSet.remove(cur+1);
			}
		}
		
		answer = n-lostSet.size();
		return answer;
	}

}