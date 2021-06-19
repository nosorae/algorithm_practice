package PGM_Level1;

/*
 * 2021.06.19
 * PGM 이상한 문자 만들기 https://programmers.co.kr/learn/courses/30/lessons/12930#
 * String => char[] 변환 & 수정 => String 변환 과정을 음미하는 계기
 * 대문자 ASCII 65 90
 * 소문자 ASCII 97 122
 * char는 정수연산이 가능하다
 */
class PGM_MakeStrangeString {
    public String solution(String s) {
        char[] letters = s.toCharArray();
        
        int localIdx = -1;
        
        for(int i = 0; i < letters.length; i++) {
            
            char cur = letters[i];
            localIdx++;
            
            if(cur == ' ') {
                localIdx = -1;
                continue;
            }
            
            //짝수이고 소문자니 대문자로 바꿔주자
            if(localIdx%2 == 0 && cur >= 97 && cur <= 122){
                letters[i] -= 32;    
            }
            
            //홀수이고 대문자이니 소문자로 바꿔주자
            else if(localIdx%2 != 0 && cur >= 65 && cur <= 90){
                letters[i] += 32;

            }
        
        }
        
        
        String answer = new String(letters);
        return answer;
    }
    
   
}