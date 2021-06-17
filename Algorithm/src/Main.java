import java.util.*;
import java.io.*;
/*
 * 백준 13913 숨바꼭질4 
 * 1. 양의 방향으로 이동하는 next정점은 최대값 경계처리만 해줘도 되고
 *    음의 방향으로 이동하는 next정점은 최소값 경계처리만 해줘도 된다.
 */
public class Main {
   
    public static void main(String[] args) throws IOException {
    	int[] arr = {3,5, 7, 9, 1};
    	int[] ans = solution(arr);
    	for(int n : ans) {
    		System.out.print(n+" ");
    	}
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	
    
    }
    
    static int[] solution(int[] arr) {
        int[] count = new int[101];
        for(int n : arr) {
            count[n]++;
        }
        
        int size = 0;
        for(int i = 1; i < 101; i++) {
            if(count[i] > 1) {
                size++;
            }
        }
        

        int[] ans = new int[size];
        
        if(size == 0) {
        	ans = new int[1];
        	ans[0] = -1;
        }
        else {
        	int ans_idx = 0;
            for(int i = 1; i < 101; i++) {
                if(count[i] > 1) {
                    ans[ans_idx] = count[i];
                    ans_idx++;
                }
            }
        }
        
        
        return ans;
        
    }
}