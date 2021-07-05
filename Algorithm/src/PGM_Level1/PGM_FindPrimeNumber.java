package PGM_Level1;

/*
 * PGM 소수 찾기 https://programmers.co.kr/learn/courses/30/lessons/12921?language=java
 */
class PGM_FindPrimeNumber {
    public int solution(int n) {
        int answer = 0;
        boolean[] eratos = getEratos(n);
        for(int i = 1; i <= n; i++) {
            if(!eratos[i])
                answer++;
        }
        return answer;
    }
    static boolean[] getEratos(int size) {
        boolean[] arr = new boolean[size+1];
        arr[1] = true;
        for(int i = 2; i*i <= size; i++) {
            for(int j = i*i; j <= size; j+=i) {
                arr[j] = true;
            }
        }
        return arr;
    }
}