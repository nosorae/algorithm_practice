package PGM_Level2;

/*
 * 2021.07.01
 * PGM 캐시 https://programmers.co.kr/learn/courses/30/lessons/17680
 * LRU니까 캐시가 꽉찼을 때 가장 오래된 것이 나가야하므로 큐를 써야할 것 같다.
 * 문제는 큐에 contains함수가 O(N)이라서 총 N^2이 되어 시간초과가 날 수도 있다.
 * 그래서 포함 여부는 HashSet으로 관리한다.
 * LinkedList<Integer>에서 remove할 때 객체인지 인덱스인지 어떻게 알아?
 * Set<String>은 자동으로 대소문자 구분해주나??
 * 캐시사이즈 0일 때 경계처리도 미리 생각했어야한다. 예제로 안줬으면 시간낭비할뻔!
 * 24분
 */
import java.util.*;
class PGM_LRUCache {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length * 5;
        
        int answer = 0;
        LinkedList<String> cache = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
       
        
        for(String city : cities) {
            city = city.toLowerCase();
            if(set.contains(city)) {
                answer++;
                cache.remove(city);
                cache.addLast(city); //쓰였으면 맨 뒤로 보내준다.
            }
            else {
                answer += 5;
                if(cache.size() == cacheSize) { 
                    // 캐시가 꽉차면 첫번째 거 빼주고
                    set.remove(cache.removeFirst());
                }
                //새로운 것을 set과 queue에 추가해준다.
                set.add(city);
                cache.addLast(city);
            }
            //System.out.print(answer+" ");
        }
        return answer;
    }
}