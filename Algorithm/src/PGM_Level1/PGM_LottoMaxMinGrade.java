package PGM_Level1;


/*
 * 2021.06.19
 * PGM 로또의 최고 순위와 최저 순위 https://programmers.co.kr/learn/courses/30/lessons/77484
 * 마지막 결과에서 좋은 등수를 먼저 써줘야한다는 것을 신경안써서 시간 잡아먹음
 */
class PGM_LottoMaxMinGrade {
    static final int[] grade = {6, 6, 5, 4, 3, 2, 1};
    public int[] solution(int[] lottos, int[] win_nums) {
        
        boolean[] exist = new boolean[46];
        int zeroCnt = 0;
        
        //등장한 숫자와 0의 갯수 체크
        for(int i = 0; i < lottos.length; i++) {
            exist[lottos[i]] = true;
            if(lottos[i] == 0)
                zeroCnt++;
        }
        
        //당첨숫자배열에 해당하는 숫자가 몇개있는지 카운트
        int eqCnt = 0;
        for(int i = 0; i < win_nums.length; i++) {
            if(exist[win_nums[i]])
                eqCnt++;
        }
        
        
        //최대 최소 입력
        int[] answer = new int[2];
        answer[0] = grade[eqCnt+zeroCnt];
        answer[1] = grade[eqCnt];
        
        return answer;
    }
}