package godofjava.d.collection.practice;

import java.util.HashSet;
import java.util.Random;

// GodOfJava Vol2. 5장 연습문제
public class RandomNumberMaker {
    public static void main(String[] args) {
        RandomNumberMaker rnm = new RandomNumberMaker();
        for (int i = 0; i < 10; i++) {
            System.out.println(rnm.getSixNumber());
        }
    }

    public HashSet<Integer> getSixNumber() {
        HashSet<Integer> set = new HashSet<>();
        Random random = new Random();
        while (set.size() < 6) {
            set.add(random.nextInt(45));
        }
        return set;
    }


}
