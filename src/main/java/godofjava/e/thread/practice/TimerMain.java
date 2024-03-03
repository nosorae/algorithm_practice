package godofjava.e.thread.practice;

import java.util.Date;

// GodOfJava Vol2. 7장 연습문제
public class TimerMain {
    public static void main(String[] args) {
        TimerThread timer = new TimerThread();
        timer.setPriority(Thread.MAX_PRIORITY);
        timer.start();
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        try {
            printCurrentTime();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void printCurrentTime() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            long currentTimeMillis = System.currentTimeMillis();
            long timedMillis = currentTimeMillis / 1000 * 1000;
            System.out.println(new Date(currentTimeMillis).toString() + " " + currentTimeMillis + " " + timedMillis);
            Thread.sleep(1000L);
        }
    }
}
