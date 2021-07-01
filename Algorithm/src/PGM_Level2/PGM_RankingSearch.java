package PGM_Level2;

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
 * --- 이하는 강의를 보고 생각과 코드를 바꾼 내용이다. ---
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
 * if()문 뒤에 ;찍지마... 없는 취급된다구..
 * 아 생각해보니 query개수랑 정답 개수랑 같네.. index query랑 같이 돌면서 그대로 넣어줘도 되겠다.
 */
import java.util.*;
class PGM_RankingSearch {
    public int[] solution(String[] info, String[] query) {
        //108가지 조합마다 점수리스트를 만들기 위한 초기화
        HashMap<String, Integer> idxMap = new HashMap<>(); // String을 보고 Index를 찾기위해 Map을 사용
        ArrayList<Integer>[][][][] scores = new ArrayList[4][3][3][3];
        idxMap.put("-", 0); //공통
        
        idxMap.put("java", 1); // 언어
        idxMap.put("cpp", 2);
        idxMap.put("python", 3);
        
        idxMap.put("backend", 1); // 직군
        idxMap.put("frontend", 2);
        
        idxMap.put("junior", 1); // 경력 
        idxMap.put("senior", 2);
        
        idxMap.put("chicken", 1); // 소울푸드
        idxMap.put("pizza", 2);
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        scores[i][j][k][l] = new ArrayList<Integer>();
                    }
                }
            }
        }
        
        // 주어진 info 입력에 따라 108가지 점수리스트 만들기
        for(String i : info) {
            String[] one = i.split(" ");
            int lang = idxMap.get(one[0]);
            int duty = idxMap.get(one[1]);
            int career = idxMap.get(one[2]);
            int food = idxMap.get(one[3]);
            int score = Integer.parseInt(one[4]);
           
            scores[lang][duty][career][food].add(score);
            scores[0][0][0][0].add(score);
            
            scores[0][duty][career][food].add(score);
            scores[lang][0][career][food].add(score);
            scores[lang][duty][0][food].add(score);
            scores[lang][duty][career][0].add(score);
            
            scores[0][0][career][food].add(score);
            scores[0][duty][0][food].add(score);
            scores[0][duty][career][0].add(score);
            scores[lang][0][0][food].add(score);
            scores[lang][0][career][0].add(score);
            scores[lang][duty][0][0].add(score);
            
            scores[0][0][0][food].add(score);
            scores[0][0][career][0].add(score);
            scores[0][duty][0][0].add(score);
            scores[lang][0][0][0].add(score);
        }
        
        // 이분탐색을 위한 정렬 
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        Collections.sort(scores[i][j][k][l], Collections.reverseOrder());
                    }
                }
            }
        }
        
        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            String[] one = query[i].split(" ");
            // 0 2 4 6(인덱스 쿼리) + 7(점수)
            int lang = idxMap.get(one[0]);
            int duty = idxMap.get(one[2]);
            int career = idxMap.get(one[4]);
            int food = idxMap.get(one[6]);
            //System.out.println(one[0] +" "+ one[2]+" "+one[4]+" "+one[6]+" "+one[7]);
            int score = Integer.parseInt(one[7]);
            ArrayList<Integer> list = scores[lang][duty][career][food];
            int len = list.size();
            if(len > 0 && list.get(0) >= score)
                answer[i] = binarySearch(list, score, 0, len-1);
            else //길이가 0이거나 오름차순이니 첫번째 숫자가 가장큰데 그게 기준점수보다 작다면 답은 0이다.
                answer[i] = 0;
        }
        
      
        return answer;
    }
    /*
     * 이분탐색 함수
     * 일반적인 이분탐색과는 다른 점이, 딱 찾는 게 아니라 기준 점수보다 큰 최소점수를 찾아야한다.
     * 범위가 일정 길이 이하가 되면 liear search로 찾아준다.
     * @param : ArrayList<Integer> 쿼리에 해당하는 점수들이 담긴 리스트 (내림차순임에 주의)
     * @param : score 기준점수
     * @return : 그대로 정답에 들어갈 인덱스 값
     */
    static int binarySearch(ArrayList<Integer> list, int score, int left, int right) {
        if(right - left < 5) {
            for(int i = left; i <= right; i++) {
                if(list.get(i) < score)
                    return i;
            }
            return right+1;
        }
        int mid  = (left + right) / 2;
        if(list.get(mid) < score) {
            return binarySearch(list, score, left, mid-1);
        }
        else 
            return binarySearch(list, score, mid+1, right);
    }
}