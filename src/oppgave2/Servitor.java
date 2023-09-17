package oppgave2;

import java.util.Random;

class Servitor extends Thread {
    private HamburgerBrett brett;
    private String navn;
    private Random random = new Random();

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int tid = random.nextInt(5) + 2; // Tid det tar å servere en hamburger (mellom 2 og 6 sekunder)
                Thread.sleep(tid * 1000);
                brett.taAvHamburger(navn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
