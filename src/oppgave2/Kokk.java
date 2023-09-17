package oppgave2;

import java.util.Random;

class Kokk extends Thread {
    private HamburgerBrett brett;
    private String navn;
    private Random random = new Random();

    public Kokk(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int tid = random.nextInt(5) + 2; // Tid det tar å lage en hamburger (mellom 2 og 6 sekunder)
                Thread.sleep(tid * 1000);
                int hamburgerNummer = HamburgerShop.hamburgerCounter++;
                brett.leggTilHamburger(hamburgerNummer, navn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}