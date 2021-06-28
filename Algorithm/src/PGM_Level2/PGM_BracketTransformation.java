package PGM_Level2;

/*
 * 2021.06.28
 * PGM 괄호 변환 https://programmers.co.kr/learn/courses/30/lessons/60058
 * 개수만 맞으면 균형잡힌이고, 짝도 맞아야 올바른임
 * 균형만잡힘 => 올바른  변환
 * 일단 균형인지아닌지, 올바른인지 아닌지 판단하는 함수 두 개 만들자
 * u와 v를 분리하기 위해 u를 찾는 함수도 만들자
 */
import java.util.*;
class PGM_BracketTransformation {
    public String solution(String p) {
        if(isPerfect(p))
            return p;
        
        String answer = makePerfectBracket(p);
        return answer;
    }
    
    static String makePerfectBracket(String p) {
        if(p.equals(""))
            return "";
        //이분할건데 둘 다 균형잡히게 최소 u와 나머지 v를 분리
        int idx = findLeftString(p);
        String u = p.substring(0, idx);
        String v = "";
        if(idx < p.length())
            v = p.substring(idx, p.length());
        
        if(isPerfect(u))
            return u + makePerfectBracket(v);
        else {
            String localAns = "(" + makePerfectBracket(v) + ")";
            StringBuilder sb = new StringBuilder(localAns);
            for(int i = 1; i < u.length()-1; i++) {
                if(u.charAt(i) == ')')
                    sb.append("(");
                else
                    sb.append(")");
            }
            return sb.toString();
        }
        
    }
    static boolean isBalanced(String p) {
        int sum = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(')
                sum++;
            else
                sum--;
        }
        return sum == 0;
    }
    static boolean isPerfect(String p) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
            }
            else
                stack.push(p.charAt(i));
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    static int findLeftString(String p) {
        int sum = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == ')')
                sum--;
            else
                sum++;
            if(sum == 0)
                return i+1;
        }
        return p.length();
    }
}