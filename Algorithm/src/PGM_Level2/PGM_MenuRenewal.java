package PGM_Level2;

/*
 * 2021.06.28
 * PGM 메뉴 리뉴얼 https://programmers.co.kr/learn/courses/30/lessons/72411
 * 단품 -> 코스요리, 최소 두명이상이 가장많이 함께 주문한 단품메뉴가 기준
 * 최소 2개이상으로 구성
 * 입력이 뭐가 올지 모르니 다 해봐야하고, 각 order를 course개수만큼 조합
 * 각 order가 정렬되어 들어오기 때문에 오름차순으로 조합하여 해결
 * 그 조합들을 HashMap으로 카운트해서 각 숫자에 맞는 max를 찾는다.
 * 최소 두명이상이 해당 조합을 주문해야한다는 조건은 사실 한 사람안에서는 중복이 없으니 2 이상이면 된다.
 * 문제에서 course가 정렬되어있다고 했는데 나는 order들이 각각 정렬되어있는 줄 알았다.
 * 51분
 */
import java.util.*;

class PGM_MenuRenewal {
    static HashMap<String, Integer>[] orderMap;
    static int orderMapIdx = 0;
    
    static int[] combi = new int[10];
    
    public String[] solution(String[] orders, int[] course) {
        
        //해쉬맵의 배열 초기화
        orderMap = new HashMap[course.length];
        for(int i = 0; i < course.length; i++) {
            orderMap[i] = new HashMap<String, Integer>();
        }
        
        for(int i = 0; i < orders.length; i++) {
            char[] curOrder = orders[i].toCharArray();
            Arrays.sort(curOrder);
            
            for(int j = 0; j < course.length; j++) {
                orderMapIdx = j;
                putIntoMap(curOrder, 0, 0, course[j]);
            }
        }
        
        // for(Map.Entry<String, Integer> e : orderMap[0].entrySet())
        //     System.out.println(e.getKey() +" " + e.getValue());
        
        int[] maxCourse = new int[course.length]; //정답 후보들의 등장횟수
        for(int i = 0; i < course.length; i++) {
            for(int val : orderMap[i].values()) {
                if(maxCourse[i] < val)
                    maxCourse[i] = val;
            } 
        }
        ArrayList<String> ans = new ArrayList<String>();
        for(int i = 0 ; i < orderMap.length; i++) {
            for(Map.Entry<String, Integer> e : orderMap[i].entrySet()) {
                if(maxCourse[i] < 2)
                    break;
                if(maxCourse[i] == e.getValue())
                    ans.add(e.getKey());
            }
        }
        
        Collections.sort(ans);
        String[] answer = {};
        answer = ans.toArray(new String[ans.size()]);
        return answer;
    }
    //브루트포스
    static void putIntoMap(char[] curOrder, int depth, int start, int m) {
        if(depth == m) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < depth; i++) {
                sb.append(curOrder[combi[i]]);
            }
            String key = sb.toString();
            if(orderMap[orderMapIdx].containsKey(key))
                orderMap[orderMapIdx].put(key, orderMap[orderMapIdx].get(key) + 1);
            else
                orderMap[orderMapIdx].put(key, 1);
        }
        for(int i = start; i < curOrder.length; i++) {
            combi[depth] = i;
            putIntoMap(curOrder, depth+1, i+1, m);
        }
        
    }
}