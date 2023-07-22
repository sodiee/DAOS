package Deadlock_Lektion.kode.StackOpgave;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        TraadKlassePop traadKlassePop = new TraadKlassePop(stack);
        TraadKlassePush traadKlassePush = new TraadKlassePush(stack);

        traadKlassePush.start();
        traadKlassePop.start();

    }
}
