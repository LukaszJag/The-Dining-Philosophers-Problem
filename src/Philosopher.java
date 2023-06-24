import java.util.concurrent.locks.Lock;
import java.util.Random;

public class Philosopher implements Runnable {
    private final int number;
    private final Lock leftFork;
    private final Lock rightFork;
    private int howManyTimesHeEats;
    public boolean isHasLeftFork;
    public boolean isHasRightFork;
    private static final Random random = new Random();

    Philosopher(int number, Lock leftFork, Lock rightFork) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.howManyTimesHeEats = 0;
        this.isHasLeftFork = false;
        this.isHasRightFork = false;
    }

    void eat() {
        try {
            int sleepTime = random.nextInt(1000);
            Thread.sleep(sleepTime);
            howManyTimesHeEats++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        while (true) {
            think();
            if (number % 2 == 0) {
                leftFork.lock();
                isHasLeftFork = true;
                rightFork.lock();
                isHasRightFork = true;
            } else {
                rightFork.lock();
                isHasRightFork = true;
                leftFork.lock();
                isHasLeftFork = true;
            }
            try {
                eat();
            } finally {
                leftFork.unlock();
                isHasLeftFork = false;
                rightFork.unlock();
                isHasRightFork = false;
            }
        }
    }

    private void think() {
        try {
            int sleepTime = random.nextInt((2000 - 600) + 1) + 600;  // random number between 600 to 2000
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getNumber() {
        return number;
    }

    public int getHowManyTimesHeEats() {
        return howManyTimesHeEats;
    }

    public boolean isHasLeftFork() {
        return isHasLeftFork;
    }

    public boolean isHasRightFork() {
        return isHasRightFork;
    }
}
