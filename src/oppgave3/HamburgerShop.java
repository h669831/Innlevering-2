package oppgave3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Random;

class HamburgerShop {
    static int hamburgerCounter = 1;
    private static final int KAPASITET = 4;

    public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};

        BlockingQueue<Integer> brett = new ArrayBlockingQueue<>(KAPASITET);
        skrivUtHeader(kokker, servitorer, KAPASITET);

        for (String kokkNavn : kokker) {
            new Thread(new Kokk(brett, kokkNavn)).start();
        }

        for (String servitorNavn : servitorer) {
            new Thread(new Servitor(brett, servitorNavn)).start();
        }
    }

    private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
        System.out.println("I denne simuleringen har vi");
        System.out.println(kokker.length + " kokker " + printNavn(kokker));
        System.out.println(servitorer.length + " servitører " + printNavn(servitorer));
        System.out.println("Kapasiteten til brettet er " + kapasitet + " hamburgere.");
        System.out.println("Vi starter ...");
    }

    private static String printNavn(String[] navn) {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < navn.length; i++) {
            builder.append(navn[i]);
            if (i < navn.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}