package Deadlock_Lektion.kode.StackOpgave;

public class TraadKlassePop extends Thread {
    private Stack stack;

    public TraadKlassePop(Stack stack) {
        this.stack = stack;
    }

    public void run() {
        while (true) {
            stack.pop();
            System.out.println("Der er blevet poppet");
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
