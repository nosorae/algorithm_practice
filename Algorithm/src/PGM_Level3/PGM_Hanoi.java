package PGM_Level3;

/*
 * 2021.06.23
 * PGM 하노이의 탑
 * 기존 하노이의 출력을 배열에 넣어주는 작업만 했다.
 */
import java.util.*;

class PGM_Hanoi {
    static LinkedList<Moving> moving;
    public int[][] solution(int n) {
        moving = new LinkedList<Moving>();
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[moving.size()][2];
        for(int i = 0; i < moving.size(); i++) {
            answer[i][0] = moving.get(i).prev;
            answer[i][1] = moving.get(i).next;
        }
        return answer;
    }
    static void hanoi(int n, int a1, int a2, int a3) { // n개만큼 1에서 2를 거쳐서 3
        if(n == 1) {
            moving.add(new Moving(a1, a3));
            return;
        }                                           
        hanoi(n-1, a1, a3, a2);
        moving.add(new Moving(a1, a3));
        hanoi(n-1, a2, a1, a3);
    }
}
class Moving {
    int prev;
    int next;
    public Moving(int p, int n) {
        prev = p;
        next = n;
    }
}