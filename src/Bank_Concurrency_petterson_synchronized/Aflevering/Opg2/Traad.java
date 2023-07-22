package Bank_Concurrency_petterson_synchronized.Aflevering.Opg2;

public class Traad extends Thread {
    private String navn;
    private FaellesKlassen faellesKlassen;

    public Traad(String navn, FaellesKlassen faellesKlassen) {
        this.navn = navn;
        this.faellesKlassen = faellesKlassen;
    }

    public void run() {
            for (int j = 0; j < 100; j++) {
                Main.setFlag(0, true); //anmoder om adgang
                Main.setTurn(1);
                while (Main.getFlag(1) && Main.getTurn() == 1);
                faellesKlassen.kritiskSektion();
                faellesKlassen.tagerRandomTid(204);
                Main.setFlag(0, false);
            }

        System.out.println(faellesKlassen.getGlobal());
    }
}
