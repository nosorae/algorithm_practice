package PGM_Level2;

/*
 * 2021.07.02
 * PGM 후보키 https://programmers.co.kr/learn/courses/30/lessons/42890#
 * 모든 공집합을 제외한 모든 원소의 부분집합을 검사해봐야한다. 
 * 모든 1~(1<<N)범위의 모든 숫자로 시도해보며 비트가 1인 열의 조합으로 후보키 가능 여부를 시도해야한다.  
 * 지금 1~(1<<N)범위에서 K를 검사하고 있다고 가정해보자 
 * 그러면 작은 것부터 후보키 가능한 것을 집합에 넣고 새로운 것 검사할 때 검사하기 전에 set 전체를 돌며 확인한다.
 * 최소성 -> 유일성 함수 각각 만들기
 * 이 문제를 비트로 풀면 편한점은 최소성 검사에 있다.
 * 0011 1011 1001 1000 
 * 3 11 9 8
 */
import java.util.*;
class PGM_CandidateKey {
    static String[][] input;
    public int solution(String[][] relation) {
        input = relation;
        int answer = 0;
        int len = input[0].length; // 열 개수
         HashSet<Integer> set = new HashSet<Integer>(); // 이미 후보키로 확인된 집합
         
        for(int i = 1; i < (1<<len); i++) { 
            ArrayList<Integer> list = new ArrayList<Integer>(); // 열 인덱스
            String bin = Integer.toBinaryString(i);
            
            for(int j = bin.length() - 1 ; j >= 0 ; j--) { // 이 부분에서 실수가 있었다.
                if(bin.charAt(j) == '1') {
                    list.add(bin.length() -1 - j);
                }
            }

            if(!isMinimal(set, i))
                continue;
            
            if(isUnique(list)) {
                answer++;
                set.add(i);
            }
        }
        
        return answer;
    }
    static boolean isUnique(ArrayList<Integer> list) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < input.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < list.size(); j++) {
                sb.append(input[i][list.get(j)]);
            }
            String cur = sb.toString();
            
            if(set.contains(cur))
                return false;
            else
                set.add(cur);
        }
        return true;
    } 
    static boolean isMinimal(HashSet<Integer> set, int cur) {
        for(int s : set) {
            int temp = (s & cur);
            if((s^temp) == 0) // set에있는 정수의 모든 비트를 포함하고 있는 경우
                return false;
        }
        return true;
    }
}