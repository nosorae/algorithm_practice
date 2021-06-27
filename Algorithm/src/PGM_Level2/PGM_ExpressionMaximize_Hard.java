package PGM_Level2;

/*
 * 2021.06.27
 * PGM 수식 최대화 https://programmers.co.kr/learn/courses/30/lessons/67257
 * 어떤 숫자가 올지 모르고 다해봐도 최대 3! * 100 정도밖에 안되므로 브루트포스로 해결
 * 연산자 3개의 우선순위를 커스텀하는 계산기를 구현하는 게 이 문제의 핵심인듯 하다.
 * 우선순위 커스텀한 후위표기법으로 변환 -> 계산
 * 모든 경우 다해보기 : 재귀함수 (placeAll)
 * 후위표기법으로 변환 : 숫자는 그냥 넣고, 연산자는 스택에 넣는데, 우선순위 높은 연산자들은 스택에서 뺀다.(makePostfix)
 * 계산 : 후위표기법을 그대로 계산 (calcPostfix)
 * 주의 : split 쓸때는 내 의도와 맞는지 출력해보자 돌다리도 두들기고 건너!
 */
import java.util.*;
class PGM_ExpressionMaximize_Hard {
    static long max = 0;
    static char[] opSet = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static int[] priority = new int[46];
    public long solution(String expression) {
        max = 0;
        placeAll("", expression);
        long answer = max;
        return answer;
    }
    static Queue<String> makePostfix(String exp) {
        String[] operands = exp.split("[-*+]");
        String[] operators = exp.split("[0-9]+"); //이렇게 하면 맨 앞에 ""(빈문자열)이 들어간다.
        
        Stack<String> opStack = new Stack<String>();
        Queue<String> ans = new LinkedList<String>();
        for(int i = 0; i < operands.length-1; i++) {
            String operand = operands[i];
            char op = strToChar(operators[i+1]); //따라서 +1
            ans.add(operand);
            while(!opStack.isEmpty() && priority[strToChar(opStack.peek())] >= priority[op]) {
                ans.add(opStack.pop());
            }
            opStack.add(op+"");
        }
        ans.add(operands[operands.length-1]);
        while(!opStack.isEmpty()) {
            ans.add(opStack.pop());
        }
        
        return ans;
    }
    static char strToChar(String s) {
        char c = '*';
        switch(s) {
            case "-":
                return '-';
            case "+":
                return '+';
            case "*":
                return '*';
        }
        return c;
    }
    static long calcPostfix(Queue<String> exp) {
        Stack<Long> result = new Stack<Long>();
        while(!exp.isEmpty()) {
            String cur = exp.poll();
            
            if(cur.equals("+") || cur.equals("-") || cur.equals("*")) {
                long ord1 = result.pop();
                long ord2 = result.pop();
                switch(cur) {
                    case "+":
                        result.add(ord2 + ord1);
                        break;
                    case "-":
                        result.add(ord2 - ord1);
                        break;
                    case "*":
                        result.add(ord2 * ord1);
                }
            }
            else {
                result.add(Long.parseLong(cur));
            }
        }
        return result.pop();
    }
    static void placeAll(String pri, String exp) {
        if(pri.length() == 3) {
            char first = pri.charAt(0);
            char second = pri.charAt(1);
            char third = pri.charAt(2);
            priority[first] = 3;
            priority[second] = 2;
            priority[third] = 1;
            Queue<String> expQ = makePostfix(exp);
            long localAns = calcPostfix(expQ);
            if(localAns < 0)
                localAns = -localAns;
            if(max < localAns)
                max = localAns;
            
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(!check[i]) {
                check[i] = true;
                placeAll(pri+opSet[i], exp);
                check[i] = false; 
            }
            
        }
    }
}