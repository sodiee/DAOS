package Bank_Concurrency_petterson_synchronized.Aflevering.Opg4;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class FaellesKlassen {

    private Semaphore s = new Semaphore(1);
    private int global = 0;

    public void tagerRandomTid(int max) {
        Random r = new Random();
        int nyMax = Math.abs(r.nextInt()) % max + 1;
        int vaerdi = 0;
        for (int i = 0; i < nyMax; i++) {
            for (int j = 0; j < nyMax; j++) {
               vaerdi = vaerdi + 1 + 1 + 2;
            }
        }
    }

    public int getGlobal() {
        return global;
    }

    public void kritiskSektion() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int temp;
        temp = global;
        tagerRandomTid(100);
        global = temp + 1;
        s.release();
    }
}
