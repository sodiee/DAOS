package Traad_Opgave.Rettet.Opg4Rettet;

public class Kok extends Thread {
    private final Common_Klasse common_klasse;
    private String navn;

    public Kok(String navn, Common_Klasse common_klasse) {
        this.common_klasse = common_klasse;
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void run() {
        while (true) {
            try {
                sleep(200);
                common_klasse.lavNyOrdre(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
