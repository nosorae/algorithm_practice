package bruteforce;

/*
 * BOJ 2309 일곱난쟁이
 * 9개의 수가 주어질 때 7개뽑아서 합이 100이되는 경우의 7개의 숫자를 오름차순으로 출력하는 문제 
 * 다 뽑아보지 않으면 모르겠고 9C7 == 9C2는 수가 적기 때문에 브루트포스로 풀겠다.
 * 이번 조합 브루트포스는 저번엔 for문으로 풀었으니 이번엔  재귀로 풀어보았다. 
 * 제외할 두개를 뽑아서 나머지 합이 100이 되면 그것을 제외하고 오름차순으로 출력해주었다. 
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	static final int n = 9;
	static int[] dwarfs;
	static int sum;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	sum = 0;
        dwarfs = new int[n];
        for(int i = 0; i < n; i++) {
        	dwarfs[i] = sc.nextInt();
        	sum += dwarfs[i];
        }
        Arrays.sort(dwarfs);
        int[] result = new int[2];
        pickDwarfs(0, 0, result);
        for(int i = 0; i < n; i++) {
        	if(dwarfs[i] == result[0] || dwarfs[i] == result[1])
        		continue;
        	System.out.println(dwarfs[i]);
        }
    }
    static boolean pickDwarfs(int idx, int deep, int[] arr) {
        if(deep == 2) {
        	if(sum - arr[0] - arr[1] == 100)
        		return true;
        	else
        		return false;
        }
    	
    	
        for(int i = idx; i < n; i++) {
        	arr[deep] = dwarfs[i];
            if(pickDwarfs(i+1, deep+1, arr))
            	return true;
        }
        
        return false;
    }
}


//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//
//public class Main {
//   
//    public static void main(String args[]) throws Exception {
//    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	int[] arr = new int[10];
//    	int sum = 0;
//    	for(int i = 1; i <= 9; i++) {
//    		arr[i] = Integer.parseInt(br.readLine());
//    		sum += arr[i];
//    	}
//    	Arrays.sort(arr);
//    	
//    	for(int i = 1; i <= 9; i++) {
//    		for(int j = i+1; j <=9; j++) {
//    			if((sum - arr[i] - arr[j]) == 100){
//    				for(int k = 1; k <= 9; k++) {
//    					if(k != i && k != j) {
//    						System.out.println(arr[k]);
//    					}
//    				}
//    				System.exit(0);
//    			}
//    		}
//    	}
//    }
//}
