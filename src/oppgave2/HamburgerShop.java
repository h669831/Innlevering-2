package oppgave2;

public class HamburgerShop {
    public static int hamburgerCounter = 1;

public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;
        skrivUtHeader(kokker, servitorer, KAPASITET);
        HamburgerBrett brett = new HamburgerBrett(KAPASITET);
        for (String navn : kokker) {
            new Kokk(brett, navn).start();
        }
        for (String navn : servitorer) {
            new Servitor(brett, navn).start();
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