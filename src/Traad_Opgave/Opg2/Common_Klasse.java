package Traad_Opgave.Opg2;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Common_Klasse {
    private Semaphore sTjener = new Semaphore(1);
    private Semaphore sKok = new Semaphore(1);
    private Queue<Integer> queue;
    private int countOrdre;
    private int countKok;
    private int tempKok = 1;
    private int tempTjener = 1;

    public Common_Klasse() {
        queue = new PriorityQueue<>();
        countOrdre = 0;
        countKok = 0;
    }

    public synchronized void modtagNyOrdre() {
        queue.add(tempTjener);
        System.out.println("Ordre #" + tempTjener + " modtaget");
        kritiskSektionTjener();
        tempTjener++;
    }

    public synchronized void lavNyOrdre() {

        if (Objects.equals(tempKok, queue.peek())) {
            queue.remove(tempKok);
            System.out.println("Ordre #" + tempKok + " lavet");
            kritiskSektionKok();
        } else {
            throw new RuntimeException("Ordren er ikke den næste i køen. Queuepeek: " + queue.peek() + " Ordre to be made: " + getCountKok());
        }
        tempKok++;
    }

    public void kritiskSektionTjener() {
        try {
            sTjener.acquire();
            countOrdre++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sTjener.release();
    }

    public void kritiskSektionKok() {
        try {
            sKok.acquire();
            countKok++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sKok.release();
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

    public int getCountOrdre() {
        return countOrdre;
    }

    public int getCountKok() {
        return countKok;
    }

    /*public class Ordre {
        private static int nr;
        private String navn;

        public Ordre(String navn) {
            this.navn = navn;
            nr++;
        }
    }*/
}
