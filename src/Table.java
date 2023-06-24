public class Table {
    static String[] forkState = {"__", "_|", "|_", "||"};
    static void displayTable(Philosopher[] philosophers, Fork[] forks){

        for (int i = 0; i < 5; i++) {
            System.out.print("ph " + i + "    ");
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {

            System.out.print(".");
            if((!(philosophers[i].isHasLeftFork)) && (!(philosophers[i].isHasRightFork))){
                System.out.print(forkState[0]);
            }
            if((!(philosophers[i].isHasLeftFork)) && ((philosophers[i].isHasRightFork))){
                System.out.print(forkState[1]);
            }
            if(((philosophers[i].isHasLeftFork)) && (!(philosophers[i].isHasRightFork))){
                System.out.print(forkState[2]);
            }
            if(((philosophers[i].isHasLeftFork)) && ((philosophers[i].isHasRightFork))){
                System.out.print(forkState[3]);
            }
            System.out.print("      ");
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print(philosophers[i].howManyTimesHeEats + "        ");
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
