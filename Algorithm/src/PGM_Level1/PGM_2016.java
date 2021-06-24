package PGM_Level1;

/*
 * 21.06.17
 * 프로그래머스 2016 https://programmers.co.kr/learn/courses/30/lessons/12901#
 * 날짜 옮겨적는 실수 때문에 시간 많이 잡아먹음.
 */

class PGM_2016 {
 public String solution(int a, int b) {
     final String[] days ={"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
     final int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
     int sum = 0;
     for(int i = 1; i < a; i++) {
         sum = sum + months[i];
     }
     sum = sum + b;
     int ans = sum % 7;
     String answer = days[ans] + "";
     
     
     
     return answer;
 }

}