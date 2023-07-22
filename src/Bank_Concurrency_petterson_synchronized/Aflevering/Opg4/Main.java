package Bank_Concurrency_petterson_synchronized.Aflevering.Opg4;

public class Main {
    public static void main(String[] args) {
        FaellesKlassen faellesKlassen = new FaellesKlassen();
        Traad traad1 = new Traad("Hej", faellesKlassen);
        Traad2 traad2 = new Traad2("Farvel", faellesKlassen);

        traad1.start();
        traad2.start();
    }
}
