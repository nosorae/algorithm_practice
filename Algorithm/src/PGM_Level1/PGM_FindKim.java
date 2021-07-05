package PGM_Level1;


/*
 * PGM 서울에서 김서방 찾기 https://programmers.co.kr/learn/courses/30/lessons/12919?language=java
 */
class PGM_FindKim {
    public String solution(String[] seoul) {
         String answer = "";
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = "김서방은 "+i+"에 있다";
                break;
            }
        }
       
        return answer;
    }
}