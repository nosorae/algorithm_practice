package PGM_Level2;

/*
 * 2021.06.28
 * PGM 튜플 https://programmers.co.kr/learn/courses/30/lessons/64065
 * 중복없는 원소 배열이 주어질 때, 
 * 중복o, 순서o
 * 일단 입력으로 주어진 s 파싱이 문제 : s.split("[^0-9]+")로 해결
 * split한 결과의 인덱스 0에 빈문자열이 생기는 이유는??
 * Map으로 등장횟수를 세어준다.
 * 그리고 등장횟수를 기준으로 정렬해서 리턴해야하기 때문에 클래스만들고 등장횟수로 정렬한다
 * 숫자를 String으로 처리했으니 마지막에 답 낼 때는 숫자로 파싱해주는 것 잊지말자!
 * 31분
 */
import java.util.*;
class PGM_Tuple {
    public int[] solution(String s) {
        String[] sArr = s.split("[^0-9]+");
        HashMap<String, Integer> sMap = new HashMap<>();
        for(int i = 1; i < sArr.length; i++) {
            String key = sArr[i];
            if(sMap.containsKey(key))
                sMap.put(key, sMap.get(key) + 1);
            else
                sMap.put(key, 1);
        }
        ArrayList<Tuple> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> e : sMap.entrySet()) 
            ans.add(new Tuple(e.getKey(), e.getValue()));
        
        Collections.sort(ans);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = Integer.parseInt(ans.get(i).num);
        }
        
        return answer;
    }
    class Tuple implements Comparable<Tuple> {
        String num;
        int cnt;
        public Tuple(String n, int c) {
            num = n;
            cnt = c;
        }
        @Override
        public int compareTo(Tuple o) {
            return o.cnt - this.cnt; // cnt기준 내림차순
        }
    }
}