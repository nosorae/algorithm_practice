package PGM_Level2;

// 2021.07.02
// PGM 파일명 정렬 https://programmers.co.kr/learn/courses/30/lessons/17686
//영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-") 로만 이루어짐
//파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.
//파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다.
//HEAD가 같다면 숫자 순으로 정렬
//숫자도 같다면 처음에 주어진 순서 유지
//클래스만들어서 head number id 세개로 compareTo 구현
//Tail은 사실상 필요없다..?
//첫시작은 무조건 문자 최소 하나이상 => 그다음에 숫자 무조건 하나이상 최대 다섯개
import java.util.*;
class PGM_FileNameSort {
 public String[] solution(String[] files) {
     ArrayList<File> infos = new ArrayList<File>();
     
     for(int i = 0; i < files.length; i++) {
         String cur = files[i];
         String head = "";
         int number = 0;
         
         int idx = 0;
         StringBuilder sb = new StringBuilder();
         while(!isNumber(cur.charAt(idx))) {
             sb.append(cur.charAt(idx));
             idx++;
         }
         head = sb.toString();
         
         
         sb = new StringBuilder();
         for(int j = 0; j < 5; j++) {
             if(!isNumber(cur.charAt(idx)))
                 break;
             else {
                 sb.append(cur.charAt(idx));
                 idx++;
             }
             
             if(idx >= cur.length()) //tail없이 숫자로 5개 미만으로 채우고 끝날 수도 있으니 
                 break;
         }
         number = Integer.parseInt(sb.toString());
         // System.out.println("head : "+ head);
         // System.out.println("nubmer : "+sb.toString());
         
         infos.add(new File(head, number, i));
     }
     Collections.sort(infos);

     String[] answer = new String[infos.size()];
     for(int i = 0; i < infos.size(); i++) {
         answer[i] = files[infos.get(i).id];
     }
     return answer;
 }
 static boolean isNumber(char c) {
     if(c < '0' || c >'9')
         return false;
     else 
         return true;
 }
}


class File implements Comparable<File> {
 String head;
 int num;
 int id;
 public File(String h, int n, int i) {
     head = h.toLowerCase();
     num = n;
     id = i;
 }
 @Override
 public int compareTo(File o) {
     if(this.head.compareTo(o.head) != 0) {
         return this.head.compareTo(o.head);
     }
     else {
         if(this.num - o.num != 0) {
             return this.num - o.num;
         }
         else {
             return this.id - o.id;
         }
     }
 }
 @Override
 public String toString() {
     return "["+head+", "+num+", "+id+"]";
 }
}