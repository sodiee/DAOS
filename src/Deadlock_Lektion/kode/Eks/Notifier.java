package Deadlock_Lektion.kode.Eks;

public class Notifier extends Thread{

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        msg.setMsg(name+" Notifier work done");



    }

}
