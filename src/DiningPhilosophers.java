import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers implements Runnable {
    private final int philosophersNum = 5;
    private final Lock[] forks = new ReentrantLock[philosophersNum];
    private final Philosopher[] philosophers = new Philosopher[philosophersNum];
    final Thread t;

    DiningPhilosophers() {
        t = new Thread(this);
        for (int i = 0; i < philosophersNum; i++) {
            forks[i] = new ReentrantLock();
        }
        for (int i = 0; i < philosophersNum; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % philosophersNum]);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < philosophersNum; i++) {
            Thread t = new Thread(philosophers[i], String.valueOf(i));
            t.start();
        }
        while (true) {
            Table.displayTable(philosophers, forks);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
