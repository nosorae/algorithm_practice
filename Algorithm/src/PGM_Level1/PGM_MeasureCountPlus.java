package PGM_Level1;

/*
 * 2021.06.23
 * PGM 약수의 개수와 덧셈 https://programmers.co.kr/learn/courses/30/lessons/77884
 * 내가 당장생각나는 풀이방법은 연산이 대략 최대 100만인데 더 효율적인 방법이 있을듯 하다
 * 예외처리 하나 안했어서 틀렸다. 항상 경계에서 예외를 생각하라!
 */
class PGM_MeasureCountPlus {
    public int solution(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            if(oddEven(i))
                sum += i;
            else 
                sum -= i;
        }
        return sum;
    }
    static boolean oddEven(int n) { // false면 홀 true면 짝
        if(n == 1)
            return false;
        
        int cnt = 2; // 1과 자신 두개니 true
        for(int i = 2; i < n; i++) {
            //1과 자신을 제외한 모든 수로 약수인지 확인
            if(n % i == 0)
                cnt++;
        }
        if(cnt % 2 ==  0) return true;
        else return false;
    }
}