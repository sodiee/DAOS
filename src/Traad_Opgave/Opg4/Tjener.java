package Traad_Opgave.Opg4;

public class Tjener extends Thread {
    private final Common_Klasse common_klasse;

    public Tjener(Common_Klasse common_klasse) {
        this.common_klasse = common_klasse;
    }

    public void run() {
        while (true) {
            common_klasse.modtagNyOrdre();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
