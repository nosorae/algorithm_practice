package PGM_Level1;

/*
 * 2021.06.23
 * PGM ³»Àû https://programmers.co.kr/learn/courses/30/lessons/70128
 */
class PGM_DotProduct {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];   
        }
        return answer;
    }
}