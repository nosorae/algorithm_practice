package PGM_Level1;


/*
 * 2021.06.21
 * PGM 완주하지 못한 선수 https://programmers.co.kr/learn/courses/30/lessons/42576
 * 이 문제의 핵심은 중복이름이 있을 수 있다는 것이다.
 * 중복이름이 없다면 HashSet으로도 문제를 해결할 수 있지만, 중복이름의 숫자를 세주기 위해 HashMap을 사용하였다.
 */

import java.util.*; 
class PGM_UnfinishedPlayer_Hard {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int len = participant.length;
        HashMap<String, Integer> pass = new HashMap<String, Integer>();
        
        for(int i = 0; i < participant.length; i++) {
            if(pass.containsKey(participant[i]))
                pass.put(participant[i], pass.get(participant[i]) + 1); // 중복이름이라면 1 더해준다.
            else
                pass.put(participant[i], 1); // 처음 등장한 이름이면 value를 1로 초기화
        }
        
        for(int i = 0; i < completion.length; i++) {
            String name = completion[i];
    
            if(pass.get(name) >= 2)
                pass.put(completion[i], pass.get(completion[i]) - 1); //2 이상이면 value 1 빼주고
            else {
                pass.remove(name); // 1이면 맵에서 삭제한다
            }
        }
        
        Iterator<String> it = pass.keySet().iterator();
        answer = it.next();

        return answer;
    }
}