package Bank_Concurrency_petterson_synchronized.Aflevering.Opg4;

public class Traad2 extends Thread {
    private String navn;
    private FaellesKlassen faellesKlassen;

    public Traad2(String navn, FaellesKlassen faellesKlassen) {
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
