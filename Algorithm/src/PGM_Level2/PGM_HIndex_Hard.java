package PGM_Level2;

import java.util.*;

/*
 * 2021.06.22
 * PGM H-Index https://programmers.co.kr/learn/courses/30/lessons/42747#
 * 일단 내가 푼 방식은 인용수 기준으로 정렬해서 큰 것부터 확인해서 인덱스(즉 지금까지 지나간 논문 수)와 비교해서 
 * 찾으면 더 찾았을 때의 인용수-1까지 ++해보고, 만약 못찾았다면 모든 논문의 인용수들이 논문의 수보다 큰 것이므로 논문의 갯수가 답
 * 더 깔끔한 다른 사람의 풀이가 아래 있다. 
 * 인용수 기준으로 정렬해서 인용수 큰 것부터 확인하며 인용수와 지나온 논문을 제외한 논문의 수를 비교해서 작은 것이 답 후보가되고
 * 그중에서 최대값이 답이된다.
 */

class PGM_HIndex_Hard {
    public int solution(int[] citations) {
              
        int len = citations.length;
        Integer[] cit = new Integer[len];
        for(int i = 0; i < len; i++) 
            cit[i] = citations[i];
        Arrays.sort(cit, Collections.reverseOrder());
        // 1000 1000 1000 1000 1 0 =>  4
        int answer = 0;
        int curH = 0;
        int idx = 0;
        for(int i = 0; i < len; i++) {
            int h = cit[i];
            if(i+1 >= h) {
                curH = h;
                idx = i;
                break;
            }
        }
             
        
        while(curH < idx) {
            curH++;    
        }
        
        answer = curH;
        // if(len == 1 && cit[0] > 1)
        //     answer = 1;
        if(idx == 0) { //위 for문에서 못찾은 경우 예외처리
            answer = len;
            if(cit[0] == 0)
                answer = 0;
        }
            
        
        return answer;
    }
}


// import java.util.*;

// class Solution {
//     public int solution(int[] citations) {
//         Arrays.sort(citations);

//         int max = 0;
//         for(int i = citations.length-1; i > -1; i--){
//             int min = (int)Math.min(citations[i], citations.length - i);
//             if(max < min) max = min;
//         }

//         return max;
//     }
// }