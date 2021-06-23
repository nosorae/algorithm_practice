package PGM_Level1;

/*
 * 2021.06.22
 * PGM 소수 만들기 https://programmers.co.kr/learn/courses/30/lessons/12977
 * 에라토스테네스의 체로 소수배열을 만들고 브루트포스-순열로 모든 경우 다 시도해보는 방식으로 풀이
 * nPr 순열 구현하는 법 배워보자.. nCr도!
 * 재귀로 구현할 수도 있을것이다.
 * 문제파악 제대로 못하고 한번 틀렸다. 소수찾는 배열 사이즈를 1000으로 잡았다.. 
 * 원소하나의 최대값이 1000인데 말이다.. 그럼 최대 3000이니 사이즈도 3000으로 잡아야지!
 * 40분
 */
class PGM_MakePrimeNumber {
    public int solution(int[] nums) {
        boolean[] isPrime = getEratos(3000);
        int result = 0;
        for(int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(!isPrime[nums[i] + nums[j] + nums[k]])
                        result++;
                }
            }
        }
        return result;
    }
    
    static boolean[] getEratos(int n) {
        boolean[] era = new boolean[n+1];
        era[0] = era[1] = true;
        for(int i = 2; i*i <= n; i++) {
            for(int j = i*i; j <= n; j += i) {
                era[j] = true;
            }
        }
        return era;
    }
    
}