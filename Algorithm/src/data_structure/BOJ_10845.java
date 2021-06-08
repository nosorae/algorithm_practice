package data_structure;


import java.io.*;
import java.util.*;
/*
 * 백준 10845번 큐
 * 뻘짓 정리 
 * 1. "push"랑 "push 3" 다르다는 것을 깜빡함
 * 2. "push"뒤의 숫자의 자리수가 한자리라고 단정 지금 -> 문제조건 제대로 파악
 * 3. LinkedList의 get과 remove를 헷갈렸다.
 * 4. 많은 입출력이 요구되면 BufferedWriter BufferedReader 꼭 써주자
 * 3. 일정 텀마다 코드에 실수가 없는지 잘 확인하자
 */

class BOJ_10845 {
	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> q = new LinkedList<Integer>();

		int n = Integer.parseInt(br.readLine());
		

		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			switch(input) {
			case "pop":
				if(!q.isEmpty())
					bw.write(q.remove(0)+"\n");
				else 
					bw.write(-1+"\n");
				break;
				
			case "front":
				if(!q.isEmpty())
					bw.write(q.get(0)+"\n");
				else 
					bw.write(-1+"\n");
				break;

			case "back":
				if(!q.isEmpty())
					bw.write(q.get(q.size()-1)+"\n");
				else 
					bw.write(-1+"\n");
				break;
				
			case "size":
				bw.write(q.size()+"\n");
				break;
				
			case "empty":
				if(q.isEmpty())
					bw.write(1+"\n");
				else 
					bw.write(0+"\n");
				break;
				
			default:
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				int data = Integer.parseInt(st.nextToken());
				q.addFirst(data);
				

			}
		}
		bw.flush();
		br.close();
		bw.close();

	}
}