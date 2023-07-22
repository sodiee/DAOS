package Bank_Concurrency_petterson_synchronized.Aflevering.Opg2;

public class Traad2 extends Thread {
        private String navn;
        private FaellesKlassen faellesKlassen;

        public Traad2(String navn, FaellesKlassen faellesKlassen) {
            this.navn = navn;
            this.faellesKlassen = faellesKlassen;
        }

        public void run() {
            for (int j = 0; j < 100; j++) {
                Main.setFlag(1, true);
                Main.setTurn(0);
                while (Main.getFlag(0) && Main.getTurn() == 0);
                faellesKlassen.kritiskSektion();
                faellesKlassen.tagerRandomTid(204);
                Main.setFlag(1, false);
            }
            System.out.println(faellesKlassen.getGlobal());
        }
    }
