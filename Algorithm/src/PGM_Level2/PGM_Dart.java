package PGM_Level2;


/*
 * 2021.07.01
 * PGM 다트 https://programmers.co.kr/learn/courses/30/lessons/17682
 * 3번의 기회, 각 1 2 3제곱
 * 스타상은 현재+전점수의 두배, 아차상은 현점수만 마이너스로 들어간다.
 * 스타상은 첫번째에 나오면 첫번째에만 적용됨(전점수가 없으니까!)
 * 스타상은 스타상과 중첩되면 네배, 아차상과 중첩되면 -두배
 * 코드 깔끔하게 만들어볼 것 정규식도 더 적용해봐
 * 42분
 */
class PGM_Dart {
    public int solution(String dartResult) {
        
        String[] numberStr = dartResult.split("[SDT][*#]*");
        int d1 = Integer.parseInt(numberStr[0]);
        int d2 = Integer.parseInt(numberStr[1]);
        int d3 = Integer.parseInt(numberStr[2]);
        int[] nums = new int[4];
        nums[1] = d1;
        nums[2] = d2;
        nums[3] = d3;
        
        int idx = 1; //보너스 점수를 먼저 적용한다.
        for(int i = 0; i < dartResult.length(); i++) {
            char cur = dartResult.charAt(i);
            if(cur == 'S') 
                idx++;
            if(cur == 'D') {
                nums[idx] = nums[idx] * nums[idx];
                idx++;
            }
            if(cur == 'T') {
                nums[idx] = nums[idx] * nums[idx] * nums[idx];
                idx++;
            }
               
        }
        
        int answer = 0;
        String[] optionStr = dartResult.split("[0-9]+[SDT]");
        for(String s : optionStr)
            System.out.println("->"+s);
        for(int i = 1; i < optionStr.length; i++) {
            if(optionStr[i].equals("*")) {
                nums[i] *= 2;
                if(idx-1 >= 0)
                    nums[i-1] *= 2;
            }
            if(optionStr[i].equals("#")) {
                nums[i] = -nums[i];
            }
        }

        return nums[1]+nums[2]+nums[3];
    }
}