package Deadlock_Lektion.kode.Eks;

public class Message {
    private String msg;

    public Message(String str){
        this.msg=str;
    }

    public synchronized String getMsg() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public synchronized void setMsg(String str) {
        this.msg=str;
        //notify();
        notifyAll();
    }
}
