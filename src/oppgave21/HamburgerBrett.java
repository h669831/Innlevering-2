package oppgave21;

import java.util.Arrays;

public class HamburgerBrett {
	private final int kapasitet;
    private final Hamburger[] brett;
    private int antall = 0;

    public HamburgerBrett(int kapasitet) {
        this.kapasitet = kapasitet;
        brett = new Hamburger[kapasitet];
    }

    public synchronized void leggPaaHamburger(Hamburger hamburger, String kokkNavn) throws InterruptedException {
        while (antall >= kapasitet) {
            System.out.println(kokkNavn + " (kokk) klar med hamburger, men brett fullt. Venter!");
            wait();
        }
        brett[antall++] = hamburger;
        System.out.println(kokkNavn + " (kokk) legger på hamburger " + hamburger + ". Brett: " + Arrays.toString(brett));
        notifyAll();
    }

    public synchronized Hamburger taAvForsteHamburger(String servitorNavn) throws InterruptedException {
        while (antall == 0) {
            System.out.println(servitorNavn + " (servitør) ønsker å ta hamburger, men brett tomt. Venter!");
            wait();
        }
        Hamburger hamburger = brett[0];
        System.arraycopy(brett, 1, brett, 0, antall - 1);
        brett[antall - 1] = null; // Sett den siste posisjonen til null
        antall--;
        System.out.println(servitorNavn + " (servitør) tar av hamburger " + hamburger + ". Brett: " + Arrays.toString(brett));
        notifyAll();
        return hamburger;
    }
}