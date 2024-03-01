package godofjava.d.collection.practice;

import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

public class RandomNumberStatistics {
    private final int DATA_BOUNDARY = 50;
    Hashtable<Integer, Integer> ht = new Hashtable<>();
    public static void main(String[] args) {
        RandomNumberStatistics rns = new RandomNumberStatistics();
        rns.getRandomNumberStatistics();
    }

    public void getRandomNumberStatistics() {
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            int randomNumber = random.nextInt(DATA_BOUNDARY) + 1;
            putCurrentNumber(randomNumber);
        }
        printStatistics();
    }

    public void putCurrentNumber(int tempNumber) {
        if (!ht.containsKey(tempNumber)) {
            ht.put(tempNumber, 1);
        } else {
            ht.put(tempNumber, ht.get(tempNumber) + 1);
        }
    }

    public void printStatistics() {
        Set<Integer> keySet = ht.keySet();
        for (int key: keySet) {
            System.out.print(key + "=" + ht.get(key) + "\t");

            if (key%10 - 1 == 0) System.out.println();
        }
    }
}
