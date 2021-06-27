package PGM_Level2;

/* 
 * 2021.06.27
 * PGM 오픈채팅방 https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
 * 1-100,000
 * Enter, Change, Leave 명령어, uid, 이름(중복가능) 세가지로 이루어진 record
 * uid로 사람을 조회한다. -> 즉 uid는 중복x이므로 Set으로 관리
 * uid가 key, nick이 value인 Map과, order와 uid를 담는 리스트를 만들어준다.
 * Map에 uid가 없는데 order가 Enter면 Map uid에 nick 넣어주고 리스트에 추가,
 * Map에 있는데 Enter면 Map에서 uid로 nick만 바꿔주고 리스트에 추가,
 * Change면 Map에서 uid로 name만 바꿔주고
 * Leave면 리스트에 추가한다.
 * 위 과정을 끝내면 명령어와 uid를 담은 리스트를 보고 최종 정답을 만들어준다.
 * 44분
 */
import java.util.*;
class PGM_OpenChatting {
    public String[] solution(String[] record) {
        HashMap<String, String> uidMap = new HashMap<String, String>();
        ArrayList<Order> orderList = new ArrayList<Order>();
        ArrayList<String> ansList = new ArrayList<String>();
        
        for(int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String order = st.nextToken();
            String uid = st.nextToken();
            String nick = "";
            if(!order.equals("Leave"))
                nick = st.nextToken();
            switch(order) {
                case "Enter":
                    uidMap.put(uid, nick);
                    orderList.add(new Order(order, uid));
                    break; 
                case "Change":
                    uidMap.put(uid, nick);
                    break;
                case "Leave":
                    orderList.add(new Order(order, uid));
            }
        }
        for(int i = 0; i < orderList.size(); i++) {
            String nick = uidMap.get(orderList.get(i).uid);
            String order = orderList.get(i).order;
            String localAns = nick+"님이 ";
            if(order.equals("Enter"))
                localAns += "들어왔습니다.";
            else
                localAns += "나갔습니다.";
            ansList.add(localAns);
        }
        String[] answer = ansList.toArray(new String[ansList.size()]);
        return answer;
    }
}
class Order {
    String order;
    String uid;
    public Order(String o, String u) {
        order = o;
        uid = u;
    }
}