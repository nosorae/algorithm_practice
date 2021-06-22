package PGM_Level2;

/*
 * 2021.06.22
 * PGM 소수찾기 https://programmers.co.kr/learn/courses/30/lessons/42839
 * 소수의 정의 : 1을 제외한 모든 자연수중 약수가 1과 자기자신 뿐인 숫자
 * 숫자의 길이가 최대 7이므로 7! == 5040 으로 브루트포스로 충분히 가능함을 확인
 * 중복된 숫자가 있기때문에("011"처럼) 순서를 신경썼어야했다. 이런걸 순열문제라고 하는구나
 * 중복된 원소가 있을 때 중복된 결과 없이 브루트포스하는 법을 까먹어서 HashSet사용 다시 알아보자..
 * static 변수들을 줄이고 해결도 해보자..
 * <추가> Set쓸거면 cnt변수 없애도 된다. 왜냐하면 Set.size쓰면 되니까
 * 
 */
import java.util.*;

class PGM_FindPrimeNum {
    static int[] nums; // 숫자 한자릿수로 배열화
    static boolean[] isUsed;  // 브루트포스에서 check 배열로 사용
    static boolean[] isNotPrime; // 소수인지 판별하는 배열 false이면 소수
    static int len; // 첫 입력 String의 길이
    static int cnt; // 정답에 쓰일 것이다.
    static HashSet<String> included = new HashSet<String>();
    public int solution(String numbers) {
        isNotPrime = getPrimeArr(10000000);
        len = numbers.length();
        nums = new int[len];
        isUsed = new boolean[len]; 
        cnt = 0;
        for(int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        findPrimeNum("");
        
        int answer = cnt;
        return answer;
    }
    static boolean[] getPrimeArr(int n) {
        boolean[] arr = new boolean[n+1]; // 1000만 기준 약 10MB?
        arr[1] = true;
        for(int i = 2;  i < n/2; i++) {
            if(!arr[i]) {
                for(int j = i*2;  j <= n; j += i) {
                    arr[j] = true; //false이면 소수가 된다.
                }
            }
        }
        return arr;
    }
    
    static void findPrimeNum(String curNum) {
        
        //탈출조건
        if(curNum.length() > len)
            return;
        
        /*
         * 1. 빈 문자열이면 숫자 안됨
         * 2. 앞글자가 0이면 숫자 안됨
         * 3. 1, 2번 만족하면 숫자이니 소수인지 판별
         * 4. 이미 정답으로 카운트된 숫자인지 판별
         */
        if(curNum.length() != 0 && curNum.charAt(0) != '0'
           && !isNotPrime[Integer.parseInt(curNum)] && !included.contains(curNum)) { 
            cnt++;
            included.add(curNum);
            System.out.println(curNum);
        }
            
        for(int i = 0; i < len; i++) {
            if(!isUsed[i]) { // 중복체크 
                isUsed[i] = true;
                findPrimeNum(curNum+nums[i]);
                isUsed[i] = false;
            }
        }
        
    }
}


/*
 * 아래와 같은 방법도 있구나 <출처> 프로그래머스 다른 사람의 풀이
 * set에 모든 경우의 수를 다 넣어놓고 시작하니 중복체크도 필요없게된다.
 */


//import java.util.HashSet;
//class Solution {
//    public int solution(String numbers) {
//        HashSet<Integer> set = new HashSet<>();
//        permutation("", numbers, set);
//        int count = 0;
//        while(set.iterator().hasNext()){
//            int a = set.iterator().next();
//            set.remove(a);
//            if(a==2) count++;
//            if(a%2!=0 && isPrime(a)){
//                count++;
//            }
//        }        
//        return count;
//    }
//
//    public boolean isPrime(int n){
//        if(n==0 || n==1) return false;
//        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
//            if(n%i==0) return false;
//        }
//        return true;
//    }
//
//        public void permutation(String prefix, String str, HashSet<Integer> set) {
//        int n = str.length();
//        //if (n == 0) System.out.println(prefix);
//        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
//        for (int i = 0; i < n; i++)
//          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
//
//    }
//
//}
