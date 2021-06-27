package PGM_Level2;

/*
 * 2021.06.27
 * PGM 뉴스 클러스터링 https://programmers.co.kr/learn/courses/30/lessons/17677
 * 각 문자열 한글자씩 이동하며 두글자씩 자르며 갯수 맵(key : 두글자, value : 갯수)을 만들고
 * (이때 모두 소문자화하고, 특수문자는 제외)
 * 교집합과 합집합 맵을 만든다. 이 단계가 이 문제의 핵심
 * 유사도 구하고 65536 곱하고 정수부만 답으로 낸다.
 * 중복집합에서의 map.size()는 원소의 종류 개수다.
 * 그래서 중복집합에서 원소의 총 개수 != 원소의 종류 개수다.
 * 원래 집합에서는 원소의 총 개수 == 원소의 종류 개수 라서 헷갈렸다. 이것 때문에 삽질해서 시간 많이 버렸다.
 * double과 int 형변환을 자유자재로 할 줄 알아야한다! 이것 때문에도 삽질해서 시간 버렸다.
 * 다음부턴 이런 실수하지 말고 실수했다 하더라도 빠른 부분 디버깅을 통해 문제가 생긴부분을 다시 고려해봐야겠다.
 * 1시간 12분
 *
 */
import java.util.*;
class PGM_NewsClustering_Hard {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        HashMap<String, Integer> strMap1 = new HashMap<>();
        HashMap<String, Integer> strMap2 = new HashMap<>();
        makeStrMap(strMap1, str1);
        makeStrMap(strMap2, str2);
        
        HashMap<String, Integer> inter = getInter(strMap1, strMap2);
        HashMap<String, Integer> union = getUnion(strMap1, strMap2);
        
        int interCnt = getMapCount(inter);
        int unionCnt = getMapCount(union);
        
        if(union.size() == 0) return 65536;
        double similarity = interCnt / (double)unionCnt;
        //System.out.println(interCnt +" / "+ unionCnt +" = " +similarity);
        int answer = ((int)(similarity*65536*10))/10;
        return answer;
    }
    
    static void makeStrMap(HashMap<String, Integer> map, String str) {
        for(int i = 0; i < str.length()-1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            if(isAlphabet(c1) && isAlphabet(c2)) {
                String localStr = str.substring(i, i+2);
                if(map.containsKey(localStr)) {
                    map.put(localStr, map.get(localStr)+1);
                }
                else {
                    map.put(localStr, 1);
                } 
            }
        }
    }
    static boolean isAlphabet(char c) {
        if(c >= 'a' && c <= 'z')
            return true;
        else
            return false;
    }
    
    static HashMap<String, Integer> getInter(Map<String, Integer> m1, Map<String, Integer> m2) {
        HashMap<String, Integer> inter = new HashMap<String, Integer>();
        for(String key : m1.keySet()) {
            if(m2.containsKey(key)) {
                inter.put(key, getMin(m1.get(key), m2.get(key)));
            }
        }
        return inter;
    }
    static int getMin(int a, int b) {
        if(a < b) return a;
        else return b;
    }
    
    static HashMap<String, Integer> getUnion(Map<String, Integer> m1, Map<String, Integer> m2) {
        HashMap<String, Integer> union = new HashMap<String, Integer>();
        for(String key : m1.keySet()) {
            if(m2.containsKey(key)) {
                union.put(key, getMax(m1.get(key), m2.get(key)));
                m2.remove(key);
            }
            else
                union.put(key, m1.get(key));
        }
        for(String key : m2.keySet()) {
            union.put(key, m2.get(key));
        }
        
        return union;
    }
    static int getMax(int a, int b) {
        if(a > b) return a;
        else return b;
    }
    
    static int getMapCount(HashMap<String, Integer> map) {
        int sum = 0;
        for(int v : map.values())
            sum += v;
        return sum;
    }
    
    
}