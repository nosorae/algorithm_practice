package godofjava.a;

// GodOfJava Vol1. 6장
// TODO:: switch 에서 default 를중간에 넣으면 어떻게 동장하는지 직접 확인

public class InterestManager {
    public static void main(String[] args) {
        InterestManager interestManager = new InterestManager();
        System.out.println("1~365일까지 하루씩 증가하면서 100만원을 예금했을 때 이자를 얼마나 받을 수 있을까?");
        long money = 1_000_000;
        for (int day = 1; day <= 365; day++) {
            System.out.println(day + "일차: " + interestManager.calculateAmount(day, money));
        }

        System.out.println("1일 단위가 아닌 10일 간격으로 했을 때의 결과는?");
        for (int day = 1; day <= 365; day += 10) {
            System.out.println(day + "일차: " + interestManager.calculateAmount(day, money));
        }
    }
    public double getInterestRate(int day) {
        double rate = 0.0;
        if (day <= 90) {
            rate = 0.5;
        } else if (day <= 180) {
            rate = 1.0;
        } else if (day <= 364) {
            rate = 2.0;
        } else {
            rate = 5.6;
        }
        return day * rate / 100;
    }

    public double calculateAmount(int day, long amount) {
        return amount + ((amount * getInterestRate(day)));
    }
}
