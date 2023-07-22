package Traad_Opgave.Rettet.Opg1Rettet;

import java.util.Queue;

public class Common_Klasse {
    private Queue<Integer> queue;
    private int countOrdre;
    private int countKok;

    public Common_Klasse() {
        countOrdre = 0;
        countKok = 0;
    }

    public void modtagNyOrdre(Tjener tjener) {
        System.out.println("ordre " + countOrdre + " er modtaget af " + tjener.getNavn());
        countOrdre++;
    }

    public void lavNyOrdre() {
        System.out.println("ordre " + countKok + " er lavet");
        countKok++;
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
