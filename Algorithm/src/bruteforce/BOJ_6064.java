package bruteforce;



/*
 * BOJ 6064 카잉달력
 * 여러 테스트케이스를 해야하기 때문에 머리를 써서 연산량을 줄인다.
 * 하나를 단위로 올려가며 기준을 찾는다.
 */
import java.util.*;
public class BOJ_6064 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int loop = 0; loop < t; loop++) {
			boolean flag = false;
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int i = x; i <= M*N; i += M) {
				int cur = i;
				if(cur%N == 0)
					cur = N;
				else
					cur %= N;
				if(cur == y) {
					System.out.println(i);
					flag = true;
					break;
				}
			}
			if(!flag)
				System.out.println(-1);	
		}
	}
}

//import java.util.*;
//import java.io.*;
//public class Main {
//    public static void main(String args[]) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.valueOf(bf.readLine());
//        while (t-- > 0) {
//            String[] line = bf.readLine().split(" ");
//            int m = Integer.valueOf(line[0]);
//            int n = Integer.valueOf(line[1]);
//            int x = Integer.valueOf(line[2])-1;
//            int y = Integer.valueOf(line[3])-1;
//            boolean ok = false;
//            for (int k=x; k<(n*m); k+=m) {
//                if (k%n == y) {
//                    System.out.println(k+1);
//                    ok = true;
//                    break;
//                }
//            }
//            if (!ok) {
//                System.out.println(-1);
//            }
//        }
//    }
//}







