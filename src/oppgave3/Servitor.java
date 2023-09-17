package oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class Servitor implements Runnable {
    private BlockingQueue<Integer> brett;
    private String navn;
    private Random random = new Random();

    public Servitor(BlockingQueue<Integer> brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int tid = random.nextInt(5) + 2; // Tid det tar å servere en hamburger (mellom 2 og 6 sekunder)
                Thread.sleep(tid * 1000);
                int hamburgerNummer = brett.take();
                System.out.println(navn + " (servitør) tar av hamburger ◖" + hamburgerNummer + "◗. Brett: " + brett);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}