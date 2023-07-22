package Deadlock_Lektion.kode.Eks;

public class WaitNotifyTest {

    public static void main(String[] args) {
        Message msg = new Message("process it");

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();

        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        System.out.println("All the threads are started");
    }
}
