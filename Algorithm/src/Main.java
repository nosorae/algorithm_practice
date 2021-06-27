
/*
 * BOJ 
 */
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exp = "100-200*300-400+500";
		String[] operands = exp.split("[-*+]");
        String[] operators = exp.split("[0-9]+");
        for(String s : operands)
        	System.out.print(s+" *");
        System.out.println();
        for(String s : operators) {
        	System.out.println(s.length());
        }
        for(String s : operators) {
        	System.out.print(s+" ");
        }
        	
        
		
	}
}



