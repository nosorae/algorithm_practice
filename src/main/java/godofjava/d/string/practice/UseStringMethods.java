package godofjava.d.string.practice;

// GodOfJava Vol1. 15장 연습문제
// String API 문서 https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
public class UseStringMethods {
    static final String input = "The String class represents character strings.";
    public static void main(String[] args) {
        UseStringMethods useStringMethods = new UseStringMethods();
        useStringMethods.printWords(input);
        useStringMethods.findString(input, "string");
        useStringMethods.findAnyCaseString(input, "string");
        useStringMethods.contChar(input, 's');
        useStringMethods.printContainWords(input, "ss");
    }

    public void printWords(String str) {
        String[] strings = str.split(" ");
        for (String string: strings) {
            System.out.println(string);
        }
    }

    public void findString(String str, String findStr) {
        System.out.println("string is appeared at " + str.indexOf(findStr));
    }

    public void findAnyCaseString(String str, String findStr) {
        System.out.println("string is appeared at " + str.toLowerCase().indexOf(findStr.toLowerCase()));
    }

    public void contChar(String str, char c) {
        char[] arr = str.toCharArray();
        int count = 0;
        for (char character: arr) {
            if (character == c) {
                count++;
            }
        }
        System.out.println("char '" + c + "' count is " + count);
    }

    public void printContainWords(String str, String findStr) {
        String[] arr = str.split(" ");
        for (String string: arr) {
            if (string.contains(findStr)) {
                System.out.println(string + " contains " + findStr);
            }
        }
    }
}
