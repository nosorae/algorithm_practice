package PGM_Level3;

import java.util.*;
/*
 * 2021.06.21
 * PGM 베스트앨범 https://programmers.co.kr/learn/courses/30/lessons/42579
 * 문제를 오래 더럽게 풀었기 때문에 다음에 다시 풀어봐야겠다.
 * 내 문제풀이 방식은 <String, Integer>로 각 장르별 플레이합을 세고 정렬하고, 
 * <String, LinkedList<Music>>로 각 장르별로 Music리스트를 만들어서 각각을 정렬해서
 * 플레이합이 가장 많은 장르부터 최대 두개씩 빼주고 그 장르를 맵에서 삭제하였다. 
 * 처음에 장르의 노래들 재생수의 합이 중복되지 않는 다는 말을 캐치 못하고 모든 노래의 재생수가 중복이 안되는 줄 알았다.
 * 문제를 제대로 파악하지도 않고 문제를 푸니까 시간낭비를 하였고, 
 * 나중에 제대로 파악하고 코드를 고치려니 에러나서 또 시간낭비하고 코드도 더러워졌다. 
 * for문안에 임시변수를 만들고 가는 습관을 가지는 게 좋다. 
 * 그리고 HashMap은 put이고 HashSet add다.. HashSet은 Collection인터페이스를 구현했고 HahsMap은 Map인터페이스를 구현했다.
 *
 */

class PGM_BestAlbum_Hard {
	public int[] solution(String[] genres, int[] plays) {


		HashMap<String, LinkedList<Music>> map  = new HashMap<String, LinkedList<Music>>(); 
		HashMap<String, Integer> genSum = new HashMap<String, Integer>();
		int len = genres.length;


		//map으로 장르별로 플레이수 리스트를 만들고 
		for(int i = 0; i < len; i++) {
			if(map.containsKey(genres[i])) {
				LinkedList<Music> temp = map.get(genres[i]);
				temp.add(new Music(i, genres[i], plays[i]));

				genSum.put(genres[i], genSum.get(genres[i]) + plays[i]);
			}
			else {
				LinkedList<Music> temp = new LinkedList<Music>();
				temp.add(new Music(i, genres[i], plays[i]));
				map.put(genres[i], temp);

				genSum.put(genres[i], plays[i]);
			}

		}

		//장르별 재생횟수 기준으로 내림차순 정렬
		Genres[] gen = new Genres[genSum.size()];
		int genIdx = 0;
		for(Map.Entry<String, Integer> entry : genSum.entrySet()) {
			gen[genIdx++] = new Genres(entry.getKey(), entry.getValue());
		}
		Arrays.sort(gen);


		for(LinkedList<Music> list : map.values()) {
			System.out.println(list.toString());
		} 


		LinkedList<Integer> ans = new LinkedList<Integer>();
		for(int i = 0; i < gen.length; i++) {
			if(!map.containsKey(gen[i].genres))
				continue;

			LinkedList<Music> temp = map.get(gen[i].genres);

			Collections.sort(temp); //장르별로 음악들을 재생횟수 기준으로 내림차순 정렬

			//temp의 size는 무조건 1이상이다. 그래서 일단 하나 빼고 그 다음 비었는지 확인하고 하나 더 빼고 장르 삭제
			ans.add(temp.remove(0).id);
			if(!temp.isEmpty()) {
				ans.add(temp.remove(0).id);
			}   
			map.remove(gen[i].genres);
		}

		int[] answer = new int[ans.size()];
		int ansIdx = 0;
		for(int a : ans) {
			answer[ansIdx++] = a;
		}

		return answer;
	}
}
class Genres implements Comparable<Genres> {
	String genres;
	int playSum;
	public Genres(String genres, int playSum) {
		this.genres = genres;
		this.playSum = playSum;
	}
	public int compareTo(Genres o2) {
		if(this.playSum > o2.playSum)
			return -1;
		else 
			return 1;
	}
}

class Music implements Comparable<Music> {
	int id;
	String genres;
	int play;

	public Music(int i, String g, int p) {
		id = i;
		genres = g;
		play = p;
	}

	public int compareTo(Music o2) {
		if(this.play > o2.play) 
			return -1;
		else if (this.play == o2.play) {
			if(this.id > o2.id)
				return 1;
			else
				return -1;
		}
		else
			return 1;
	}

	public String toString() {
		return "(" + id +", " + genres + ", " + play +")";
	}
}