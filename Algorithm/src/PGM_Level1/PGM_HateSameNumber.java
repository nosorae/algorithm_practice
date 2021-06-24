package PGM_Level1;

/*
 * 2021.06.23
 * PGM 같은 숫자는 싫어 https://programmers.co.kr/learn/courses/30/lessons/12906
 * 문제 똑바로 읽어라..!!!!!!!! 이전 풀었던 문제 대입해서 읽지 말고 태어나서 문제 처음 풀어본다는 마인드로 문제 읽어라
 * 나는 중복만 제거하면 되는 줄 알았는데, 연속한 것만 하나로 만드는 문제였다.
 * 시간초과?? LinkedList를 옮기는데 0, 1, 2, ... n까지 돌리며 조회하니 n^2이나지... 이런 조회는 ArrayList가 1로 빠르다
 * size()함수는 삭제하면서 줄어들 수 있으니 반복문에서 사용을 주의해야한다구!!
 * ArrayList는 배열 하나만 관리 그리고 삭제, 중간삽입이 느리고 조회(*), 끝삭제, 끝삽입(확장 제외)은 매우 빠르다. 
 * 근데 LinkedList는 노드(data, pointer(* 2)) 관리하는 오버헤드 존재하지만 ArrayList비해서 삭제 중간삽입이 빠르다.
 */
import java.util.*;

public class PGM_HateSameNumber {
    public Integer[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] != arr[i+1])
                list.add(arr[i]);
        }
        list.add(arr[arr.length-1]);
        Integer[] answer = list.toArray(new Integer[list.size()]);
        return answer;
    }
}