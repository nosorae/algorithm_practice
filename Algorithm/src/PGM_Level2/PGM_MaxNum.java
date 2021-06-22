package PGM_Level2;


import java.util.*; 
/*
 * 2021.06.22
 * PGM 가장 큰 수 https://programmers.co.kr/learn/courses/30/lessons/42746#
 * 문제 풀기 전에 모든 예시 다 해석해보고 문제 정확히 파악하고 코딩 들어가자...!
 * 두자리 이상숫자는 한자리로 따로 뗄 수 있는 줄 알고 문제 풀었다가 삽질함
 * 레퍼클래스 중에 Integer 배열의 초기변수는 null이구나..!
 * 0예외처리 교훈!!!
 */
class PGM_MaxNum {
    public String solution(int[] numbers) {
        
        int len = numbers.length;
        Integer[] result = new Integer[len];
        
        for(int i = 0; i < len; i++)
            result[i] = numbers[i];
        
        Arrays.sort(result, new MyComparator());
            
        if(result[0] == 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(int num : result) {
            sb.append(num);
        }
       
        String answer = sb.toString();
        return answer;
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        StringBuilder str1 = new StringBuilder(o1+"");
        StringBuilder str2 = new StringBuilder(o2+"");
        str1.append(o2+"");
        str2.append(o1+"");
        
        //return str2.toString().compareTo(str1.toString());
        return Integer.parseInt(str2.toString()) - Integer.parseInt(str1.toString());
        
        
    }
    
}