package Traad_Opgave.Rettet.Opg3Rettet;

public class Tjener extends Thread {
    private final Common_Klasse common_klasse;

    private String navn;

    public Tjener(String navn, Common_Klasse common_klasse) {
        this.navn = navn;
        this.common_klasse = common_klasse;
    }

    public String getNavn() {
        return navn;
    }

    public void run() {
        while (true) {
            common_klasse.modtagNyOrdre(this);
            try {
                sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
