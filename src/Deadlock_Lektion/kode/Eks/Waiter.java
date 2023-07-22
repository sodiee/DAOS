package Deadlock_Lektion.kode.Eks;

public class Waiter extends Thread{

    private Message msg;

    public Waiter(Message m){
        this.msg=m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
        System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
        System.out.println(name+" processed: "+msg.getMsg());
    }
}
