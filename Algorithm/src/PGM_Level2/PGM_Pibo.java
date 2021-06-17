package PGM_Level2;

/*
 * 21.06.17
 * 프로그래머스 피보나찌 https://programmers.co.kr/learn/courses/30/lessons/12945
 * 경계처리와 나머지 연산 생각 
 * (a+b)%c = (a%c + b%c) % c
 */
class PGM_Pibo {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        
        int answer = dp[n];
        return answer;
    }
}