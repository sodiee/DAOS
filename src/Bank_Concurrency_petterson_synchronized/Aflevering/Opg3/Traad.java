package Bank_Concurrency_petterson_synchronized.Aflevering.Opg3;

public class Traad extends Thread {
    private String navn;
    private FaellesKlassen faellesKlassen;

    public Traad(String navn, FaellesKlassen faellesKlassen) {
        this.navn = navn;
        this.faellesKlassen = faellesKlassen;
    }

    public void run() {
        for (int j = 0; j < 100; j++) {
            faellesKlassen.kritiskSektion();
            faellesKlassen.tagerRandomTid(204);
        }

        System.out.println(faellesKlassen.getGlobal());
    }
}
