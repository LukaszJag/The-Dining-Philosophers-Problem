import java.util.concurrent.Semaphore;

public class Fork {
    public Semaphore mutex = new Semaphore(1);
    int number;

    Fork(int num) {
        number = num;
    }

    void grab() {
        try {
            mutex.acquire();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    void release() {
        mutex.release();
    }
}
