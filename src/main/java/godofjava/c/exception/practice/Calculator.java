package godofjava.c.exception.practice;

// GodOfJava Vol1. 14장 연습문제
public class Calculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            calc.printDivide(1, 2);
            calc.printDivide(1, 0); // 0으로 나눴기 때문에 무한대
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printDivide(double d1, double d2) throws Exception {
        if (d2 == 0) {
            throw new Exception("Second value can't be Zero");
        }
        double result = d1 / d2;
        System.out.println(result);
    }
}
