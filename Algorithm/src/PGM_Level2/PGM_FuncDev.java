package PGM_Level2;

/*
 * 2021.06.17
 * PGM 기능개발 https://programmers.co.kr/learn/courses/30/lessons/42586
 */

import java.util.*;

class PGM_FuncDev {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> ansQ = new LinkedList<Integer>();
        
        for(int i = 0; i < progresses.length; i++) {
            
            int leftProg = 100 - progresses[i];
            int leftDays = leftProg / speeds[i];
            
            if(leftProg % speeds[i] != 0)
                leftDays += 1;
            
            q.add(leftDays);
            //System.out.println(leftDays);
        }
        
        while(!q.isEmpty()) {
            int ans = 1;
            int cur = q.peek();
            q.poll();
            while(!q.isEmpty() && cur >= q.peek()) {
                q.poll();
                ans++;
            }
            ansQ.add(ans);
        }
        
        int[] answer = new int[ansQ.size()];
        int idx = 0;
        while(!ansQ.isEmpty()) {
            answer[idx] = ansQ.peek();
           
            ansQ.poll();
            idx++;
        }
        
        return answer;
    }
}