package Traad_Opgave.Opg2;

public class Kok extends Thread {
    private final Common_Klasse common_klasse;

    public Kok(Common_Klasse common_klasse) {
        this.common_klasse = common_klasse;
    }

    public void run() {

        while (true) {
            try {
                sleep(400);
                common_klasse.lavNyOrdre();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
