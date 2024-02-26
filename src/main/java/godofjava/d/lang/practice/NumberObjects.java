package godofjava.d.lang.practice;

public class NumberObjects {
    public static void main(String[] args) {
        NumberObjects no = new NumberObjects();
        no.parseLong("1024");
        no.parseLong("1024L");
        no.parseLong("1024l");
        no.parseLong("r1024");

        no.printOtherBase(1024);
    }
    public long parseLong(String data) {
        try {
            long number = Long.parseLong(data);
            System.out.println(number);
            return number;
        } catch (NumberFormatException e) {
            System.out.println(data + " is not a number");
            return -1L;
        }
    }

    public void printOtherBase(long value) {
        try {
            System.out.printf("%-8s:%s%n", "Original", value);

            String binary = Long.toBinaryString(value);
            String octal = Long.toOctalString(value);
            String hex = Long.toHexString(value);
            System.out.printf("%-8s:%s%n", "Binary", binary);
            System.out.printf("%-8s:%s%n", "Octal", octal);
            System.out.printf("%-8s:%s%n", "Hex", hex);
        } catch (NumberFormatException e) {
            System.out.println(value + " is not a number");
        }
    }
}
