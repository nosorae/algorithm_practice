package PGM_Level2;


import java.util.*;

class PGM_Printer {
    public int solution(int[] priorities, int location) {
        int len = priorities.length;
        int popCnt = 0;

        // 큐에 넣으며 max 초기화
        Queue<Doc> q = new LinkedList<Doc>();
        int[] maxArr = new int[10];


        for(int i = 0; i < len; i++) {
            int priority = priorities[i];
            q.add(new Doc(i, priority));
            maxArr[priority]++;
        }

        int maxIdx = 9;
        int answer = 0;
        while(!q.isEmpty()) {

            while(maxIdx >= 1 && maxArr[maxIdx] == 0) // 현재 max 갱신
                maxIdx--;

            if(q.peek().pri < maxIdx) { // 현재 max보다 작다면 앞으로 빼서 뒤로 넣기
                q.add(q.poll());
            }
            else {
                answer++;
                maxArr[maxIdx]--;
                if(location == q.peek().waitN) 
                    break;
                q.poll();
            }
        }


        return answer;
    }
}

class Doc {
    int waitN;
    int pri;
    public Doc(int w, int p) {
        waitN = w;
        pri = p;
    }
}