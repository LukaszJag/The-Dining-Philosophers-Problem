public class DiningPhilosophers implements Runnable {
    Thread t;
    public int philosophersNum = 5;
    public Fork[] forks = new Fork[philosophersNum];
    public Philosopher[] philosophers = new Philosopher[philosophersNum];

    DiningPhilosophers() {
        t = new Thread(this);
    }

    public void init() {

        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < philosophersNum; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[((i + 1) % philosophersNum)]);
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < philosophersNum; i++) {
            philosophers[i].t.start();
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
