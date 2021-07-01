package Unsolved;

/*
 * 언어 선택, 백 프론트 선택, 주니어 시니어 선택, 치킨 피자 선택
 * 정보는 5만 쿼리는 10만
 * 쿼리각각을 매번 정보확인에 쓴다면??  500000만으로 숫자가 너무 큼
 * 따라서 모든 경우의 수의 숫자를 미리 구해놓으면 된다. 
 * 4 * 3 * 3 * 3 = 108가지 근데 또 점수가 문제네..
 * 그럼 클래스를 만들고 Map<String, Set<Candidate>>을 각 선택별로 만들어서 저장하는 것은 어떤가?? 
 * 그럼 하나의 쿼리요소마다 교집합하면 답이 나온다. retainAll의 시간복잡도는??
 * 아마도 O(N)일 확률이 높다. 
 * 이거 만드는데 20만 밖에 안든다. 그리고 교집합 연산 4번으로 답을 구할 수 있다.
 * 시간초과가 났는데 NlogN으로 미리 각각 정렬하고 교집합 하고
 * logN으로 기준점수 찾고 전체인덱스 - 기준인덱스 + 1 하면 더 빨리 구할 수 있다.
 * --- 이하는 강의를 보고 생각을 바꾼 내용이다. ---
 * 나는 문제에서 원하는 결과만 내주면 된다.
 * 문제에서 원하는 결과는 점수 이전까지의 쿼리에 맞는 참가자들을 알고 
 * 그중에서 해당 점수 이상의 참가자들이 몇명인지만 알면된다.
 * 즉 점수와 몇명인지만 알면 된다는 것.
 * 즉 점수 리스트만 있고 정렬되어있다면 logN으로 몇명인지 찾을 수 있다. 
 * 문제에서 쿼리가 info는 5만밖에 안되고 query가 10만이나 됐을 때부터 눈치를 챘어야했다.
 * 108가지 미리 구해놔야한다는 것까지는 생각이 닿았는데 어떻게 구현할지 막막했다.
 * 강의에 나온 방식으로 ArrayList<Integer>의 4차원배열 만들고 HashMap<쿼리요소, 인덱스>로 인덱스를 찾아서
 * 해당 ArrayList에는 점수만 넣어주면된다!!!
 * 결국 다시 말하지만 문제에서 원하는 정답을 내려면 핵심적으로 필요한 게 무엇인지 생각해보고 
 * 그것만 구하면 된다는 마인드로 문제풀이의 실마리를 잡아야한다. 그 이외의 정보는 불필요하다.
 */
import java.util.*;
class PGM_RankingSearch {
    public int[] solution(String[] info, String[] query) {
        HashMap<String, TreeSet<Candidate>> map = new HashMap<>();
        HashMap<String, TreeSet<Candidate>> cache = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < info.length; i++) {
            String[] oneInfo = info[i].split("\\s");
            Candidate cur = new Candidate(i,
                                         oneInfo[0],
                                         oneInfo[1],
                                         oneInfo[2],
                                         oneInfo[3],
                                         Integer.parseInt(oneInfo[4]));
            for(int j = 0; j < oneInfo.length - 1; j++) {
                String key = oneInfo[j];
                if(!map.containsKey(key)) {
                    map.put(key, new TreeSet<Candidate>());
                    map.get(key).add(cur);
                }
                else
                    map.get(key).add(cur);
            }  
        }
        TreeSet<Candidate> queAllSet = new TreeSet<Candidate>();
        for(TreeSet<Candidate> s : map.values()) 
            queAllSet.addAll(s);
        
            
        
        for(int i = 0; i < query.length; i++) {
          
            String[] oneQ = query[i].split("\\s");
            String cacheKey = oneQ[0]+oneQ[2]+oneQ[4]+oneQ[6];
            
            if(cache.containsKey(cacheKey)) { // 점수를 제외한 네가지 쿼리를 캐싱해둔다.
                int cutLine = Integer.parseInt(oneQ[oneQ.length - 1]);
                int cnt = 0;
                for(Candidate c : cache.get(cacheKey)) {
                    if(c.score < cutLine)
                        break;
                    cnt++;
                }
                ans.add(cnt); 
                continue; // 이 아래는 자연스럽게 캐시에 없는 점수 제외한 네가지 쿼리이다.
            }
            TreeSet<Candidate> queSet = new TreeSet<Candidate>(queAllSet);
            for(int j = 0; j < oneQ.length-1; j++) {
                if(oneQ[j].equals("and")) continue;
                if(oneQ[j].equals("-"))  continue;
                
                if(map.containsKey(oneQ[j]))
                    queSet.retainAll(map.get(oneQ[j]));
                else {
                    queSet.clear(); 
                    break;
                }
            }
            
            int cutLine = Integer.parseInt(oneQ[oneQ.length - 1]);
            int cnt = 0;
            for(Candidate c : queSet) {
                if(c.score < cutLine) 
                    break;
                cnt++;
                    
            }
            ans.add(cnt); 
            cache.put(cacheKey, queSet);
        }
        
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
            //System.out.println(answer[i]);
        }
        
        return answer;
    }
}
class Candidate implements Comparable<Candidate> {
    int id;
    String language;
    String position;
    String career;
    String soulFood;
    int score;
    public Candidate(int i, String l, String p, String c, String s, int sc) {
        id = i;
        language = l;
        position = p;
        career = c;
        soulFood = s;
        score = sc;
    }
    public String toString() {
        return (id+1)+" "+language+" "+position+" "+career+" "+soulFood+" "+score;
    }
    public int compareTo(Candidate o) {
        return o.score - this.score;
    }
     
}