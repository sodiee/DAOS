package Deadlock_Lektion.kode.StackOpgave;

public class Stack {
    private class Element {
        int info;
        Element next;

        Element(int n, Element e) {
            info = n;
            next = e;
        }
    }

    private Element first;

    public Stack() {
        first = null;
    }

    public synchronized void push(int n) {
        first = new Element(n, first);
        if (first.next == null) {
            notify();
        }
    }

    public synchronized int pop() {
        try {
            while (is_empty()) {
                System.out.println("Stacken er tom");
                wait();

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int n = first.info;
        first = first.next;
        return n;
    }

    public boolean is_empty() {
        return first == null;
    }
}
