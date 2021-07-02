package PGM_Level2;

/*
 * 2021.07.02
 * PGM 방금그곡 https://programmers.co.kr/learn/courses/30/lessons/17683#
 * 정규식을 이용하면 쉬운문제 였다. 문자하나가 음하나라고 인식하는 오류를 범해서 시간이 오래걸렸다.
 * 문자두개가 음 하나가 될 수 있다.
 * 여기서 시간이든(이 문제에서는 분단위로), 문자열이든(여기서는 길이2문자열을 1로, 다른사람의 풀이보고 깨달음) 바꾸면 로직이 간소화된다는 것을 알게 되었다. 
 * 나는 시간은 분단위로 바꿨는데, 문자열은 그냥 쌩으로 했다.
 * 문자열 길이2짜리를 1로 바꾸는 법은 m = m.replaceAll("C#", "V"); 이런식으로 하면 쉬웠다.
 * 나는 그냥 플레이 시간만큼 for문으로 시간과 음정보를 이용해서 플레이된 음정보를 String으로 반환하는 함수를 만들었고
 * totalPlay.matches(".*"+m+"[^#].*") || totalPlay.matches(".*"+m) 이렇게 풀었다.
 * 그리고 답내는 부분에 꼭 집중해라. 조건일치여러개 -> 길이긴것부터, 길이같으면-> 먼저온것부터
 * 
 */

import java.util.*;
class PGM_JustNowMusic {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        HashMap<String, Integer> ans = new HashMap<>(); // 제목과 재생시간
        ArrayList<String> order = new ArrayList<>();
        for(String info : musicinfos) {
            String[] infoArr = info.split("[,:]");
            int start = Integer.parseInt(infoArr[0]) * 60 + Integer.parseInt(infoArr[1]);
            int end = Integer.parseInt(infoArr[2]) * 60 + Integer.parseInt(infoArr[3]);
            int playTime = end - start; // (음악길이)분 이 음악총시간, (끝시간 - 시작시간)분이 재생된시간
            String title = infoArr[4];
            String music = infoArr[5];
            String totalPlay = getTotalPlay(music, playTime);
            
            
            if(totalPlay.matches(".*"+m+"[^#].*") || totalPlay.matches(".*"+m)) {
                int shp = 0;
                for(int i = 0; i < totalPlay.length(); i++) {
                    if(totalPlay.charAt(i) == '#')
                        shp++;
                }
                ans.put(title, totalPlay.length()-shp);
                order.add(title);
                
            }
                
        }
        int max = 0;
        for(Map.Entry<String, Integer> e : ans.entrySet()) {
            //일치한 게 여러개라면 재생시간이 가장 긴것
            if(max < e.getValue()) {
                max = e.getValue();
                answer = e.getKey();
            }
        }
        
        //가장 긴 게 여러개라면 먼저 온 것
        for(String t : order) {
            if(max == ans.get(t)) {
                answer = t;
                break;
            }
        }
        
        if(ans.size() == 0)
            answer = "(None)";
     
        return answer;
    }
    // 시간과 음정보를 이용해서 플레이된 음정보를 String으로 반환하는 함수
    static String getTotalPlay(String music, int playTime) {
        int shp = 0;
        for(int i = 0; i < music.length(); i++) {
            if(music.charAt(i) == '#')
                shp++;
        }
        
        int len = music.length() - shp;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < playTime/len; i++) {
            sb.append(music);
        }
        int idx = 0;
        for(int i = 0; i <  playTime%len; i++) {
            if(idx < music.length())
                sb.append(music.charAt(idx++));
               
            if(idx < music.length() && music.charAt(idx) == '#')
                  sb.append(music.charAt(idx++));
        }
        
        return sb.toString();
        
    }
    
}