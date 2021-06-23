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
		//-------------------------------------------------------------------
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
		
		HashMap<Integer, Integer> maps = new HashMap<>();
		maps.put(1, 2);
		maps.put(2, 3);
		maps.put(3, 4);
		Set<Map.Entry<Integer, Integer>> entries = maps.entrySet();
		
		for(Map.Entry<Integer, Integer> entry : entries)
			System.out.println(entry.getValue());
		
		
		
		//------------------------------------------------------------------
		LinkedList<Integer> list = new LinkedList<Integer>();
    	list.add(1);
    	list.add(2);
    	
    	Integer[] arr3 = new Integer[list.size()];
    	arr3[0] = -1;
    	arr3[1] = -2;
    	Integer[] arr2 = list.toArray(arr3);
    	for(int a : arr2) {
    		System.out.println(a);
    	}
    	for(int a : arr3) {
    		System.out.println(a);
    	}
    	System.out.println(arr3 == arr2);
    	
    	
    	String[] array = new String[3];

    	array[0] = "Test1";
    	array[1] = "Test2";
    	array[2] = "Test3";

    	ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
		
		arrayList.add("Test4");
		for(String str : arrayList) {
			System.out.println(str);
		}
		//--------------------------------------------------------------
	
		
	}

}
