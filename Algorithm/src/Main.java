import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 4, 5, 6};
		//¥‰¿∫ 4242
		int[] arr2 = solution(arr);
		for(int n : arr2) {
			System.out.print(n+" ");
		}
	}
	static int[] solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else
				map.put(arr[i], 1);
			
			System.out.println(map.toString());
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(!set.contains(arr[i]) && map.get(arr[i]) > 1) {
				list.add(map.get(arr[i]));
				set.add(arr[i]);
				System.out.println(map.get(arr[i]));
			}
		}
		
		int[] answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		if(list.size() == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
		return answer;
	}
}