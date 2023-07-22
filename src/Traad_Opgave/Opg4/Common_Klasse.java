package Traad_Opgave.Opg4;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Common_Klasse {
    private Queue<Integer> queue;
    private int countOrdre;
    private int countKok;

    public Common_Klasse() {
        queue = new PriorityQueue<>();
        countOrdre = 0;
        countKok = 0;
    }

    public synchronized void modtagNyOrdre() {
        queue.add(countOrdre);
        System.out.println("Ordre #" + countOrdre + " modtaget");
        kritiskSektionTjener();
        notify();
    }

    public synchronized void lavNyOrdre() {
        if (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (Objects.equals(countKok, queue.peek())) {
            queue.remove(countKok);
            System.out.println("Ordre #" + countKok + " lavet.");
            kritiskSektionKok();
        } else {
            throw new RuntimeException("Ordren er ikke den næste i køen. Queuepeek: " + queue.peek() + "Ordre to be made: " + getCountKok());
        }

    }

    public synchronized void kritiskSektionTjener() {
        countOrdre++;
    }

    public synchronized void kritiskSektionKok() {
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

}
