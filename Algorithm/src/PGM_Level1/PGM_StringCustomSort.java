package PGM_Level1;

/*
 * 
 * PGM 문자열 내 마음대로 정렬하기 https://programmers.co.kr/learn/courses/30/lessons/12915
 * Comparator의 사용법을 배웠다. 모듈은 sort패키지의 Sort_Custom_Library에 있다.
 */

import java.util.*;

public class PGM_StringCustomSort {
	public String[] solution(String[] strings, int n) {
		StringIndexComparator comparator = new StringIndexComparator(n);

		Arrays.sort(strings, comparator);

		String[] answer = strings;
		return answer;
	}
}

class StringIndexComparator implements Comparator<String> {
	int idx = 0;
	public StringIndexComparator(int idx) {
		this.idx = idx;
	}

	@Override
	public int compare(String s1, String s2) {
		if(s1.charAt(idx) > s2.charAt(idx))
			return 1;
		else if(s1.charAt(idx) == s2.charAt(idx)) 
			return s1.compareTo(s2);



		else
			return -1;
	}

}