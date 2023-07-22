package Traade_opgaver.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Lottoraek> listeAfLottoRaek = new ArrayList<>();

        for (int i = 0; i < 1000001; i++) {
            Lottoraek lottoraek = new Lottoraek();
            listeAfLottoRaek.add(lottoraek);
        }
        List<Lottoraek> førsteHalvdel = listeAfLottoRaek.subList(0, 500000);
        List<Lottoraek> andenHalvdel = listeAfLottoRaek.subList(500000, 1000001);
        Thread traad1 = new Traad(førsteHalvdel);
        Thread traad2 = new Traad(andenHalvdel);
        traad1.start();
        traad2.start();
    }

    public static void testRigtige(List<Lottoraek> list) {
        Lottoraek rigtigeRække = new Lottoraek();
        long l1 = System.nanoTime();

        int nulRigtige = 0;
        int etRigtige = 0;
        int toRigtige = 0;
        int treRigtige = 0;
        int fireRigtige = 0;
        int femRigtige = 0;
        int seksRigtige = 0;
        int syvRigtige = 0;

        for (Lottoraek lottoraek : list) {
            if (lottoraek.antalrigtige(rigtigeRække) == 0) {
                nulRigtige++;
            } else if (lottoraek.antalrigtige(rigtigeRække) == 1) {
                etRigtige++;
            } else if (lottoraek.antalrigtige(rigtigeRække) == 2) {
                toRigtige++;
            } else if (lottoraek.antalrigtige(rigtigeRække) == 3) {
                treRigtige++;
            } else if (lottoraek.antalrigtige(rigtigeRække) == 4) {
                fireRigtige++;
            } else if (lottoraek.antalrigtige(rigtigeRække) == 5) {
                femRigtige++;
            } else if (lottoraek.antalrigtige(rigtigeRække) == 6) {
                seksRigtige++;
            } else if (lottoraek.antalrigtige(rigtigeRække) == 7) {
                syvRigtige++;
            }
        }
        System.out.println("Antal 0'ere: " + nulRigtige);
        System.out.println("Antal 1'ere: " + etRigtige);
        System.out.println("Antal 2'ere: " + toRigtige);
        System.out.println("Antal 3'ere: " + treRigtige);
        System.out.println("Antal 4'ere: " + fireRigtige);
        System.out.println("Antal 5'ere: " + femRigtige);
        System.out.println("Antal 6'ere: " + seksRigtige);
        System.out.println("Antal 7'ere: " + syvRigtige);
        System.out.println("Kontrol af total sum: " + (nulRigtige + etRigtige + toRigtige + treRigtige + fireRigtige + femRigtige + seksRigtige + syvRigtige) + " / " + 1000000);

        long l2 = System.nanoTime();
        System.out.println("Køretiden var " + (l2 - l1) / 1000000 + " millisekunder");
    }

    static class Traad extends Thread {
        List<Lottoraek> list;

        public Traad(List<Lottoraek> list) {
            this.list = list;
        }

        public void run() {
            testRigtige(list);
        }
    }
}
