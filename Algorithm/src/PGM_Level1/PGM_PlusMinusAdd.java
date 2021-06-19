package PGM_Level1;

/*
 * 2021.06.19
 * PGM 음양 더하기 https://programmers.co.kr/learn/courses/30/lessons/76501
 */
class PGM_PlusMinusAdd {
    public int solution(int[] absolutes, boolean[] signs) {
        int len = absolutes.length;
        int sum = 0;
        
        for(int i = 0; i < len; i++) {
            if(signs[i])
                sum += absolutes[i];
            else
                sum -= absolutes[i];
        }
        
        int answer = sum;
        return answer;
    }
}