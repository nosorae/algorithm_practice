package math;

public class PrimeNumber {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * false여야 소수
	 * k k*2 k*3 k*4 k*5 ... k*(k-1) k*k 
	 */
	static boolean[] getPrimeArr(int n) {
        boolean[] arr = new boolean[n+1]; // 1000만 기준 약 10MB?
        
        arr[0] = arr[1] = true;
        
        for(int i = 2;  i*i <= n; i++) {
            if(!arr[i]) {
                for(int j = i*i;  j <= n; j += i) {
                    arr[j] = true; //false이면 소수가 된다.
                }
            }
        }
        return arr;
    }
	
	public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}
