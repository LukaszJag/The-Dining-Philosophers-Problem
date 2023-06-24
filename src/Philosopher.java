import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {
    public int number;
    public Fork leftFork;
    public Fork rightFork;
    public Thread t;
    public int howManyTimesHeEats;
    public boolean isHasLeftFork;
    public boolean isHasRightFork;


    Philosopher(int num, Fork left, Fork right) {
        howManyTimesHeEats = 0;
        isHasLeftFork = false;
        isHasRightFork = false;
        number = num;
        leftFork = left;
        rightFork = right;
        t = new Thread(this, String.valueOf(num));
        //System.out.println("Philosopher " + num + " is ready...");
    }

        void eat(){
            try
            {
                int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
                Thread.sleep(sleepTime);
            }
            catch (Exception e)
            {
                e.printStackTrace(System.out);
            }
        }

    public void run() {

        Random random = new Random();
        int randomInt = random.nextInt(600, 2000);
        try {
            Thread.sleep(randomInt);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            //System.out.println("Philosopher " + number + " is thinking...");

            leftFork.grab();
            isHasLeftFork = true;
            //System.out.println("Philosopher " + number + " grabs left fork " + leftFork.number);

            rightFork.grab();
            isHasRightFork = true;
            //System.out.println("Philosopher " + number + " grabs right fork " + rightFork.number);

            //System.out.println("Philosopher " + number + " is eating...");
            howManyTimesHeEats = howManyTimesHeEats + 1;
            eat();
            leftFork.release();
            isHasLeftFork = false;
            //System.out.println("Philosopher " + number + " has put down the left fork " + leftFork.number);
            rightFork.release();
            isHasRightFork = false;
            //System.out.println("Philosopher " + number + " has put down the right fork " + rightFork.number);

        }
    }
}
