package Deadlock_Lektion.kode.StackOpgave;

public class TraadKlassePush extends Thread {
    private Stack stack;

    public TraadKlassePush(Stack stack) {
        this.stack = stack;
    }

    public void run() {
        while (true) {
            stack.push(1);

            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Der er blevet pushet");
        }
    }
}
