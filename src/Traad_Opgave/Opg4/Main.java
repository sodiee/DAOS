package Traad_Opgave.Opg4;

public class Main {
    public static void main(String[] args) {
        /*
        Common_Klasse common_klasse = new Common_Klasse();
        common_klasse.modtagNyOrdre("1");
        System.out.println(common_klasse.getQueue());
        common_klasse.modtagNyOrdre("2");
        common_klasse.modtagNyOrdre("3");
        common_klasse.modtagNyOrdre("4");
        System.out.println(common_klasse.getQueue());
        common_klasse.lavNyOrdre("1");
        System.out.println(common_klasse.getQueue());
        common_klasse.lavNyOrdre("2");
        System.out.println(common_klasse.getQueue());
        common_klasse.modtagNyOrdre("5");
        common_klasse.modtagNyOrdre("6");
        common_klasse.lavNyOrdre("3");
        System.out.println(common_klasse.getQueue());
        common_klasse.lavNyOrdre("4");
        System.out.println(common_klasse.getQueue());
        common_klasse.lavNyOrdre("5");
        System.out.println(common_klasse.getQueue());
        common_klasse.modtagNyOrdre("7");
        common_klasse.modtagNyOrdre("8");
        common_klasse.modtagNyOrdre("9");
        System.out.println(common_klasse.getQueue());
*/

        Common_Klasse common_klasse = new Common_Klasse();
        Thread tjener1 = new Tjener(common_klasse);
        Thread tjener2 = new Tjener(common_klasse);
        Thread kok1 = new Kok(common_klasse);
        Thread kok2 = new Kok(common_klasse);

        tjener1.start();
        tjener2.start();
        kok1.start();
        kok2.start();;
    }
}
