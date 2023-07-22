package Bank_Concurrency_petterson_synchronized.Aflevering.Opg2;

public class Main {

    private static int turn;

    private static boolean[] flag;

    public static void main(String[] args) {
        flag = new boolean[2];
        flag[0] = false;
        flag[1] = false;
        turn = 1;

        FaellesKlassen faellesKlassen = new FaellesKlassen();
        Traad traad1 = new Traad("Hej", faellesKlassen);
        Traad2 traad2 = new Traad2("Farvel", faellesKlassen);

        traad1.start();
        traad2.start();
    }

    public static boolean getFlag(int indeks) {
        return flag[indeks];
    }

    public static int getTurn() {
        return turn;
    }

    public static void setFlag(int indeks, boolean vaerdi) {flag[indeks] = vaerdi;}

    public static void setTurn(int setValue) {
        turn = setValue;
    }
}
