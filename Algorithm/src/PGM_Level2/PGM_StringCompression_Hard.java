package PGM_Level2;

/*
 * 2021.06.26
 * PGM 문자열 압축
 * 입력 String을 1이상의 단위로 잘라서 연속하면 연속한만큼 숫자붙이고
 * 하나로 줄이는데, 이때 압축이 많이된(압축결과 길이가 가장 짧은) 문자열의 길이가 답
 * 입력에 따라 답을 알 수 없고, 길이가 최대 1000이므로 1000*500이면 다 해볼만하니 브루트포스로 풀었다.
 * 입력길이가 1000일 때 500까지만 해보면 되는 이유는 압축하려면 최소 두번은 연속해야해서다.
 * 반복회수가 두 자리수 이상인 것은 왜 생각 못했을까.. 한자리 수인 것만 생각하고 풀었다..
 * 배열 앞뒤 비교해가며 조건에 맞으면 카운트하고 한 라인 다돌면 정답 갱신해주는 문제는 항상 마지막을 조심하라!!!!
 * 중복되는 if else문은 줄일 수 있다!!
 */
class PGM_StringCompression_Hard {
	public int solution(String s) {
		int len = s.length();
		int localAns = len;
		int answer = len;
		for(int i = 1; i <= len/2; i++) {
			localAns = len;
			int cnt = 1;
			for(int j = 0; j < len; j+=i) {
				if(j+(2*i) <= len && s.substring(j, j+i).equals(s.substring(j+i, j+(2*i)))) {
					cnt++;
					//System.out.println(s.substring(j, j+i) +" "+ s.substring(j+i, j+(2*i)) +" "+ cnt);
				}
				else {
					if(cnt > 1)
						localAns = localAns - (i*(cnt-1)) + findNumLen(cnt);
					cnt = 1;
				}

			}
			if(answer > localAns) {
				answer = localAns;
				System.out.println(answer);
			}

		}
		return answer;
	}
	static int findNumLen(int n) {
		String str = n+"";
		return str.length();
	}
}