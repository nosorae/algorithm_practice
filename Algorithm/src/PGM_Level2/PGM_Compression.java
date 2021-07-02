package PGM_Level2;

/*
 * 2021.07.02
 * PGM 압축 https://programmers.co.kr/learn/courses/30/lessons/17684
 * 일단 HashMap<String, Integer>로 단어와 색인번호를 저장해야겠다.
 * A-Z까지 1~26으로 초기화
 * w찾고 색인번호 출력, 다음글자 붙여서 사전에 등록
 * 그냥 시키는대로 했더니 풀린다.
 */
import java.util.*;
class PGM_Compression {
    static int idx;
    static int len;
    public int[] solution(String msg) {
        idx = 1;
        HashMap<String, Integer> dic = new HashMap<>();
        for(char c = 'A'; c <= 'Z'; c++)
            dic.put(c+"", idx++);
        
        len = msg.length();
        int start = 0;
        int end = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < len; ) {
            start = i;
            end = findEnd(dic, msg, start);
            String w = msg.substring(start, end); //처리한 문자열
            ans.add(dic.get(w));
            if(end+1 <= len)
                dic.put(msg.substring(start, end+1), idx++);// w+c를 사전에 추가
            i = end; // 인덱스로 제거
        }
        
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);
        
        return answer;
    }
    static int findEnd(HashMap<String,Integer> dic, String msg, int start) {
        for(int i = start+1; i <= len; i++) {
            String sub = msg.substring(start, i);
            if(!dic.containsKey(sub))
                return i-1;
        }
        return len;
    }
}