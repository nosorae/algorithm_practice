package PGM_Level1;


/*
 * 2021.06.20
 * PGM 신규 아이디 추천
 * 정규식을 사용하면 간단한 것을... 이렇게 했다. 정규식 풀이도 알아볼 것
 */ 

import java.util.*;

class PGM_NewIdRecommend {
    public String solution(String new_id) {
        LinkedList<Character> resultId = new LinkedList<Character>();
        
        if(new_id.length() == 0)
            new_id = "a";
        
        int len = new_id.length();
        for(int i = 0; i < len; i++) { //new_id를 한글자씩 읽는다. for문 내부에서 수정이나 제거(continue)가 일어난다.
            char cur = new_id.charAt(i); 
            
            if(cur >= 'A' && cur <= 'Z') //대문자면 소문자로 바꾼다.
                cur += 32;
            else if(cur == '.') { //'.' 을 넣을 차례고 이미 앞에 '.'이 있거나 처음이나 마지막에 등장했다면 넣지 않는다.
                if(resultId.isEmpty())
                    continue;
                if(resultId.getLast() == '.' ||  i == 0  || i == len - 1 )
                    continue;
            }
            else if(!(cur == '-' || cur == '_' || (cur >= '0' && cur <= '9') 
                    || (cur >= 'a' && cur <= 'z'))) { // 그대로 넣는 나머지 경우가 아니면 넣지 않는다.
                continue;
            }
            
            resultId.addLast(cur);
            //System.out.println(resultId.toString());
            
        }
        //위 for문에서 마지막에 .이 오는 것을 못잡은 것에 주의
       
        StringBuilder sb = new StringBuilder();
        
        // 길이 후처리
        if(resultId.size() == 0) {
            sb.append("aaa");
        }
        else if(resultId.size() <= 2) {
            
            if(!resultId.isEmpty() && resultId.getLast() == '.')
                resultId.remove(resultId.size() - 1);
            
            while(resultId.size() <= 2) {
                resultId.add(resultId.get(resultId.size() - 1));
            }
            while(!resultId.isEmpty()) {
                sb.append(resultId.remove(0));
            }
            
        }
        else {
            int i = 0;
            LinkedList<Character> temp = new LinkedList<Character>();
            while(!resultId.isEmpty()) {
                
                temp.add(resultId.remove(0));
                
                if(temp.size() >= 15)
                    break;
            
            }
            if(!temp.isEmpty() && temp.getLast() == '.') {
                temp.remove(temp.size() - 1);
                
                if(temp.size() == 2)
                    temp.add(temp.getLast());
            }
                
            
            while(!temp.isEmpty()) {
                sb.append(temp.remove(0));
            }
        }

        String answer = sb.toString();
        return answer;
    }
}