package PGM_Level2;

// 2021.07.02
// N진수 게임 https://programmers.co.kr/learn/courses/30/lessons/17687
//정수를 진법에맞게 반환하는 함수 필요
//그리고 m(참가인원)을 더해가며 출력  
import java.util.*;
class PGM_ChangeUnitGame {
 static char[] nChar;
 public String solution(int n, int t, int m, int p) {
     
     inIt(); //초기화
     
     //진법에 맞는 1~m*t까지의 수의 나열
     StringBuilder sb = new StringBuilder();
     for(int i = 0; i <= m*t; i++) {
         sb.append(parseNum(i, n));
     }
     String nums = sb.toString();
     //System.out.println(nums);
     
     int idx = p-1; // 인덱스는 0부터 시작하니까 -1
     sb = new StringBuilder();
     for(int i = 0; i < t; i++) { // 인원수 만큼 더해가며 t번 반복
         sb.append(nums.charAt(idx));
         idx += m; 
     }
     
     return sb.toString();
 }
 static void inIt() {
     // 숫자에 따른 문자열 인덱스 초기화
     nChar = new char[16];
     int idx = 0;
     for(char i = '0'; i <= '9'; i++) {
         nChar[idx] = i;
         idx++;
     }
     idx = 10;
     for(char i = 'A'; i <= 'F'; i++) {
         nChar[idx] = i;
         idx++;
     }
 }
 static String parseNum(int n, int nota) {
    
     if(n == 0) // 0은 예외처리
         return "0";
     
      StringBuilder sb = new StringBuilder();
     int cur = n;
     while(cur != 0) {
         sb.append(nChar[cur%nota]);
         cur /= nota;
     }
     return sb.reverse().toString();
 }
}