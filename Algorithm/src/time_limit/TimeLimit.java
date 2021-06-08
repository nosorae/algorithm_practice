package time_limit;

import java.io.*;

public class TimeLimit {

	public static void main(String[] args) throws IOException { //IOException을 잊지 않는다
		// 입출력이 많을 때 System.out.print 함수와 Scanner는 속도가 느리기 때문에 아래와 같은 입출력을 사용한다.
		// br.readLine()으로 한줄 String을 받아올 수 있고
		// bw.write(String)으로 출력할 수 있다. 마지막에 bw.flush()해주는 것을 잊지 말자
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	}

}
