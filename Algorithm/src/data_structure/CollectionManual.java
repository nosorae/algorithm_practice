package data_structure;

import java.util.*;

public class CollectionManual {

	public static void main(String[] args) {
		//리스트의 배열 
		ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[3];
		
		//큐 선언과 삽입 조회 삭제
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.peek();
		q.poll();
		
		//<key, value> 페어
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, null);
		
		System.out.println(map.putIfAbsent(4, "z")); // 해당 키에 해당하는 값이 있으면 해당 그냥 해당 값 리턴하고, 아니라면  해당 값 넣어준다.
		System.out.println(map.get(4));
		
		System.out.println(map.containsKey(1)); // 맵에 해당 키나 값이 있는가? 있으면 true 없으면 false
		System.out.println(map.containsKey(4));
		System.out.println(map.containsValue("c"));
		System.out.println(map.containsValue("d"));
		
		System.out.println(map.getOrDefault(1, "z"));
		System.out.println(map.getOrDefault(4, "z"));
		
		
		System.out.println("entrySet()");
		for(Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getKey()+ " " + e.getValue());
		}
		System.out.println();
		
		System.out.println("keySet()");
		for(Integer key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println();
		
		System.out.println("values()");
		for(String val : map.values()) {
			System.out.println(val);
		}
		System.out.println();
		
		System.out.println("size() : " + map.size());
		
		System.out.println(map);
		System.out.println(map.toString());
		
		
			
		
	
		
	}

}
