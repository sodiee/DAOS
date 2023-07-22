package Bank_Concurrency_petterson_synchronized.Aflevering.Opg2;

public class hhhh {
    public class MyThread extends Thread {
        private String navn;
        FaellesKlassen faelles;
        public MyThread(String navn, FaellesKlassen faelles) {

            this.navn = navn;
            this.faelles = faelles;

        }

        public void run() {
            for (int j = 0; j < 100; j++) {
                Main.setFlag(0, true);
                Main.setTurn(1);
                while (Main.getFlag(1) && Main.getTurn() == 1) ;
                faelles.kritiskSektion();
                faelles.tagerRandomTid(99 );
                Main.setFlag(0, false);

            }
            System.out.println(getName() + " Den fælles tæller");
            System.out.println(faelles.getGlobal());
        }

    }
}
