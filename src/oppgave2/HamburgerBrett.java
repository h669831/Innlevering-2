package oppgave2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class HamburgerBrett {
    private Queue<Integer> hamburgere = new LinkedList<>();
    private final int kapasitet;

    public HamburgerBrett(int kapasitet) {
        this.kapasitet = kapasitet;
    }

    public synchronized void leggTilHamburger(int hamburgerNummer, String kokkNavn) throws InterruptedException {
        while (hamburgere.size() >= kapasitet) {
            System.out.println(kokkNavn + " (kokk) klar med hamburger " + hamburgerNummer + ", men brett fullt. Venter!");
            wait();
        }
        hamburgere.offer(hamburgerNummer);
        System.out.println(kokkNavn + " (kokk) legger på hamburger ◖" + hamburgerNummer + "◗. Brett: " + hamburgere);
        notifyAll();
    }

    public synchronized void taAvHamburger(String servitorNavn) throws InterruptedException {
        while (hamburgere.isEmpty()) {
            System.out.println(servitorNavn + " (servitør) ønsker å ta hamburger, men brett tomt. Venter!");
            wait();
        }
        int hamburgerNummer = hamburgere.poll();
        System.out.println(servitorNavn + " (servitør) tar av hamburger ◖" + hamburgerNummer + "◗. Brett: " + hamburgere);
        notifyAll();
    }
}