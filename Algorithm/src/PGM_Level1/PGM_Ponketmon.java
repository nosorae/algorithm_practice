package PGM_Level1;


/*
 * 2021.06.23 
 * PGM 폰켓몬 https://programmers.co.kr/learn/courses/30/lessons/1845
 * set에 다 넣어서 set의 사이즈보고 N/2보다 크면 N/2가 답이고 N/2보다 작으면 set의 사이즈가 답
 * set이 중복x라는 점을 이용
 * 12분
 */
import java.util.*;
class PGM_Ponketmon {
    public int solution(int[] nums) {
        HashSet<Integer> ponkets = new HashSet<Integer>();
        for(int n : nums) {
            ponkets.add(n);
        }
        int answer = ponkets.size();
        if(ponkets.size() > nums.length/2) 
            answer = nums.length/2;
        return answer;
    }
}