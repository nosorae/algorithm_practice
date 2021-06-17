package PGM_Level1;



/*
 * 21.06.17
 * 프로그래머스 수포자 https://programmers.co.kr/learn/courses/30/lessons/42840
 * 1번은 12345 반복
 * 2번은 21232425 반복
 * 3번은 3311224455 반복
 * 효율적으로 푸는 방법?  클래스를 만들어서 학번과 
 * int b = (5 < 4) ? 50 : 40; 삼항연산자 형식
 * new int[] {} 배열 초기화 방법
 * 최고점수 할때 max 함수 만들어서 중첩해서 두번쓰는 방법 -> 맥스 구해놓고 맥스와 같은 숫자 갯수 찾아서 
 */
class PGM_MathGiveUp {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] ansCnt = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == student1[i%student1.length]) 
                ansCnt[0]++;
            if(answers[i] == student2[i%student2.length])
                ansCnt[1]++;
            if(answers[i] == student3[i%student3.length])
                ansCnt[2]++;
        }
      
        
        int[] answer = {};
        
        //1등이 세명인 경우
        if(ansCnt[0] == ansCnt[1] && ansCnt[1] == ansCnt[2]) 
            answer = new int[] {1, 2, 3};
        
        //1등이 두명인 경우
        else if(ansCnt[1] == ansCnt[2] && ansCnt[2] > ansCnt[0]) 
            answer = new int[] {2, 3};
        
        else if(ansCnt[0] == ansCnt[1] && ansCnt[1] > ansCnt[2])
            answer = new int[] {1, 2};
        
        else if(ansCnt[0] == ansCnt[2] && ansCnt[2] > ansCnt[1])
            answer = new int[] {1, 3};
        
        //1등이 한명인 경우
        else {
            int max = 0;
            int winner = 0;
            if(ansCnt[0] > ansCnt[1]){
                max = ansCnt[0];
                answer = new int[] {1};
           }
            else {
                max = ansCnt[1];
                answer = new int[] {2};
            }
                
            if(ansCnt[2] > max) {
                max = ansCnt[2];
                answer = new int[] {3};
            }
            
        }
        
        
        return answer;
    }
}

