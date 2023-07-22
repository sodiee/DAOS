package Bank_Concurrency_petterson_synchronized.Aflevering.Opg2;

public class jjj {
    public class MyThread2 extends Thread {
        String navn;
        FaellesKlassen faelles;
        public MyThread2 (String navn, FaellesKlassen faelles) {

            this.navn = navn;
            this.faelles = faelles;

        }

        public void run() {
            for (int j = 0; j < 100; j++) {
                Main.setFlag(1, true);
                Main.setTurn(0);
                while (Main.getFlag(0) && Main.getTurn() == 0) ;
                faelles.kritiskSektion();
                faelles.tagerRandomTid(99 );
                Main.setFlag(1, false);

            }
            System.out.println(getName() + " Den fælles tæller");
            System.out.println(faelles.getGlobal());
        }

    }
}
