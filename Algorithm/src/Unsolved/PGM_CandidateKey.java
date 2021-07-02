
package Unsolved;

/*
 * 테이블이 주어졌을 때 후보키 개수 구하는 문제 
 * col이 최대 8밖에 안되므로 모든 조합을 다 해볼 수 있다. 
 * 그래서 1개부터 8개인 경우까지 다 조합해보는 함수가 필요하다. 인자는 몇개뽑을지, 인덱스만 있으면 될듯
 * (8C1 + 8C2 + ... + 8C8)*20 이렇게 될 듯 하다. 
 * 그리고 각 조합마다 후보키가 될 수 있는지 검사해주는 함수도 필요하다.
 * 여기서 문제는 최소성을 만족시켜주어야한다는 것인데 예를들어 12도 후보키이고 123도 후보키일 순 없고 12만 후보키이다.
 * 따라서 check배열을 만들어서 이미 후보키에 포함된 적이 있는 컬럼은 건드리지 않는다. 즉 백트래킹한다.
 */
import java.util.*;
class Solution {
    static int[] idxArr = new int[8];
    static int COLS; //열개수
    static int cnt; // 정답
    static HashSet<String> check = new HashSet<>();
    
    public int solution(String[][] relation) {
        COLS = relation[0].length;
        cnt = 0;
        
        for(int i = 1; i <= COLS; i++) {
            findAllCombination(relation, i, 0, 0);
        }
        int answer = cnt;
        return answer;
    }

    static void findAllCombination(String[][] relation, int n, int idx, int start) {
        
        
        
        
        if(idx == n) {
            
            
            boolean flag = true;
            //만들어볼 수 있는 것 조합으로 검사
            //System.out.println(check.toString());
            for(int j = 0; j <= idx-1; j++) {
                for(int k = j+1; k <= idx; k++) {
                    //System.out.println(n+"개 뽑기에서 "+intArrToString(j, k)+" ("+j+", "+k+")");
                    if(check.contains(intArrToString(j, k)))
                        flag = false;
                }
            }
            if(!flag) {System.out.println(intArrToString(0, idx)+"포함은 최소성을 만족시키지 못해 후보키가 될 수 없습니다. 돌아갑니다"); return;}
           
            if(checkCandidate(relation, idx)) {  //검사
                cnt++;
                check.add(intArrToString(0, idx)); //후보키가 된 컬럼은 다른 조합으로 후보키가 될 수x
                //System.out.println(check.toString());
                System.out.println(intArrToString(0, idx)+"는 후보키가 될 수 있습니다.");
            }
            else {
                System.out.println(intArrToString(0, idx)+"는 유일성을 만족시키지 못해 후보키가 될 수 없습니다. 돌아갑니다");
            }
                
            return;
        }
        
        
        
        for(int i = start; i < COLS; i++) {
            idxArr[idx] = i;
            //System.out.println(n+"개 뽑기에서 "+intArrToString(0, idx+1)+" 시도해봅니다.");
            findAllCombination(relation, n, idx+1, i+1);
                
            // else
            //     System.out.println(n+"개 뽑기에서 ["+intArrToString(0, idx+1)+"]은 이미 set에 있습니다.");
        }
    
    }
    static boolean checkCandidate(String[][] relation, int len) {
        //해당 컬럼들의 조합에서 중복되는 것이 없으면 true 있으면 false
        HashSet<String> set = new HashSet<>();
        for(String[] relat : relation) {
            String localKey = "";
            for(int i = 0; i < len; i++) {
                localKey = localKey + relat[idxArr[i]];
            }
            //System.out.println(localKey);
            if(set.contains(localKey))
                return false;
            else
                set.add(localKey);
        }
        return true;
    }
    
    static String intArrToString(int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < end; i++)
            sb.append(idxArr[i]+"");
        return sb.toString();
    }
    
}