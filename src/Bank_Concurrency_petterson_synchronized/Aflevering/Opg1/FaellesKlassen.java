package Bank_Concurrency_petterson_synchronized.Aflevering.Opg1;

import java.util.Random;

public class FaellesKlassen {
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
        int temp;
        temp = global;
        tagerRandomTid(100);
        global = temp + 1;
    }
}
