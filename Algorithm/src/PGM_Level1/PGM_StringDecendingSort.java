package PGM_Level1;


//대문자 65~90
//소문자 97~122

/*
 * 
 * PGM 문자열 내림차순으로 배치하기 https://programmers.co.kr/learn/courses/30/lessons/12917
 * 
 */
import java.util.*;

public class PGM_StringDecendingSort {
 
 public String solution(String s) {
     
     Character[] arr = new Character[s.length()];
     for(int i = 0; i < s.length(); i++) {
         arr[i] = (Character) s.charAt(i);
     }
     
     //Collections.sort(arr, Collections.reverseOrder());
     Arrays.sort(arr, Collections.reverseOrder());
     
     StringBuilder sb = new StringBuilder();
     for(int i = 0; i < arr.length; i++) {
         sb.append(arr[i]);
     }
     String answer = sb.toString();
     return answer;
 }
}

//class StringReverseComp implements Comparator<Character> {
 
//  @Override
//  public int compare(Character c1, Character c2) {
     
     
//      if(c1.compareTo(c2) == -1)
//          return 1;
//      else if(c1.compareTo(c2) == 1)
//          return -1;
//      else
//          return 0;
//  }
 
//}