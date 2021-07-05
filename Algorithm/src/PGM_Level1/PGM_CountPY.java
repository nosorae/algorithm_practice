package PGM_Level1;


/*
 * PGM 문자열 내 p와 y의 개수 https://programmers.co.kr/learn/courses/30/lessons/12916?language=java
 */
class PGM_CountPY {
    boolean solution(String s) {
        s = s.toLowerCase();
        int yCnt = 0;
        int pCnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'p')
                pCnt++;
            else if(s.charAt(i) == 'y')
                yCnt++;
        }
        return yCnt == pCnt;
    }
}