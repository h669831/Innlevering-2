package oppgave31;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        System.out.println("I denne simuleringen har vi");
        System.out.println(kokker.length + " kokker " + Arrays.toString(kokker));
        System.out.println(servitorer.length + " servitører " + Arrays.toString(servitorer));
        System.out.println("Kapasiteten til brettet er " + KAPASITET + " hamburgere.");
        System.out.println("Vi starter ...");

        HamburgerBrett brett = new HamburgerBrett(KAPASITET);

        for (String navn : kokker) {
            new Kokk(brett, navn).start();
        }

        for (String navn : servitorer) {
            new Servitor(brett, navn).start();
        }
    }
}
