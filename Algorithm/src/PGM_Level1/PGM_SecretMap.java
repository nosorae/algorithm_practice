package PGM_Level1;

//정사각형 길이 n
//하나라도 벽 -> 벽  1
//모두 공백 -> 공백  0
//열이 각 비트의 위치에 해당한다.
/*
* 2021.06.19
* PGM 비밀지도 https://programmers.co.kr/learn/courses/30/lessons/17681
* 공백이 1이라고 생각하고 처음에 &로 했다가 삽질함
* 비트연산 문제 https://coding-factory.tistory.com/521 (참고) 
* 아래 세가지로 더 간결한 코드로도 풀 수 있다.
* Integer.toBinaryString(int) 
* String.format("%" + n + "s", result[i])  https://interconnection.tistory.com/116 (참고)
* String[].replaceAll("", "")을 활용해서도 풀 수 있다.
*/
class PGM_SecretMap {
 public String[] solution(int n, int[] arr1, int[] arr2) {
     
     int[] andOpResult = new int[n];
     
     for(int i = 0; i < n; i++) {
         andOpResult[i] = arr1[i] | arr2[i];
     }
     
     String[] answer = new String[n];
     
     for(int i = 0; i < n; i++) {
         StringBuilder sb  = new StringBuilder();
         for(int j = 0; j < n; j++) {
             
             //System.out.println("숫자는 "+andOpResult[i]+" 연산결과는 "+(andOpResult[j]>>j));
             
             if((andOpResult[i] >> j) % 2 != 0)
                 sb.append("#");
             else
                 sb.append(" ");
         }
         //System.out.println();
         answer[i] = sb.reverse().toString();
     }
     
     
     return answer;
 }
}