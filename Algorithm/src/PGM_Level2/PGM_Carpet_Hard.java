package PGM_Level2;

/*
 * 2021.06.22
 * PGM 카펫 https://programmers.co.kr/learn/courses/30/lessons/42842
 * 나는 브루트포스 방식으로 풀었는데(가로세로 각각 모든 경우의 수를 다 해봄)
 * 그냥 단순 계산으로도 되는 다른 사람의 풀이도 보았다. 
 */
class PGM_Carpet_Hard {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        
        int row = 3;
        int col = 3;
        boolean isFound = false;
        while(true) {
            for(col = row; col < 2500; col++) {
                int calYellow = (row-2)*(col-2);
                int calBrown = (row*col) - calYellow;
                if(brown == calBrown && yellow == calYellow) {
                    isFound = true;
                    break;
                }
            }
            if(isFound)
                break;
            row++;
        }
        answer[0] = col;
        answer[1] = row;
        
        return answer;
    }
}

/*
 * a가 가로길이 세로길이 합이라고 한다.
 * b는  전체 타일 수 즉 brown + yellow
 * 
 */

//import java.util.*;
//class Solution {
//    public int[] solution(int brown, int red) {
//        int a = (brown+4)/2;
//        int b = red+2*a-4;
//        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
//        return answer;
//    }
//}