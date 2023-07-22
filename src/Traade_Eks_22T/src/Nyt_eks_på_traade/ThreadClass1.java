package Nyt_eks_på_traade;

public class ThreadClass1 extends Thread{
    CommenClass commenClass;

    public ThreadClass1(CommenClass commenClass) {
        super();
        this.commenClass = commenClass;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            commenClass.subOne();
            try {
                this.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(commenClass.getI());
    }
}
