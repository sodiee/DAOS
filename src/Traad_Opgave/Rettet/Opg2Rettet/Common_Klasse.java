package Traad_Opgave.Rettet.Opg2Rettet;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Common_Klasse {
    private Semaphore sTjener = new Semaphore(1);

    private Semaphore sKok = new Semaphore(0);
    private Queue<Integer> queue;
    private int countOrdre;
    private int countKok;

    public Common_Klasse() {
        countOrdre = 0;
        countKok = 0;
    }

    public void modtagNyOrdre(Tjener tjener) {
        try {
            sTjener.acquire();
            System.out.println("ordre " + countOrdre + " er modtaget af " + tjener.getNavn());

            countOrdre++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sTjener.release();
        sKok.release();
    }

    public void lavNyOrdre() {
        try {
            sKok.acquire();
            System.out.println("ordre " + countKok + " er lavet");
            countKok++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            //throw new RuntimeException("Ordren er ikke den næste i køen. Queuepeek: " + queue.peek() + "Ordre to be made: " + getCountKok());
    }

    public void kritiskSektionTjener() {
        countOrdre++;
    }

    public void kritiskSektionKok() {
        countKok++;
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
