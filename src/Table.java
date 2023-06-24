import java.util.concurrent.locks.Lock;

public class Table {
    private static final String[] forkState = {"__", "_|", "|_", "||"};

    static void displayTable(Philosopher[] philosophers, Lock[] forks) {
        for (int i = 0; i < philosophers.length; i++) {
            System.out.print("ph " + philosophers[i].getNumber() + "    ");
        }
        System.out.println();

        for (int i = 0; i < philosophers.length; i++) {
            System.out.print(".");
            if (!philosophers[i].isHasLeftFork() && !philosophers[i].isHasRightFork()) {
                System.out.print(forkState[0]);
            }
            if (!philosophers[i].isHasLeftFork() && philosophers[i].isHasRightFork()) {
                System.out.print(forkState[1]);
            }
            if (philosophers[i].isHasLeftFork() && !philosophers[i].isHasRightFork()) {
                System.out.print(forkState[2]);
            }
            if (philosophers[i].isHasLeftFork() && philosophers[i].isHasRightFork()) {
                System.out.print(forkState[3]);
            }
            System.out.print("      ");
        }

        System.out.println();

        for (Philosopher philosopher : philosophers) {
            System.out.print(philosopher.getHowManyTimesHeEats() + "        ");
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
