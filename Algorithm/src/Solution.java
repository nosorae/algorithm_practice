import java.util.*;

class Solution {


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
		reserveSet.removeAll(lostSet);
		
		Iterator lostIt = lostSet.iterator();
		
		for(int cur : lostSet) {
			if(reserveSet.contains(cur-1)) {
				lostSet.remove(cur);
				reserveSet.remove(cur-1);
			}
			else if(reserveSet.contains(cur+1)) {
				lostSet.remove(cur-1);
				reserveSet.remove(cur+1);
			}
		}
		
		return n-lostSet.size();
	}

}