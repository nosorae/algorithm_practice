package PGM_Level2;


/*
 * 2021.06.21
 * PGM 전화번호 목록 https://programmers.co.kr/learn/courses/30/lessons/42577
 * 입력 배열의 길이의 최대값이 100만이기 때문에 시간효율이 N^2이 되어선 절대 안된다고 생각했다.
 * 그래서 N*M을 생각해냈다. N은 최대 100만 M은 최대 20으로 최대 2000만이다.
 * 해시의 탐색능력(O(1))이 대단하다는 것을 다시한번 느낀다.
 */ 

import java.util.*;

class PGM_PhoneBook {
    public boolean solution(String[] phone_book) {
        HashSet<String> phoneBook = new HashSet<String>();
        boolean answer = true;
        
        for(int i = 0; i < phone_book.length; i++) {
            phoneBook.add(phone_book[i]);
        }
        
        
        for(int i = 0; i < phone_book.length; i++) {
            String cur = phone_book[i];
            // 중복은 없으니 길이가 된다면 substring(0, 19)까지 중복 여부를 확인해본다.
            for(int j = 0; j < cur.length(); j++) {
                if(phoneBook.contains(cur.substring(0, j)))
                    answer = false;
            }
            if(!answer)
                break;
        }

        return answer;
    }
}
