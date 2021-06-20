package PGM_Level2;


/*
 * 2021.06.20
 * PGM 위장 https://programmers.co.kr/learn/courses/30/lessons/42578
 * 세는 것을 0부터 세니까 틀리지.. 1부터 세면 맞다!
 * 각각의 종류마다 안입거나 각각하나씩 입을 수 있으니 +1 해서 다 곱해주고 -1 해주면 1개이상입는 모든 조합이 나온다.
 * 안입는 것을 하나의 종류로 생각해서 조합을 생각하는 방식을 얻었다!
 * clothes[i][1] 이걸 변수로 만들어서 쓰는 게 더 좋겠지
 *
 */ 

import java.util.*;

class PGM_Camouflage_Hard {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> clothCnt = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++) {
            if (!clothCnt.containsKey(clothes[i][1])) {
                clothCnt.put(clothes[i][1], 1);
            } 
            else {
                int temp = clothCnt.get(clothes[i][1]) + 1;
                clothCnt.put(clothes[i][1] , temp);
            }
        }
        
        int answer = 1;
        
        for(Integer n : clothCnt.values()) {
            answer *= (n+1);
        }
        answer--;
        
        return answer;
    }
}