package PGM_Level2;


/*
 * 2021.06.22
 * PGM 타겟넘버 https://programmers.co.kr/learn/courses/30/lessons/43165
 * 나는 브루트포스로 풀었다. 2^20 약 100만? 밖에 되지 않기 때문이다.  
 * 이걸 어떻게 dfs/bfs로 풀지 알아봐야겠다. 이 풀이도 dfs로 봐야하는 건가??
 * 어쨌든 다른사람풀이 보니 나는 cnt를 전역변수로 뒀는데 답을 찾으면 1을 return하고 아니면 0을 리턴해서
 * return 함수(-로 넣기) + 함수(+로 넣기)로 리플전달한  
 */

class PGM_TargetNumber {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        searchAll(numbers, target, 0, numbers[0]);
        searchAll(numbers, target, 0, -numbers[0]);
        int answer = cnt;
        return answer;
    }
    static void searchAll(int[] numbers, int target, int curIdx, int cur) {
        if(curIdx == numbers.length - 1 && cur == target)
            cnt++;
        
        if(curIdx+1 < numbers.length) {
            searchAll(numbers, target, curIdx+1, cur+numbers[curIdx+1]);
            searchAll(numbers, target, curIdx+1, cur-numbers[curIdx+1]);
        }
            
    }
}

//class Solution {
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//        answer = dfs(numbers, 0, 0, target);
//        return answer;
//    }
//    int dfs(int[] numbers, int n, int sum, int target) {
//        if(n == numbers.length) {
//            if(sum == target) {
//                return 1;
//            }
//            return 0;
//        }
//        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
//    }
//}