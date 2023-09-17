package oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class Kokk implements Runnable {
    private BlockingQueue<Integer> brett;
    private String navn;
    private Random random = new Random();

    public Kokk(BlockingQueue<Integer> brett, String navn) {
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
                brett.put(hamburgerNummer);
                System.out.println(navn + " (kokk) legger på hamburger ◖" + hamburgerNummer + "◗. Brett: " + brett);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
}