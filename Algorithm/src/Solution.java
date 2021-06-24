class Solution {
	public static void main(String[] args) {
		int n = 100;
		for(int i = 0; i < n; i++) {
			printStar(' ', i);
			printStar('*', n-i);
			System.out.println();
		} 
	}
	static void printStar(char c, int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(c);
		}
	}
}