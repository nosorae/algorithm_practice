package PGM_Level1;

/*
 * 2021.06.23
 * PGM 문자열 다루기 기본 https://programmers.co.kr/learn/courses/30/lessons/12918
 * 더 깔끔한 코드를 찾아볼 것
 * (추가) 0도 숫자란다..
 * 정규식 풀이1 길이검사 -> s.matches("(^[0-9]*$)"); 
 * 정규식 풀이2 s.matches("^[0-9]{4}|{6}$");
 */

class PGM_StringBasic {
    public boolean solution(String s) {
        int len = s.length();
        if(len == 4 || len == 6) {
            for(int i = 0; i < len; i++) {
                if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }
}