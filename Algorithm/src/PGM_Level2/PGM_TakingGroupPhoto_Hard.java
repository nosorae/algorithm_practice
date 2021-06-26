package PGM_Level2;

/*
 * 2021.06.26
 * PGM 단체사진 찍기 https://programmers.co.kr/learn/courses/30/lessons/1835
 * 조건 분석 - 알고리즘 선택 - 구조와 수도코드 - 코딩 이 순서는 잘 지켰다.
 * 시간이 오래걸린 이유는 조건 분석에서 코드로 옮길 때 발생했다. 
 * 나는 언어문법(예를 들면 indexOf charAt 이런 게 내가 생각하는 것과 달라서 답이 틀리는 줄 알았는데,
 * 알고보니 그냥 +1 하나를 안해줘서 그랬다... +1때문에 40분 날렸다. 
 * 이상과 초과, 이하와 미만의 차이를 민감하게 받아들여라.
 * 문법적으로 틀린 거에서 해메지 말고 조건을 정확히 지켰는지 1단위로 꼭 확인해서 시간낭비를 잡을 것!
 * 1시간 16분
 * 라고 말하고 풀린줄 알았는데 안되길래 논리적으로 틀린 게 없는 데 왜 틀리는지 한참을 고민하다가
 * 검색해서 알아낸 사실인데 이 문제는 count를 전역변수로 사용하면 클래스안에서 초기화를 해줘야한단다..
 * (전역변수 초기화 정보 출처) https://fbtmdwhd33.tistory.com/252 
 * 배열을 String으로 만드는 법 new String(char[]);
 */ 

//간격은 두 프렌즈 사이에 있는 다른 프렌즈의 수
// 조건을 만족하게 서는 경우의 수 계산 
// 8! = 40320 이라 여기에 100곱하면 최대 약 400*8만의 연산으로 조건확인이 가능하다.
// 재귀로 모든 경우의 수를 다 해보고, 깊이가 8일 때 조건함수로 확인하고 탈출 

class Solution {
    static String[] cond;
    static int len;
    static int answer = 0;
    static final int FRIENDNUM = 8;
    static char[] place = new char[8];
    static boolean[] check = new boolean[FRIENDNUM];
    static final char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] data) {
        answer = 0;
        len = n;
        cond = data;
        placeAll(0);
    
        return answer;
    }
    
    static void placeAll(int deep) {
        if(deep == FRIENDNUM) {
            if(checkCondition(new String(place))) 
                answer++;
            return;
        }
        for(int i = 0; i < FRIENDNUM; i++) {
            if(!check[i]) {
                place[deep] = friends[i];
                check[i] = true;
                placeAll(deep+1);
                check[i] = false;
            }
        }
    }
    
    static boolean checkCondition(String placing) {
        for(int i = 0; i < cond.length; i++) {
            //파싱
            char f1 = cond[i].charAt(0);
            char f2 = cond[i].charAt(2);
            int fIdx1 = placing.indexOf(f1);
            int fIdx2 = placing.indexOf(f2);
            char comp = cond[i].charAt(3);
            int num = (int)(cond[i].charAt(4) - '0');
            
            switch(comp) {
                case '=':
                    if(abs(fIdx1, fIdx2) != num+1)
                        return false;
                    break;
                case '>':
                    if(abs(fIdx1, fIdx2) < num+2)
                        return false;
                    break;
                case '<':
                    if(abs(fIdx1, fIdx2) > num)
                        return false;
            }
        }
        return true;
    }
    
    static int abs(int a, int b) {
        if(a > b)
            return a - b;
        else
            return b - a;
    }
    
}